package com.caique.appmarvel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.caique.appmarvel.R
import com.caique.appmarvel.data.model.character.ComicModel
import com.caique.appmarvel.databinding.ItemCharacterBinding
import com.caique.appmarvel.utils.limitDescription

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<ComicModel>() {
        override fun areContentsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areItemsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.description == newItem.description &&
                    oldItem.thumbnailModel.path == newItem.thumbnailModel.path &&
                    oldItem.thumbnailModel.extension == newItem.thumbnailModel.extension
        }
    }
    private val differ = AsyncListDiffer(this, differCallback)

    var characters: List<ComicModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.binding.apply {
            tvNameCharacter.text = character.name
            if (character.description == "") {
                tvDescriptionCharacter.text =
                    holder.itemView.context.getString(R.string.text_description_empty)
            } else {
                tvDescriptionCharacter.text = character.description.limitDescription(100)
            }

            Glide.with(holder.itemView.context)
                .load(character.thumbnailModel.path + "." + character.thumbnailModel.extension)
                .into(imgCharacter)
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(character)
            }
        }
    }

    private var onItemClickListener: ((ComicModel) -> Unit)? = null

    fun setClickListener(listener: (ComicModel) -> Unit) {
        onItemClickListener = listener
    }
}
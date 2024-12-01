package com.caique.appmarvel.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.caique.appmarvel.databinding.FragmentFavoriteCharacterBinding
import com.caique.appmarvel.ui.base.BaseFragment

class FavoriteCharacterFragment :
    BaseFragment<FragmentFavoriteCharacterBinding, FavoriteCharacterViewModel>() {

    override val viewModel: FavoriteCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteCharacterBinding =
        FragmentFavoriteCharacterBinding.inflate(inflater, container, false)
}
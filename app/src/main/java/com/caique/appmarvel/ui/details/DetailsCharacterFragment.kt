package com.caique.appmarvel.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.caique.appmarvel.databinding.FragmentDetailsCharacterBinding
import com.caique.appmarvel.ui.base.BaseFragment

class DetailsCharacterFragment :
    BaseFragment<FragmentDetailsCharacterBinding, DetailscaracterViewModel>() {

    override val viewModel: DetailscaracterViewModel by viewModels()


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsCharacterBinding =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)
}
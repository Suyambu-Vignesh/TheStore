package com.app.thestore.shelf.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.app.thestore.common.adapter.getAdapter
import com.app.thestore.databinding.FragmentProductDetailBinding
import com.app.thestore.shelf.ui.delegate.getProductDetailAdapterDelegate
import com.app.thestore.shelf.ui.viewmodel.ShelfViewModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

class ShelfDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val adapter by lazy {
        getAdapter(
            AdapterDelegatesManager(
                getProductDetailAdapterDelegate()
            )
        )
    }
    private val viewModel by activityViewModels<ShelfViewModel>()
    private val argument: ShelfDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pageState.value.data?.let { items ->
            binding.pagerShelfProduct.let {
                it.adapter = adapter
                adapter.items = items
                it.setCurrentItem(
                    argument.selectedIndex,
                    false
                )
            }
        }
    }
}
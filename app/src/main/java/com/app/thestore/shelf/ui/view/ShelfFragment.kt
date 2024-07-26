package com.app.thestore.shelf.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.thestore.common.adapter.getAdapter
import com.app.thestore.databinding.FragmentShelfBinding
import com.app.thestore.shelf.ui.delegate.getShelfProductAdapterDelegate
import com.app.thestore.shelf.ui.viewmodel.ShelfViewModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ShelfFragment : Fragment() {

    private lateinit var binding: FragmentShelfBinding
    private val viewModel by activityViewModels<ShelfViewModel> ()
    private val adapter by lazy {
        getAdapter(
            AdapterDelegatesManager(
                getShelfProductAdapterDelegate { index ->
                    val action = ShelfFragmentDirections.actionShelfToDetails(index)
                    findNavController().navigate(action)
                }
            )
        )
    }

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pageState.collectLatest {
                    binding.viewProgress.visibility = if (it.isLoading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }

                    it.data?.let { shelfProducts ->
                        binding.viewProductCollection.visibility = View.VISIBLE
                        adapter.items = shelfProducts

                    } ?: run {
                        binding.viewProductCollection.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShelfBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewProductCollection.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context)
        }

        viewModel.fetchProduct()
    }

    companion object {
        fun newInstance(): Fragment {
            return ShelfFragment()
        }
    }
}
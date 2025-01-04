package com.example.taipeitour.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeitour.R
import com.example.taipeitour.adapter.SpotAdapter
import com.example.taipeitour.databinding.FragmentHomeBinding
import com.example.taipeitour.viewmodel.SpotViewModel

class HomeFragment : Fragment() {


    private lateinit var adapter: SpotAdapter
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    val viewModel: SpotViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.hasFixedSize()
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.spotLiveData.observe(viewLifecycleOwner) { spot ->
            adapter = SpotAdapter(spot) {

                    selectSpot ->
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
                viewModel.selectedSpot.value = selectSpot
            }

            binding.recycler.adapter = adapter
//            binding.recycler.invalidate()
        }
//        viewModel.selectedSpot.observe(viewLifecycleOwner) {
//            _ ->
//            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
//        }
        viewModel.fetchSpot()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
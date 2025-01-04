package com.example.taipeitour.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.taipeitour.databinding.FragmentDetailBinding
import com.example.taipeitour.viewmodel.SpotViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() =  _binding!!

    val viewModel: SpotViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedSpot.observe(viewLifecycleOwner) { spot ->
            (activity as AppCompatActivity).supportActionBar?.title = spot.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
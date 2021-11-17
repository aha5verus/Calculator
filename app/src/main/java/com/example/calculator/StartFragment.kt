package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.calculator.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnStrengthFrag.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_strengthFragment)
            }
            btnDensityFrag.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_densityFragment)
            }
            btnDateFrag.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_calcDateFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
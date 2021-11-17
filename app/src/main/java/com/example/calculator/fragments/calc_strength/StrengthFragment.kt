package com.example.calculator.fragments.calc_strength

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.calculator.R
import com.example.calculator.databinding.FragmentStrengthBinding
import java.lang.String.format

class StrengthFragment : Fragment() {

    private var _binding: FragmentStrengthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStrengthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnStrengthCancel.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_strengthFragment_to_startFragment)
            }
            btnStrengthCalc.setOnClickListener {
                if(!isFieldEmpty()){
                    val result = "${getString(R.string.result_info)} ${getResult()} МПа"
                    tvResultStrength.visibility = View.VISIBLE
                    tvResultStrength.text = result
                }
            }
        }
    }

    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(edStrengthFirst.text.isNullOrEmpty()) edStrengthFirst.error = "Поле должно быть заполнено!"
            if(edStrengthSecond.text.isNullOrEmpty()) edStrengthSecond.error = "Поле должно быть заполнено!"
            return  edStrengthFirst.text.isNullOrEmpty() || edStrengthSecond.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edStrengthFirst.text.toString().toDouble()
            b = edStrengthSecond.text.toString().toDouble()
        }
        return ((a + b) / 2).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.calculator.fragments.calc_density

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.calculator.R
import com.example.calculator.databinding.FragmentDensityBinding

class DensityFragment : Fragment() {

    private var _binding: FragmentDensityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDensityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnDensityCancel.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_densityFragment_to_startFragment)
            }
            btnDensityCalc.setOnClickListener {
                if(!isFieldEmpty()){
                    val result = "${getString(R.string.result_info)} ${getResult()} кг"
                    tvResultDensity.visibility = View.VISIBLE
                    tvResultDensity.text = result
                }
            }
        }
    }


    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(edDensityFirst.text.isNullOrEmpty()) edDensityFirst.error = "Поле должно быть заполнено!"
            if(edDensitySecond.text.isNullOrEmpty()) edDensitySecond.error = "Поле должно быть заполнено!"
            return  edDensityFirst.text.isNullOrEmpty() || edDensitySecond.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edDensityFirst.text.toString().toDouble()
            b = edDensitySecond.text.toString().toDouble()
        }
        return ((a + b) / 2).toString()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
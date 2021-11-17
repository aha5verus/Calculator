package com.example.calculator.fragments.calc_date


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.navigation.Navigation
import com.example.calculator.R
import com.example.calculator.databinding.FragmentDateBinding
import java.util.*
import java.text.SimpleDateFormat





class DateFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private var _binding: FragmentDateBinding? = null
    private val binding get() = _binding!!

    private var day = 0
    private var month = 0
    private var year = 0

    private var savedDay = 0
    private var savedMonth = 0
    private var savedYear = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDateBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnDateCancel.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_calcDateFragment_to_startFragment)
            }
            pickDate()
        }
    }

    private fun getDateTimeCalendar() {
        val calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
    }

    private fun pickDate() {
        binding.btnCalcDate.setOnClickListener {
            getDateTimeCalendar()

            DatePickerDialog(requireActivity(), this, year, month, day).show()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        binding.tvStartDate.text = "$savedDay.${savedMonth + 1}.$savedYear"

        val c = Calendar.getInstance()

        c.set(year, month, dayOfMonth)
        c.add(Calendar.DAY_OF_MONTH,7)
        val sevenDays = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
        binding.tvSevendays.text = sevenDays.format(c.time)

        c.set(year, month, dayOfMonth)
        c.add(Calendar.DAY_OF_MONTH,28)
        val twentyEightDays = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
        binding.tvTwentyeigthDays.text = twentyEightDays.format(c.time)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
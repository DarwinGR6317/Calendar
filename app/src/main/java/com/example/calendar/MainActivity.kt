package com.example.calendar

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.calendar.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var calendario = Calendar.getInstance()
        var fecha = DatePickerDialog.OnDateSetListener { datepicker, year, month, day->
            calendario.set(Calendar.YEAR, year)
            calendario.set(Calendar.MONTH, month)
            calendario.set(Calendar.DAY_OF_MONTH, day)
            actualizarFecha(calendario)
        }

        binding.btnSeleccionar.setOnClickListener {
            DatePickerDialog(
                this,
                fecha,
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH),
            ).show()
        }


    }
    private fun actualizarFecha(calendar: Calendar){
        val formatoFecha= "dd-MM-yyy"
        val formatoSimple= SimpleDateFormat(formatoFecha, Locale.ENGLISH)
        binding.tvFecha.text  = formatoSimple.format(calendar.time)
    }
}
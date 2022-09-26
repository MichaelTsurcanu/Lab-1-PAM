package com.example.lab1code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import androidx.annotation.Nullable
import java.util.*


class MainActivity : AppCompatActivity() {

    var final_result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClickTest(view: View) {
        val c = Calendar.getInstance()

        val result = findViewById<TextView>(R.id.textView3)

        val year = findViewById<EditText>(R.id.editTextTextPersonName)
        val month = findViewById<EditText>(R.id.editTextTextPersonName2)
        val day = findViewById<EditText>(R.id.editTextTextPersonName3)





        try {
            if(year.text.toString().toInt()>2022 || month.text.toString().toInt()>12 || day.text.toString().toInt()>31)
            {
                result.text="Wrong Data!"
            }
            else
            {
                final_result = 2022 - year.text.toString().toInt()
                var tmp = final_result
                if (month.text.toString().toInt() > c.get(Calendar.MONTH).toString().toInt() + 1)
                {
                    final_result--;

                }

                if (day.text.toString().toInt() > c.get(Calendar.DAY_OF_MONTH).toString().toInt() && final_result==tmp)
                {
                    final_result--;
                }


                result.text = "You have " + final_result.toString() + " years"
            }


        } catch (e: Exception) {
            result.text="Wrong Data!"
        }

    }

    fun onClickReset(view: View) {
        findViewById<TextView>(R.id.textView3).text = ""
        findViewById<EditText>(R.id.editTextTextPersonName).text.clear()
        findViewById<EditText>(R.id.editTextTextPersonName2).text.clear()
        findViewById<EditText>(R.id.editTextTextPersonName3).text.clear()

    }
}
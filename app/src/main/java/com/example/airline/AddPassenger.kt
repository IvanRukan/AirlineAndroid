package com.example.airline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.airline.PassengerData.Passenger
import com.example.airline.PassengerData.PassengerViewModel

class AddPassenger : AppCompatActivity() {
    private lateinit var mPassengerViewModel: PassengerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_passenger)
        mPassengerViewModel = ViewModelProvider(this)[PassengerViewModel::class.java]
        val button: Button = findViewById<Button>(R.id.save_button)
        button.setOnClickListener{
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = findViewById<EditText>(R.id.PassengerName).text.toString()
        val age = findViewById<EditText>(R.id.PassngerAge).text.toString()
        val place = findViewById<EditText>(R.id.PassengerPlace).text.toString()

        if (inputCheck(name, age, place)) {
            val passenger = Passenger(0,name, age.toInt(), place.toInt())
            mPassengerViewModel.addPassenger(passenger)
            Toast.makeText(this, "Успешно добавлено!", Toast.LENGTH_LONG).show()

            val intent: Intent = Intent(
                this@AddPassenger,
                MainActivity::class.java
            )
            startActivity(intent)

        }
        else {
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name: String, age: String, place: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(place))
    }
}
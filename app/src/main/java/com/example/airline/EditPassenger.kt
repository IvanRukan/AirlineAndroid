package com.example.airline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.airline.PassengerData.Passenger
import com.example.airline.PassengerData.PassengerViewModel

class EditPassenger : AppCompatActivity() {
    private lateinit var mPassengerViewModel: PassengerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_passenger)
        mPassengerViewModel = ViewModelProvider(this)[PassengerViewModel::class.java]
        var args = intent.extras
        val name = findViewById<TextView>(R.id.PassengerNameUpdate)
        val age = findViewById<TextView>(R.id.PassngerAgeUpdate)
        val place = findViewById<TextView>(R.id.PassengerPlaceUpdate)
        val name_arg = args?.get("name")
        val age_arg = args?.get("age")
        val place_arg = args?.get("place")
        val id_arg = args?.get("id").toString()
        name.text = name_arg.toString()
        age.text = age_arg.toString()
        place.text = place_arg.toString()
        val update_button = findViewById<Button>(R.id.update_button)
        update_button.setOnClickListener{
            updateDataToDatabase(id_arg.toInt(), name.text.toString(), age.text.toString().toInt(), place.text.toString().toInt())
        }
        val delete_button = findViewById<Button>(R.id.delete_button)
        delete_button.setOnClickListener {
            deleteDataToDatabase(id_arg.toInt(), name.text.toString(), age.text.toString().toInt(), place.text.toString().toInt())

        }


    }
    private fun updateDataToDatabase(id: Int, name: String, age: Int, place: Int) {

        if (inputCheck(name)) {
            val passenger = Passenger(id,name, age, place)
            mPassengerViewModel.updatePassenger(passenger)
            Toast.makeText(this, "Успешно изменено!", Toast.LENGTH_LONG).show()

            val intent: Intent = Intent(
                this@EditPassenger,
                MainActivity::class.java
            )
            startActivity(intent)

        }
        else {
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }


    private fun deleteDataToDatabase(id: Int, name: String, age: Int, place: Int) {

        if (inputCheck(name)) {
            val passenger = Passenger(id,name, age, place)
            mPassengerViewModel.deletePassenger(passenger)
            Toast.makeText(this, "Успешно удалено!", Toast.LENGTH_LONG).show()

            val intent: Intent = Intent(
                this@EditPassenger,
                MainActivity::class.java
            )
            startActivity(intent)

        }
        else {
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
}

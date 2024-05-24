package com.example.airline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.airline.PassengerData.AdapterPassenger
import com.example.airline.PassengerData.PassengerViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private  lateinit var mPassengerViewModel: PassengerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val go_to: FloatingActionButton = findViewById(R.id.floatingActionButton)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = AdapterPassenger()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        mPassengerViewModel = ViewModelProvider(this)[PassengerViewModel::class.java]

        mPassengerViewModel.readAllData.observeForever( Observer { pc ->
            adapter.setData(pc)
        })
        go_to.setOnClickListener{ val intent: Intent = Intent(
            this@MainActivity,
            AddPassenger::class.java
        )
            startActivity(intent)
        }
    }
}
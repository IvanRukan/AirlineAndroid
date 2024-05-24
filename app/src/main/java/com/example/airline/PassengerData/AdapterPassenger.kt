package com.example.airline.PassengerData

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.airline.EditPassenger
import com.example.airline.R

class AdapterPassenger: RecyclerView.Adapter<AdapterPassenger.MyViewHolder>() {


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val type: TextView = itemView.findViewById(R.id.address_type)
        val name: TextView = itemView.findViewById(R.id.address_name)
        val edit: Button = itemView.findViewById<Button>(R.id.editAddress)

    }
    private var PassengerList = emptyList<Passenger>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.passengers_layout,parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = PassengerList[position]

        holder.type.text = "Возраст: " + currentItem.age + "\nМесто на борту: " + currentItem.place_on_board
        holder.name.text = currentItem.name
        holder.edit.setOnClickListener{
            var nameToPass: String;
            var AgeToPass: Int;
            var PlaceToPass: Int;
            var IdToPass: Int;
            nameToPass = currentItem.name
            PlaceToPass = currentItem.place_on_board
            AgeToPass = currentItem.age

            IdToPass = currentItem.id
            val i: Intent = Intent(it.context, EditPassenger::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("id", IdToPass)
            i.putExtra("name", nameToPass)
            i.putExtra("age", AgeToPass)
            i.putExtra("place", PlaceToPass)
            it.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return PassengerList.size
    }
    fun setData(passenger: List<Passenger>) {
        this.PassengerList = passenger
        notifyDataSetChanged()
    }
}
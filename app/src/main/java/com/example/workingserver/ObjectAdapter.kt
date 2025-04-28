package com.example.workingserver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workingserver.model.Object

class ObjectAdapter(private val objects: List<Object>) : RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    class ObjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val colorText: TextView = itemView.findViewById(R.id.colorText)
        val capacityText: TextView = itemView.findViewById(R.id.capacityText)
        val descriptionText: TextView = itemView.findViewById(R.id.descriptionText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_object, parent, false)
        return ObjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val obj = objects[position]
        holder.nameText.text = obj.name

        val color = obj.data?.get("color") ?: obj.data?.get("Color") ?: "No color"
        holder.colorText.text = "Color: $color"

        val capacity = obj.data?.get("capacity") ?: obj.data?.get("Capacity") ?: "Capacity not found"
        holder.capacityText.text = "Capacity: $capacity"

        val description = obj.data?.get("description") ?: obj.data?.get("Description") ?: "No description"
        holder.descriptionText.text = "Description: $description"
    }

    override fun getItemCount(): Int = objects.size
}

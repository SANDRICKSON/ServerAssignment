package com.example.workingserver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workingserver.model.Object

class ObjectAdapter(private val objects: List<Object>) : RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    class ObjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_object, parent, false)
        return ObjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val obj = objects[position]
        holder.textView.text = obj.name
    }

    override fun getItemCount() = objects.size
}

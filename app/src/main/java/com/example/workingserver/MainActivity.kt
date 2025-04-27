package com.example.workingserver

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workingserver.model.Object
import com.example.workingserver.network.RetrofitClient
import com.example.workingserver.ObjectAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchObjects()
    }

    private fun fetchObjects() {
        RetrofitClient.instance.getObjects().enqueue(object : Callback<List<Object>> {
            override fun onResponse(call: Call<List<Object>>, response: Response<List<Object>>) {
                if (response.isSuccessful) {
                    val objects = response.body() ?: emptyList()
                    adapter = ObjectAdapter(objects)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@MainActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Object>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

package com.list.adapter.example

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvProgramming: RecyclerView
    lateinit var adapter: ProgrammingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProgramming = findViewById(R.id.rvProgramming)
        adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1, "J", "Java")
        val p2 = ProgrammingItem(2, "K", "Kotlin")
        val p3 = ProgrammingItem(3, "A", "Android")

        adapter.submitList(listOf(p1, p2, p3))

        rvProgramming.layoutManager = LinearLayoutManager(this)
        rvProgramming.hasFixedSize()
        rvProgramming.adapter = adapter

        Handler(mainLooper).postDelayed(Runnable {
            val p3 = ProgrammingItem(3, "A", "Android")
            val p4 = ProgrammingItem(4, "R", "Ruby")
            val p5 = ProgrammingItem(5, "G", "Golang")
            val p6 = ProgrammingItem(6, "N", "Node")

            adapter.submitList(listOf(p3, p4, p5, p6))
        }, 4000)
    }
}
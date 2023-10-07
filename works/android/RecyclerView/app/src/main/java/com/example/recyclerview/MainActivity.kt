package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = getText(R.string.app_name)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val postalAddresses = mutableListOf(
            PostalAddress(
                "Claudio Verdi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
            PostalAddress(
                "Claudio Rossi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
            PostalAddress(
                "Giorgio Verdi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
        )

        val postalAddressAdapter = PostalAddressAdapter(postalAddresses) {
            Toast.makeText(
                applicationContext,
                postalAddresses[it].name,
                Toast.LENGTH_SHORT,
            ).show()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = postalAddressAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val gestureCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition

                Collections.swap(postalAddresses, fromPosition, toPosition)
                recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)

                return true
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder, direction: Int
            ) {
                val position = viewHolder.adapterPosition

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        postalAddresses.removeAt(position)
                        recyclerView.adapter?.notifyItemRemoved(position)
                    }
                    ItemTouchHelper.RIGHT -> {
                        postalAddresses.add(position, postalAddresses[position])
                        recyclerView.adapter?.notifyItemInserted(position)
                        recyclerView.adapter?.notifyItemChanged(position + 1)
                    }
                }
            }
        }

        ItemTouchHelper(gestureCallback).attachToRecyclerView(recyclerView)
    }
}
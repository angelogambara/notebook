package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        val addresses = mutableListOf(
            Address(
                "Claudio Verdi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
            Address(
                "Claudio Rossi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
            Address(
                "Giorgio Verdi",
                "via Roma",
                35,
                "81055",
                "Santa Maria Capua Vetere",
                "CE",
            ),
        )

        val adapter = Adapter(addresses) {
            Toast.makeText(
                applicationContext,
                addresses[it].name,
                Toast.LENGTH_SHORT,
            ).show()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
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

                Collections.swap(addresses, fromPosition, toPosition)
                recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)

                return true
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder, direction: Int
            ) {
                val position = viewHolder.adapterPosition

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        addresses.removeAt(position)
                        recyclerView.adapter?.notifyItemRemoved(position)
                    }
                    ItemTouchHelper.RIGHT -> {
                        addresses.add(position, addresses[position])
                        recyclerView.adapter?.notifyItemInserted(position)
                        recyclerView.adapter?.notifyItemChanged(position + 1)
                    }
                }
            }
        }

        ItemTouchHelper(gestureCallback).attachToRecyclerView(recyclerView)
    }

    // override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    //     menuInflater.inflate(R.menu.menu_main, menu)
    //     return true
    // }

    // override fun onOptionsItemSelected(item: MenuItem): Boolean {
    //     when(item.itemId) {
    //        R.id.frag1 -> supportFragmentManager.beginTransaction()
    //            .replace(R.id.fragmentContainerView, FragmentOne::class.java, null).commit()
    //        R.id.frag2 -> supportFragmentManager.beginTransaction()
    //            .replace(R.id.fragmentContainerView, FragmentTwo::class.java, null).commit()
    //         else -> return super.onOptionsItemSelected(item)
    //     }
    //     return true
    // }
}
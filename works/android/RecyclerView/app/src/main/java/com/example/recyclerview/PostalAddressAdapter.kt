package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostalAddressAdapter(
    private val postalAddresses: List<PostalAddress>,
    private val onItemClick: (Int) -> Unit,
    ) : RecyclerView.Adapter<PostalAddressAdapter.PostalAddressHolder>() {

    inner class PostalAddressHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.text_postal_address)

        init {
            itemView.setOnLongClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }

        fun bind(postalAddress: PostalAddress) = itemView.apply {
            textView.text = postalAddress.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostalAddressHolder {
        return PostalAddressHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_postaladdress, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return postalAddresses.size
    }

    override fun onBindViewHolder(holder: PostalAddressHolder, position: Int) {
        holder.bind(postalAddresses[position])
    }
}
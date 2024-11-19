package com.example.alejandra_alvarez_20241115_herpm1305

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ToyAdapter(private val context: Context, private val toys: List<Toy>) : BaseAdapter() {
    override fun getCount(): Int = toys.size
    override fun getItem(position: Int): Toy = toys[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val toy = toys[position]

        val toyImageView: ImageView = view.findViewById(R.id.toyImageView)
        val toyNameTextView: TextView = view.findViewById(R.id.toyNameTextView)
        val toyPriceTextView: TextView = view.findViewById(R.id.toyPriceTextView)

        toyImageView.setImageResource(toy.imageRes)
        toyNameTextView.text = toy.name
        toyPriceTextView.text = "Precio: $${toy.price}"

        return view
    }
}
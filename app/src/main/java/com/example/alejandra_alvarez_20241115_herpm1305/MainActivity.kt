package com.example.alejandra_alvarez_20241115_herpm1305

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toyAdapter: ToyAdapter
    private val toyList = mutableListOf(
        Toy("Carrito de madera", 10000, R.drawable.carrito),
        Toy("Avión de madera", 15000, R.drawable.avion),
        Toy("Puzzle de madera", 12000, R.drawable.puzzle)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.toyListView)
        toyAdapter = ToyAdapter(this, toyList)
        listView.adapter = toyAdapter

        registerForContextMenu(listView)

        // Listener para manejar el clic en un elemento de la lista
        listView.setOnItemClickListener { _, _, position, _ ->
            val toy = toyList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("TOY_NAME", toy.name)
                putExtra("TOY_PRICE", toy.price)
                putExtra("TOY_IMAGE", toy.imageRes)
            }
            startActivity(intent)
        }
    }

    // Crear el menú contextual
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.delete -> {
                // Eliminar el elemento seleccionado
                toyList.removeAt(info.position)
                toyAdapter.notifyDataSetChanged()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}




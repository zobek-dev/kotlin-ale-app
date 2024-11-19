package com.example.alejandra_alvarez_20241115_herpm1305

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Habilitar la barra de acción y mostrar la flecha de "Atrás"
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)  // Mostrar el botón "Atrás"
            title = "Detalles del Juguete"   // Título personalizado, si es necesario
        }

        // Obtén los datos del Intent
        val toyName = intent.getStringExtra("TOY_NAME")
        val toyPrice = intent.getIntExtra("TOY_PRICE", 0)
        val toyImageRes = intent.getIntExtra("TOY_IMAGE", 0)

        // Encuentra las vistas
        val toyImageView: ImageView = findViewById(R.id.toyImageView)
        val toyNameTextView: TextView = findViewById(R.id.toyNameTextView)
        val toyPriceTextView: TextView = findViewById(R.id.toyPriceTextView)

        // Configura las vistas con los datos recibidos
        toyImageView.setImageResource(toyImageRes)
        toyNameTextView.text = toyName
        toyPriceTextView.text = "Precio: $${toyPrice}"
    }
    // Manejar la acción del botón "Atrás"
    override fun onSupportNavigateUp(): Boolean {
        finish()  // Cierra la actividad actual y vuelve a la anterior
        return true
    }
}
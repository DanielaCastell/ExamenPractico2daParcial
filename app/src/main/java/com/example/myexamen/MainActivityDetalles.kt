package com.example.myexamen
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myexamen.databinding.ActivityMainDetallesBinding

class MainActivityDetalles : AppCompatActivity() {

    private lateinit var binding: ActivityMainDetallesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreContacto = intent.getStringExtra("nombreContacto")
        binding.NombreContacto.text = nombreContacto

        binding.BRegresar.setOnClickListener {
            finish()
        }
    }
}

package com.example.myexamen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.myexamen.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private val contactosList = mutableListOf<Agenda>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BAgregar.setOnClickListener {
            val nombre = binding.ENombre.text.toString()
            val noControl = binding.EControl.text.toString()

            if (nombre.isNotEmpty() && noControl.isNotEmpty()) {
                contactosList.add(Agenda(nombre, noControl))
                binding.VerContactos.text = "Contactos agregados: ${contactosList.size}"
            } else {
                Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.BVAgenda.setOnClickListener {
            val numeroControlBuscado = binding.ENumero.text.toString()
            val contactoEncontrado = contactosList.find { it.noControl == numeroControlBuscado }


            if (contactoEncontrado != null) {
                val intent = Intent(this, MainActivityDetalles::class.java)
                intent.putExtra("nombreContacto", contactoEncontrado.nombre)

                startActivity(intent)
            } else {
                Toast.makeText(this, "No se encontró un contacto con el número de control ingresado", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

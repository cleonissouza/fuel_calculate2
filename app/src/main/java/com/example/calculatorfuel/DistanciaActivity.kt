package com.example.calculatorfuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)

        val preco = intent.getFloatExtra("preco", 0f)
        val consumo = intent.getFloatExtra("consumo", 0f)

        val edtDistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btn_proximo3 = findViewById<Button>(R.id.btn_proximo3)

        btn_proximo3.setOnClickListener {
            val distancia = edtDistancia.text
            if (distancia?.isEmpty() == true){
                Snackbar.make(edtDistancia,
                    "preencha os dados ",
                    Snackbar.LENGTH_LONG)
                    .show()
            }else{
                val dist = distancia.toString().toInt()

                val totalPreco = (dist/consumo) * preco

                val intent = Intent(this, FinalActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                intent.putExtra("dist", dist)
                intent.putExtra("total", totalPreco)
                startActivity(intent)
            }
        }



    }
}
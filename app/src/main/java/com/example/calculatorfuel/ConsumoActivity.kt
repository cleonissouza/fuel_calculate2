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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val btnProximo2 = findViewById<Button>(R.id.btn_proximo2)

        val preco = intent.getFloatExtra("preco", 0f)

        btnProximo2.setOnClickListener {
            val consumo = edtConsumo.text.toString().toFloatOrNull()

            if (consumo != null){
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                startActivity(intent)
            }else{
                Snackbar.make(edtConsumo,
                    "preencha o campo vazio",
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
package com.example.calculatorfuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class PrecoAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_acitivity)

        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)
        val btnProximo = findViewById<Button>(R.id.btn_proximo)

        btnProximo.setOnClickListener {
            val preco = edtPreco.text.toString().toFloatOrNull()

            if (preco != null){
               val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("preco", preco)
                startActivity(intent)
            }else{
                Snackbar.make(edtPreco,
                    "preencha o campo vazio",
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
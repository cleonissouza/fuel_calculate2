package com.example.calculatorfuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final)

        val preco = intent.getFloatExtra("preco", 0f)
        val consumo = intent.getFloatExtra("consumo", 0f)
        val dist = intent.getIntExtra("dist", 0)
        val total = intent.getFloatExtra("total", 0f)

        val precoFinal = findViewById<TextView>(R.id.tv_preco_final)
        val consumoFinal = findViewById<TextView>(R.id.tv_consumo_final)
        val km = findViewById<TextView>(R.id.tv_Km_final)
        val result = findViewById<TextView>(R.id.tv_result)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)

        precoFinal.text = preco.toString()
        consumoFinal.text = consumo.toString()
        km.text = dist.toString()
        result.text = "R$ " + String.format("%.2f", total)

        btnNovoCalculo.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
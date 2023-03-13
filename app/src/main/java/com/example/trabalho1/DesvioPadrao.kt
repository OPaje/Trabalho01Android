package com.example.trabalho1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class DesvioPadrao : AppCompatActivity() {

    val valores : MutableList<Double> = mutableListOf()
    lateinit var et_valor : EditText
    lateinit var btn_inserir : Button
    lateinit var btn_calcular : Button
    lateinit var btn_resetar : Button
    lateinit var btn_proximo : Button
    lateinit var btn_menu : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desvio_padrao)

        et_valor = findViewById(R.id.et_valor)
        btn_inserir = findViewById(R.id.btn_inserir)
        btn_calcular = findViewById(R.id.btn_calcular)
        btn_resetar = findViewById(R.id.btn_resetar)
        btn_proximo = findViewById(R.id.btn_proximo)
        btn_menu = findViewById(R.id.btn_menu_desvio)

        fun calculaDesvioPadrao(valores: MutableList<Double>) : Double{
            var m = valores.average()
            var dp : Double = 0.0

            for(i in valores.indices){
                dp += (valores[i] - m).pow(2)
            }

            return dp/ valores.size
        }


        btn_inserir.setOnClickListener {
            if(valores.size < 10){
                valores.add(et_valor.text.toString().toDouble())
                et_valor.text.clear()
            }else{
                Toast.makeText(this, "O número máximo de elementos é 10", Toast.LENGTH_LONG).show()
                et_valor.text.clear()
            }
        }

        btn_calcular.setOnClickListener {
            var desvioPadrao : Double = calculaDesvioPadrao(valores)

            for (valor in valores){
                Log.i("Teste", "Lista $valor")
            }
            Log.i("Teste", "Desvio Padrão: $desvioPadrao")

            Toast.makeText(this, "Desvio Padrão: $desvioPadrao", Toast.LENGTH_LONG).show()
        }

        btn_resetar.setOnClickListener {
            valores.clear()
            Toast.makeText(this, "Valores Resetados", Toast.LENGTH_SHORT).show()
        }

        btn_proximo.setOnClickListener {
            val proximo = Intent(this, Primo::class.java)
            startActivity(proximo)
        }

        btn_menu.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

    }
}
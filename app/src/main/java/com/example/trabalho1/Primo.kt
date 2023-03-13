package com.example.trabalho1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalho1.databinding.PrimoBinding

class Primo : AppCompatActivity() {

    var v : MutableList<Int> = mutableListOf()
    lateinit var et_valor : EditText
    lateinit var btn_inserir : Button
    lateinit var btn_mostra_primos : Button
    lateinit var btn_reseta : Button

    /////// Usando viewBinding para linkar o objeto há uma ação ////////
    // substitui o findViewById
    // também elimina a necessidade de criar as variáveis acima
    lateinit var binding: PrimoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PrimoBinding.inflate(layoutInflater)
        //setContentView(R.layout.primo) //pode mudar esse comando
        setContentView(binding.root)

        et_valor = findViewById(R.id.et_valores)
        btn_inserir = findViewById(R.id.btn_inserir_primo)
        btn_mostra_primos = findViewById(R.id.btn_mostra_primos)
        btn_reseta = findViewById(R.id.btn_reseta_primos)

        fun findPrime(v : MutableList<Int>) {
            for(i in v.indices){
                if(!((v[i] % 2) == 0 && v[i] != 2 || v[i] == 1)){
                    Log.i("Primos", "O número ${v[i]} é primo. Posição: $i")
                    Toast.makeText(this, "Número: ${v[i]}. Posição: $i", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_inserir.setOnClickListener {
            v.add(et_valor.text.toString().toInt())
            et_valor.text.clear()
        }

        btn_mostra_primos.setOnClickListener {
            findPrime(v)
        }

        btn_reseta.setOnClickListener {
            v.clear()
            Toast.makeText(this, "Valores Resetados", Toast.LENGTH_LONG).show()
        }

        binding.btnProximoPrimo.setOnClickListener {
            val proximo = Intent(this, ParImpar::class.java)
            startActivity(proximo)
        }

        binding.btnMenuPrimo.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

    }
}
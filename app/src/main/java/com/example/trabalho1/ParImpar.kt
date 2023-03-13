package com.example.trabalho1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ParImpar : AppCompatActivity(){

    val v : MutableList<Double> = mutableListOf()
    val par : MutableList<Double> = mutableListOf()
    val impar : MutableList<Double> = mutableListOf()
    lateinit var et_valor : EditText
    lateinit var btn_inserir : Button
    lateinit var btn_mostra_par : Button
    lateinit var btn_mostra_impar : Button
    lateinit var btn_resetar : Button
    lateinit var btn_proximo : Button
    lateinit var btn_menu : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.par_impar)

        et_valor = findViewById(R.id.et_valor_par_impar)
        btn_inserir = findViewById(R.id.btn_inserir_par_impar)
        btn_mostra_impar = findViewById(R.id.btn_mostra_impar)
        btn_mostra_par = findViewById(R.id.btn_mostra_par)
        btn_resetar = findViewById(R.id.btn_reseta_par_impar)
        btn_proximo = findViewById(R.id.btn_proximo_par_impar)
        btn_menu = findViewById(R.id.btn_menu_par_impar)

        fun verificaParImpar(lista : MutableList<Double>) {
            for (valor in lista){
                if(valor % 2 == 0.0){
                    par.add(valor)
                }else{
                    impar.add(valor)
                }
            }
        }

        btn_inserir.setOnClickListener {
            v.add(et_valor.text.toString().toDouble())
            et_valor.text.clear()
        }

        btn_mostra_par.setOnClickListener {
            if(par.size > 0){
                for (valor in par){
                    Log.i("Par", "$valor é par")
                    Toast.makeText(this, "$valor", Toast.LENGTH_SHORT).show()
                }
            }else{
                verificaParImpar(v)
                for (valor in par){
                    Log.i("Par", "$valor é par")
                    Toast.makeText(this, "$valor", Toast.LENGTH_SHORT).show()
                }
            }

        }

        btn_mostra_impar.setOnClickListener {
            if(impar.size > 0){
                for(valor in impar){
                    Log.i("Ímpar", "$valor é ímpar")
                    Toast.makeText(this, "$valor", Toast.LENGTH_SHORT).show()
                }
            }else{
                verificaParImpar(v)
                for(valor in impar){
                    Log.i("Ímpar", "$valor é ímpar")
                    Toast.makeText(this, "$valor", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_resetar.setOnClickListener {
            v.clear()
            Toast.makeText(this, "Os valores foram resetados", Toast.LENGTH_LONG).show()
        }

        btn_proximo.setOnClickListener {
            var proximo = Intent(this, Matriz1::class.java)
            startActivity(proximo)
        }

        btn_menu.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

    }
}
package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.trabalho1.databinding.ActivityMatriz2Binding


class Matriz2 : AppCompatActivity() {

    lateinit var binding : ActivityMatriz2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatriz2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fun somarMatrizes(matriz1 : Array<IntArray>, matriz2: Array<IntArray>) : Array<IntArray>{
            var matrizResultado = Array(2){IntArray(2)}

            for(i in 0 until 2){
                for(j in 0 until 2){
                    matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j]
                }
            }

            return matrizResultado
        }

        fun criaMatrizOposta(matriz : Array<IntArray>) : Array<IntArray>{
            var matrizResultado = Array(2){IntArray(2)}

            for(i in 0 until 2){
                for(j in 0 until 2){
                    matrizResultado[i][j] = - matriz[i][j]
                }
            }

            return matrizResultado
        }

        /*fun subtrairMatrizes(matriz1 : Array<IntArray>, matriz2: Array<IntArray>) : Array<IntArray>{
            var matrizResultado = Array(2){IntArray(2)}

            for(i in 0 until 2){
                for(j in 0 until 2){
                    matrizResultado[i][j] = matriz1[i][j] - matriz2[i][j]
                }
            }

            return matrizResultado
        }*/

        fun subtrairMatrizes(matriz1 : Array<IntArray>, matriz2: Array<IntArray>) : Array<IntArray>{
            return somarMatrizes(matriz1, criaMatrizOposta(matriz2))
        }

        fun mostrarMatriz(matriz : Array<IntArray>) {
            for(i in 0 until 2){
                for(j in 0 until 2){
                    Log.i("Matriz", "Matriz[$i][$j]: " + matriz[i][j])
                }
            }
        }

        binding.btnResultadoMatriz2.setOnClickListener {
            var matriz1 = arrayOf(intArrayOf(9,6), intArrayOf(4,0))
            var matriz2 = arrayOf(intArrayOf(2,4), intArrayOf(-3,5))
            var opcao = binding.etOpcaoMatriz2.text.toString().toInt()

            when(opcao){
                1 -> {
                    mostrarMatriz(somarMatrizes(matriz1, matriz2))
                    Toast.makeText(this, "Resultado no Logcat", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    mostrarMatriz(subtrairMatrizes(matriz1, matriz2))
                    Toast.makeText(this, "Resultado no Logcat", Toast.LENGTH_SHORT).show()
                }
                3 -> Toast.makeText(this, "Essa eu não fiz ainda", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this, "Opção inválida", Toast.LENGTH_LONG).show()
            }


            binding.etOpcaoMatriz2.text.clear()
        }

        binding.btnProximoMatriz2.setOnClickListener {
            var proximo = Intent(this, MultiplicaMatriz::class.java)
            startActivity(proximo)
        }

        binding.btnMenuMatriz2.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }


    }
}
package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.trabalho1.databinding.ActivityMatriz1Binding


class Matriz1 : AppCompatActivity() {

    lateinit var binding: ActivityMatriz1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatriz1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fun somaColImpares(matriz : Array<IntArray>) : Float{
            var soma : Float = 0.0F
            for(i in 0 until 3){
                for(j in 0 until 6){
                    if((j+1) % 2 != 0){
                        soma += matriz[i][j]
                    }
                }
            }

            return soma
        }

        fun calcularMediaSegundaEQuartaCol(matriz : Array<IntArray>) : Double{
            val elementos : MutableList<Int> = mutableListOf()

            for (i in 0 until 3) {
                for (j in 0 until 6) {
                    if ((j + 1) == 2 || (j+1) == 4) {
                        elementos.add(matriz[i][j])
                    }
                }
            }
            return elementos.average()
        }


        fun mostrarMatriz(matriz : Array<IntArray>) {
            for(i in 0 until 3){
                for(j in 0 until 6){
                    Log.i("Matriz", "Matriz[$i][$j]: " + matriz[i][j])
                }
            }
        }

        fun trocaValoresSextaCol(matriz : Array<IntArray>) {
            for (i in 0 until 3) {
                var soma : Int = 0
                for (j in 0 until 6) {
                    if ((j + 1) == 1 || (j+1) == 2) {
                        soma += matriz[i][j]
                    }
                }

                matriz[i][5] = soma
            }
        }

        binding.btnResultadoMatriz1.setOnClickListener {
            var opcao = binding.etOpcao.text.toString().toInt()
            //var matriz1 = listOf(listOf(1,2,3,4,5,6), listOf(7,8,9,10,4,0), listOf(0,2,4,5,8,1))
            var matriz = arrayOf(intArrayOf(1,2,3,4,5,6), intArrayOf(7,8,9,10,4,0), intArrayOf(0,2,4,5,8,1))

            when (opcao){
                1 -> {
                    var soma : Float = somaColImpares(matriz)
                    Log.i("Matriz", "Soma: $soma")
                    Toast.makeText(this, "Soma: $soma", Toast.LENGTH_LONG).show()
                }
                2-> {
                    var media = calcularMediaSegundaEQuartaCol(matriz)

                    Log.i("Matriz", "Média: $media")
                    Toast.makeText(this, "Média: $media", Toast.LENGTH_LONG).show()
                }
                3-> {
                    trocaValoresSextaCol(matriz)
                    mostrarMatriz(matriz)
                    Toast.makeText(this, "Resultado no Logcat", Toast.LENGTH_SHORT).show()
                }
                else -> Toast.makeText(this, "Opção Inválida", Toast.LENGTH_LONG).show()
            }

            binding.etOpcao.text.clear()
        }

        binding.btnProximoEx.setOnClickListener {
            var proximo = Intent(this, Matriz2::class.java)
            startActivity(proximo)
        }

        binding.btnMenuMatriz1.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

    }
}
package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.trabalho1.databinding.ActivityMatrizElevadaBinding


class MatrizElevada : AppCompatActivity() {

    lateinit var binding : ActivityMatrizElevadaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatrizElevadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun mostrarMatriz(matriz : Array<IntArray>) {
            for(i in 0 until 3){
                for(j in 0 until 3){
                    Log.i("Matriz", "Matriz[$i][$j]: " + matriz[i][j])
                }
            }
        }

        fun calculaMatrizElevadaQuadrado(m1 : Array<IntArray>) : Array<IntArray>{
            var resultado = Array(3){IntArray(3)}

            for(i in 0 until 3){
                var soma : Int
                for(j in 0 until 3){
                    for(k in 0 until 3){
                        resultado[i][j] += m1[i][k] * m1[k][j]
                    }
                }
            }

            return resultado
        }

        binding.btnResultadoMatrizElevada.setOnClickListener {
            val m = arrayOf(intArrayOf(3,5,0), intArrayOf(2,0,4), intArrayOf(4,1,3))
            mostrarMatriz(calculaMatrizElevadaQuadrado(m))
            Toast.makeText(this, "Resultado no Logcat", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuMatrizElevada.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

    }
}
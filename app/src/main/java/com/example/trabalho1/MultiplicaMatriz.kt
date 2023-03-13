package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.trabalho1.databinding.ActivityMatriz3Binding

class MultiplicaMatriz : AppCompatActivity() {

    lateinit var binding : ActivityMatriz3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatriz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fun mostrarMatriz(matriz : Array<IntArray>) {
            for(i in 0 until 3){
                for(j in 0 until 3){
                    Log.i("Matriz", "Matriz[$i][$j]: " + matriz[i][j])
                }
            }
        }

        fun multiplicaMatriz(m1 : Array<IntArray>, m2: Array<IntArray>) : Array<IntArray>{
            var resultado = Array(3){IntArray(3)}

            for(i in 0 until 3){
                var soma : Int
                for(j in 0 until 3){
                    for(k in 0 until 3){
                        resultado[i][j] += m1[i][k] * m2[k][j]
                    }
                }
            }

            return resultado
        }

        binding.btnResultadoMatriz3.setOnClickListener {
            val m1 = arrayOf(intArrayOf(3,5,0), intArrayOf(2,0,4), intArrayOf(4,1,3))
            val m2 = arrayOf(intArrayOf(4,5,3), intArrayOf(2,1,8), intArrayOf(6,2,0))

            mostrarMatriz(multiplicaMatriz(m1, m2))
            Toast.makeText(this, "Resultado no Logcat", Toast.LENGTH_SHORT).show()
        }

        binding.btnProximoMatriz3.setOnClickListener {
            val proximo = Intent(this, MatrizElevada::class.java)
            startActivity(proximo)
        }

        binding.btnMenuMatriz3.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }
    }
}
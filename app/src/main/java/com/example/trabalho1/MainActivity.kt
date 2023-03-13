package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItem
import com.example.trabalho1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ex : Intent

        binding.etDesvioPadrao.setOnClickListener {
            ex = Intent(this, DesvioPadrao::class.java)
            startActivity(ex)
        }

        binding.etPrimo.setOnClickListener {
            ex = Intent(this, Primo::class.java)
            startActivity(ex)
        }

        binding.etParImpar.setOnClickListener {
            ex = Intent(this, ParImpar::class.java)
            startActivity(ex)
        }

        binding.etMatriz1.setOnClickListener {
            ex = Intent(this, Matriz1::class.java)
            startActivity(ex)
        }

        binding.etMatriz2.setOnClickListener {
            ex = Intent(this, Matriz2::class.java)
            startActivity(ex)
        }

        binding.etMatrizMultiplica.setOnClickListener {
            ex = Intent(this, MultiplicaMatriz::class.java)
            startActivity(ex)
        }

        binding.etMatrizQuadrado.setOnClickListener {
            ex = Intent(this, MatrizElevada::class.java)
            startActivity(ex)
        }

    }
}
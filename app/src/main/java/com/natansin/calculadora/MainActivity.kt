package com.natansin.calculadora

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.natansin.calculadora.databinding.ActivityMainBinding

import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
class MainActivity : AppCompatActivity() {
   private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //splashscrean do google
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.botaoZerar.setOnClickListener {
            binding.entrada.text = ""
            binding.saida.text = ""
        }

        binding.btnParenteseEsquerdo.setOnClickListener {
            binding.entrada.text = addTextEntrada("(")
        }
        binding.btnParenteseDireito.setOnClickListener {
            binding.entrada.text = addTextEntrada(")")
        }
        binding.btnN0.setOnClickListener {
            binding.entrada.text = addTextEntrada("0")
        }
        binding.btnN1.setOnClickListener {
            binding.entrada.text = addTextEntrada("1")
        }
        binding.btnN2.setOnClickListener {
            binding.entrada.text = addTextEntrada("2")
        }
        binding.btnN3.setOnClickListener {
            binding.entrada.text = addTextEntrada("3")
        }
        binding.btnN4.setOnClickListener {
            binding.entrada.text = addTextEntrada("4")
        }
        binding.btnN5.setOnClickListener {
            binding.entrada.text = addTextEntrada("5")
        }
        binding.btnN6.setOnClickListener {
            binding.entrada.text = addTextEntrada("6")
        }
        binding.btnN7.setOnClickListener {
            binding.entrada.text = addTextEntrada("7")
        }
        binding.btnN8.setOnClickListener {
            binding.entrada.text = addTextEntrada("8")
        }
        binding.btnN9.setOnClickListener {
            binding.entrada.text = addTextEntrada("9")
        }
        binding.btnPonto.setOnClickListener {
            binding.entrada.text = addTextEntrada(".")
        }
        binding.btnDivisao.setOnClickListener {
            binding.entrada.text = addTextEntrada("÷") // ALT + 0247
        }
        binding.btnMultiplicao.setOnClickListener {
            binding.entrada.text = addTextEntrada("×") // ALT + 0215
        }
        binding.btnSubtracao.setOnClickListener {
            binding.entrada.text = addTextEntrada("-")
        }
        binding.btnSomar.setOnClickListener {
            binding.entrada.text = addTextEntrada("+")
        }

        binding.btnResultado.setOnClickListener {
            resultado()
        }
    }

    private fun addTextEntrada(buttonValue: String): String {
        return "${binding.entrada.text}$buttonValue"
    }

    private fun expressaoDeEntrada(): String {
        var expression = binding.entrada.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun resultado() {
        try {
            val expression = expressaoDeEntrada()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // mostra messagem de error
                binding.saida.text = "Error"
                binding.saida.setTextColor(ContextCompat.getColor(this, R.color.vermelho))
            } else {
                // mostra Resultado
                binding.saida.text = DecimalFormat("0.######").format(result).toString()
                binding.saida.setTextColor(ContextCompat.getColor(this, R.color.verde1))
            }
        } catch (e: Exception) {
            // Sostra messagem de error
            binding.saida.text = "Error"
            binding.saida.setTextColor(ContextCompat.getColor(this, R.color.vermelho))
        }
    }
}
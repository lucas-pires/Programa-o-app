package com.example.ac1_yoshi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_calcula.setOnClickListener(this)
    }

    private fun validar(): Boolean {
        if (campo_nome.text.toString().isEmpty()) {
            campo_nome.error = "-"
            return false
        } else if (campo_pagamento.text.toString().isEmpty()) {
            campo_pagamento.error = "-"
            return false
        } else if (campo_produto.text.toString().isEmpty()) {
            campo_produto.error = "-"
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_calcula -> {
                if (validar()) {
                    val valor_produto = campo_produto.text.toString().toDouble()
                    val valor_pago = campo_pagamento.text.toString().toDouble()
                    val nome_produto = campo_nome.text
                    val troco = valor_pago - valor_produto

                    if (troco > 0) {
                        resultado.text = "Você comprou ${nome_produto} e seu troco é de R$${troco}"
                        resultado.setTextColor(Color.GREEN)
                        resultado.visibility = View.VISIBLE
                    }
                    else if(valor_pago < valor_produto){
                        resultado.text = "Valor invalido"
                        resultado.setTextColor(Color.RED)
                        resultado.visibility = View.VISIBLE
                    }
                    else {
                        resultado.text = "Não precisa de troco"
                        resultado.setTextColor(Color.RED)
                        resultado.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
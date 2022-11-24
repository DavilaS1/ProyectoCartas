package com.example.cartasduelo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var iv_carta1 : ImageView
    lateinit var iv_carta2: ImageView

    lateinit var tv_jugador1: TextView
    lateinit var tv_jugador2: TextView

    lateinit var tv_empate: TextView

    lateinit var b_repartir: Button

    lateinit var random: Random

    var jugador1 = 0
    var jugador2 = 0

    var cartasArray = intArrayOf(
            R.drawable.corazones2,
            R.drawable.corazones3,
            R.drawable.corazones4,
            R.drawable.corazones5,
            R.drawable.corazones6,
            R.drawable.corazones7,
            R.drawable.corazones8,
            R.drawable.corazones9,
            R.drawable.corazones10,
            R.drawable.corazones12,
            R.drawable.corazones13,
            R.drawable.corazones14,
            R.drawable.corazones15
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random

        //Objetos de inicio
        iv_carta1 = findViewById(R.id.iv_card1)
        iv_carta2 = findViewById(R.id.iv_card2)

        iv_carta1.setImageResource(R.drawable.carta_atras)
        iv_carta2.setImageResource(R.drawable.carta_atras)

        tv_jugador1 = findViewById(R.id.tv_player1)
        tv_jugador2 = findViewById(R.id.tv_player2)

        tv_empate = findViewById(R.id.tv_war)
        tv_empate.visibility = View.INVISIBLE

        b_repartir = findViewById(R.id.b_deal)
        b_repartir.setOnClickListener {
            //ocultar etiqueta de empate
            tv_empate.visibility = View.INVISIBLE

            //generar cartas
            val carta1 = random.nextInt(cartasArray.size)
            val carta2 = random.nextInt(cartasArray.size)

            //establecer imágenes
            setCardImage(carta1, iv_carta1)
            setCardImage(carta2, iv_carta2)

            //comparar cartas
            if (carta1 > carta2) {
                jugador1++
                tv_jugador1.text = "Jugador 1: $jugador1"
            } else if (carta1 < carta2) {
                jugador2++
                tv_jugador2.text = "Jugador 2: $jugador2"
            } else {
                //show war label
                tv_empate.visibility = View.VISIBLE
            }
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cartasArray[number])
    }
}
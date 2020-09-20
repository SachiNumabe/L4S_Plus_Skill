package com.example.l4s_plus_skill

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val fortuneArray = arrayOf<String>("大吉","吉","中吉","小吉","凶")
    val luckyItemArray = arrayOf<String>("ボタン電池","リチウム電池","ニッケル電池","アルカリ電池","マンガン電池")

    var fortuneRandomSelect = ""
    var luckyItemRandomSelect = ""
    var hex = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {

            colorSelect()

            fortuneRandomSelect = fortuneArray[Random().nextInt(5)]
            luckyItemRandomSelect = luckyItemArray[Random().nextInt(5)]

            mainTextView.text = fortuneRandomSelect
            itemTextView.text = luckyItemRandomSelect
        }

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "私の今日の運勢は"+ fortuneRandomSelect +"でした！ラッキーカラーは" +
                        hex +"、ラッキーアイテムは" + luckyItemRandomSelect + "です！")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    fun colorSelect() {
        val r = Random().nextInt(256)
        val g = Random().nextInt(256)
        val b = Random().nextInt(256)
        hex = java.lang.String.format("#%02x%02x%02x", r, g, b)
        colorTextView.text = hex
        colorTextView.setTextColor(Color.rgb(r, g, b))
    }
}



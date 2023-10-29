package com.colortype.app

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.colortype.app.databinding.ActiityAnswerBinding

class AnswerActivity: AppCompatActivity() {
    private lateinit var binding: ActiityAnswerBinding
    private var count = 0
    val arrAns1 = mapOf(
        "Blonde" to "light shades (pastel and light yellow)",
        "Light brown" to "warm colors (brown, orange and golden)",
        "Brown-haired" to "warm colors (brown, orange and golden)",
        "Chestnut" to "saturated colors (dark brown, burgundy and bluish-black)",
        "Black" to "saturated colors (dark brown, burgundy and bluish-black)"
    )

    val c11 = listOf(R.drawable.pastel, R.drawable.yellow)
    val c12 = listOf(R.drawable.brown, R.drawable.orange, R.drawable.golden)
    val c13 = listOf(R.drawable.brown, R.drawable.orange, R.drawable.golden)
    val c14 = listOf(R.drawable.dark_brown, R.drawable.burgundy, R.drawable.bluish_black)
    val c15 = listOf(R.drawable.dark_brown, R.drawable.burgundy, R.drawable.bluish_black)
    val arrC1 = listOf(c11, c12, c13, c14, c15)
    val arrAns2 = mapOf(
        "Very light" to "light and neutral shades (white, light pink, silver)",
        "Light" to "light and neutral shades (white, light pink, silver)",
        "Medium tone" to "rich and bright colors (red, purple, green)",
        "Dark" to "golden and dark shades (orange, bronze, blue)",
    )
    var c21 = listOf(R.drawable.white, R.drawable.l_pink, R.drawable.silver)
    val c22 = listOf(R.drawable.white, R.drawable.l_pink, R.drawable.silver)
    val c23 = listOf(R.drawable.red, R.drawable.purple, R.drawable.green)
    val c24 = listOf(R.drawable.orange, R.drawable.bronze, R.drawable.blue)
    val arrC2 = listOf(c21, c22, c23, c24)
    val arrAns3 = mapOf(
        "Blue" to "light and cool shades (blue, silver, purple)",
        "Green" to "warm shades (green, olive, brown)",
        "Gray" to "neutral and deep colors (gray, dark brown, black)",
        "Brown" to "all shades are well suited, but especially warm colors (coffee, orange, golden)",
    )
    val c31 = listOf(R.drawable.blue, R.drawable.silver, R.drawable.purple)
    val c32 = listOf(R.drawable.green, R.drawable.olive, R.drawable.brown)
    val c33 = listOf(R.drawable.gray, R.drawable.dark_brown, R.drawable.black)
    val c34 = listOf(R.drawable.coffee, R.drawable.orange, R.drawable.golden)
    val arrC3 = listOf(c31, c32, c33, c34)
    val arrAns4 = mapOf(
        "Burns and quickly tans" to "warm and bright colors (coral, yellow, orange)",
        "Slowly tans and rarely burns" to "neutral and delicate shades (beige, light pink, blue)",
        "Rarely tans and without burning" to "cool and light colors (silver, light blue, pale yellow)",
    )
    val c41 = listOf(R.drawable.coral, R.drawable.yellow, R.drawable.orange)
    val c42 = listOf(R.drawable.beige, R.drawable.l_pink, R.drawable.blue)
    val c43 = listOf(R.drawable.silver, R.drawable.l_blue, R.drawable.yellow)
    val arrC4 = listOf(c41, c42, c43)
    val arrAns5 = mapOf(
        "Bright" to "bright and contrasting colors (red, blue, yellow)",
        "Pastel" to "delicate and pastel colors (pink, blue, lavender)",
        "Saturated" to "saturated and deep colors (burgundy, dark blue, emerald)",
        "Neutral" to "neutral and natural shades (beige, gray)",
    )
    val c51 = listOf(R.drawable.red, R.drawable.blue, R.drawable.yellow)
    val c52 = listOf(R.drawable.pink, R.drawable.blue, R.drawable.lavender)
    val c53 = listOf(R.drawable.burgundy, R.drawable.dark_blue, R.drawable.emerald)
    val c54 = listOf(R.drawable.beige, R.drawable.gray)
    val arrC5 = listOf(c51, c52, c53, c54)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiityAnswerBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        val array = intent.extras!!.getString("answers")!!.split(":")
        createView(array)
    }

    private fun createView(array: List<String>) {
        for (i in array) {
            createText(i)
            createColors(i)
            count++
        }
    }

    private fun createColors(text: String) {
        val views = when (count) {
            0 -> {
                listOf<TextView>(binding.color11, binding.color12, binding.color13, binding.color14)
            }
            1 -> {
                listOf<TextView>(binding.color21, binding.color22, binding.color23, binding.color24)
            }
            2 -> {
                listOf<TextView>(binding.color31, binding.color32, binding.color33, binding.color34)

            }
            3 -> {
                listOf<TextView>(binding.color41, binding.color42, binding.color43, binding.color44)
            }
            4 -> {
                listOf<TextView>(binding.color51, binding.color52, binding.color53, binding.color54)
            }
            else -> {
                listOf<TextView>(binding.color11, binding.color12, binding.color13, binding.color14)
            }
        }
        val answers = when (count) {
            0 -> {arrAns1}
            1 -> {arrAns2}
            2 -> {arrAns3}
            3 -> {arrAns4}
            4 -> {arrAns5}
            else -> {arrAns1}
        }
        val colors = when (count) {
            0 -> {arrC1}
            1 -> {arrC2}
            2 -> {arrC3}
            3 -> {arrC4}
            4 -> {arrC5}
            else -> {arrC1}
        }


        for (i in answers.keys) {
            if (i == text) {
                val locColors: List<Int> = colors[answers.keys.indexOf(i)]
                Log.d("adadada", "loccolors $locColors")

                val cC = locColors.size
                if (cC < 4) {
                    views.last().visibility = View.GONE
                    views.dropLast(views.lastIndex)
                }
                if (cC < 3) {
                    views.last().visibility = View.GONE
                    views.dropLast(views.lastIndex)
                }
                for (j in locColors.indices) {
                    views[j].background = resources.getDrawable(locColors[j])
                }
            }
        }

    }

    private fun createText(text: String) {
        val textView = when (count) {
            0 -> {binding.ans1}
            1 -> {binding.ans2}
            2 -> {binding.ans3}
            3 -> {binding.ans4}
            4 -> {binding.ans5}
            else -> {binding.ans1}
        }
        val answers = when (count) {
            0 -> {arrAns1}
            1 -> {arrAns2}
            2 -> {arrAns3}
            3 -> {arrAns4}
            4 -> {arrAns5}
            else -> {arrAns1}
        }
        textView.text = "These colors will suit you: " + answers[text]

    }
}
package com.colortype.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.get
import androidx.core.view.marginTop
import com.colortype.app.databinding.ActivityQuestBinding

class QuestActivity: AppCompatActivity() {
    private lateinit var binding: ActivityQuestBinding
    private val arrayQuest = listOf(
        "What is your natural hair color?",
        "What is your natural skin color?",
        "What is your natural eye color?",
        "What is your reaction to sunlight?",
        "What color of clothes do you usually like to wear?",
    )
    private val arrayAns1 = listOf(
        "Blonde",
        "Light brown",
        "Brown-haired",
        "Chestnut",
        "Black"
    )
    private val arrayAns2 = listOf(
        "Very light",
        "Light",
        "Medium tone",
        "Dark"
    )
    private val arrayAns3 = listOf(
        "Blue",
        "Green",
        "Gray",
        "Brown"
    )
    private val arrayAns4 = listOf(
        "Burns and quickly tans",
        "Slowly tans and rarely burns",
        "Rarely tans and without burning"
    )
    private val arrayAns5 = listOf(
        "Bright",
        "Pastel",
        "Saturated",
        "Neutral"
    )

    private var count = 0
    private var ans1 = ""
    private var ans2 = ""
    private var ans3 = ""
    private var ans4 = ""
    private var ans5 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        askQuest()
        binding.buttonNext.setOnClickListener {
            count++
            binding.linLayout.removeAllViews()
            if (count >= arrayQuest.size) {
                val answers = "$ans1:$ans2:$ans3:$ans4:$ans5"
                startActivity(
                    Intent(this, AnswerActivity::class.java)
                        .putExtra("answers", answers)
                )
            } else {
                askQuest()
            }
        }
    }

    private fun askQuest() {
        createQuest(count)
        createTextQuest(count)
    }

    private fun createQuest(count: Int) {
        binding.textQuest.text = arrayQuest[count]
        Log.d("ada", "текст вопроса ${arrayQuest[count]}")
    }

    var tv: TextView? = null


    @SuppressLint("ResourceAsColor")
    private fun createTextQuest(count: Int) {
        val array: List<String> = when (count) {
            0 -> {
                arrayAns1
            }

            1 -> {
                arrayAns2
            }

            2 -> {
                arrayAns3
            }

            3 -> {
                arrayAns4
            }

            4 -> {
                arrayAns5
            }

            else -> {
                listOf<String>()
            }
        }
        Log.d("ada", "список вопросов $array")
        for (i in array) {
            val textView = TextView(this)
            textView.textSize = 24f
            textView.text = i
            textView.height = 80
            textView.setOnClickListener {
                when (count) {
                    0 -> {
                        ans1 = textView.text.toString()
                        tv?.let { v ->
                            v.background = null
                        }
                        tv = textView
                    }

                    1 -> {
                        ans2 = textView.text.toString()
                        tv?.let { v ->
                            v.background = null
                        }
                        tv = textView
                    }

                    2 -> {
                        ans3 = textView.text.toString()
                        tv?.let { v ->
                            v.background = null
                        }
                        tv = textView
                    }

                    3 -> {
                        ans4 = textView.text.toString()
                        tv?.let { v ->
                            v.background = null
                        }
                        tv = textView
                    }

                    4 -> {
                        ans5 = textView.text.toString()
                        tv?.let { v ->
                            v.background = null
                        }
                        tv = textView
                    }
                }

                it.background = resources.getDrawable(R.drawable.my_bg)
            }
            binding.linLayout.addView(textView)
        }
    }


}



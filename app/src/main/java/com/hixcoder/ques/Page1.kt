package com.hixcoder.ques

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.page1.*
import java.lang.Exception
import java.util.*

class Page1 : AppCompatActivity() {

    var ques:Array<String>? = null
    var ans:Array<String>? = null
    var index:Int? = null
    var defaultanswer = "Press the light button for answer"
    lateinit var TtoS:TextToSpeech

// this is the principal function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.page1)

        // to define the answer and the question arrays
        ques = resources.getStringArray(R.array.ques)
        ans = resources.getStringArray(R.array.ans)
        index = 0

        Page1font ()


        // for transfer text to speech
        TtoS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                //if there is no error then set language
                TtoS.language = Locale.FRANCE
            }
        })

    }

// this function is responsible about the font of the page1 activity
    private fun Page1font ()
    {
        tv3_page1.text = ques!![index!!]
        tv1_page1.text = "/${index!!+1}"
        tv2_page1.text = ques!!.size.toString()
        tv4_page1.text = defaultanswer
        tv4_page1.setTextColor(Color.GRAY)
    }

// this is a function for the buttons action of the page1 activity

fun ButtonAction(view: View?)
    {
        when(view?.id)
        {
            // button: light_bulb
            R.id.b3_page1 ->
            {
                tv4_page1.text = ans!![index!!]
                tv4_page1.setTextColor(Color.RED)
            }

            // button: next_1
            R.id.b2_page1 ->
            {
                try
                {
                    index = index!! + 1
                    Page1font ()
                }
                catch (ex: Exception)
                {
                    index = 10 - ques!!.size
                    Page1font ()
                }
            }

            // button: back_1
            R.id.b4_page1 ->
            {
                try
                {
                    index = index!! - 1
                    Page1font ()
                }
                catch (ex: Exception)
                {
                    index =  ques!!.size - 1
                    Page1font ()
                }
            }

            // button: mute_1
            R.id.b1_page1 ->
            {
                // for read the textView: tv3_page1
                TtoS.speak(tv3_page1.text, TextToSpeech.QUEUE_FLUSH ,null ,null)
            }
        }
    }
}

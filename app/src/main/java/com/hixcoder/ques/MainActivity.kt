package com.hixcoder.ques

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
    }

    fun Button0(view:View)
    {
        when(view)
        {
            // for going to the page1
            b1_main ->
            {
                var intent0 = Intent("com.hixcoder.Page1")
                startActivity(intent0)
            }
            // for going to the market ; and see the details
            b2_main ->
            {
               try
               {
                   var uri = Uri.parse("market://details?id $packageName")
                   var intent1 = Intent(Intent.ACTION_VIEW)
                   intent1.data = uri
                   startActivity(intent1)
               }catch (ex:Exception)
               {
                   var uri = Uri.parse("http://play.google.com/store/apps/details?id $packageName")
                   var intent1 = Intent(Intent.ACTION_VIEW)
                   intent1.data = uri
                   startActivity(intent1)
               }
            }
        }
    }
}
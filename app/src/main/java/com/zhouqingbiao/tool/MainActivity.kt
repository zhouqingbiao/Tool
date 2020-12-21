package com.zhouqingbiao.tool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toCube(view: View) {
        val intent = Intent(this, CubeActivity::class.java)
        startActivity(intent)
    }

    fun toCreditCard(view: View) {
        val intent = Intent(this, CreditCardActivity::class.java)
        startActivity(intent)
    }

    fun toPushUp(view: View) {
        val intent = Intent(this, PushUpActivity::class.java)
        startActivity(intent)
    }

    fun toCuoGuDao(view: View) {
        val intent = Intent(this, CuoGuDaoActivity::class.java)
        startActivity(intent)
    }
}
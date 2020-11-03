package com.zhouqingbiao.tool

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PushUpActivity : AppCompatActivity() {

    private var calendar: Calendar = Calendar.getInstance()

    var dom = (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)).toList().sorted()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_up)

        findViewById<Button>(R.id.PushUpButton).text = dom.first().toString();
        dom -= dom.first();
        dom.sorted();
    }

    fun onClick(view: View) {
        //设置总时长60s, 每1s触发一次onTick
        val cdt: CountDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(l: Long) {
                // l 返回的是剩余毫秒数
                findViewById<Button>(R.id.PushUpButton).text = (l / 1000).toString();
            }

            override fun onFinish() {
                //倒计时结束后调用
                findViewById<Button>(R.id.PushUpButton).text = dom.first().toString();
                dom -= dom.first();
                dom.sorted();
            }
        }

        cdt.start();
    }
}
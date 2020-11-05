package com.zhouqingbiao.tool

import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class PushUpActivity : AppCompatActivity() {

    private var calendar: Calendar = Calendar.getInstance()

    // 拿到当前月的天数并转成list
    var dom = (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)).toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_up)

        // 解释: 给window设置一个标记 - 保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // 默认显示第一天
        findViewById<Button>(R.id.PushUpButton).text = dom.first().toString();
        // 移除使用过的天
        dom -= dom.first();
    }

    fun onClick(view: View) {
        val pushUpButton = findViewById<Button>(R.id.PushUpButton)

        // 默认倒计时60秒
        var millisInFuture: Long = 60000

        // 按照天数进行倒计时折算
        when (pushUpButton.text) {
            "1" -> millisInFuture = 5000
            "2" -> millisInFuture = 10000
            "3" -> millisInFuture = 15000
            "4" -> millisInFuture = 20000
            "5" -> millisInFuture = 25000
            "6" -> millisInFuture = 30000
            "7" -> millisInFuture = 35000
            "8" -> millisInFuture = 40000
            "9" -> millisInFuture = 45000
            "10" -> millisInFuture = 50000
            "11" -> millisInFuture = 55000
            else -> {
                millisInFuture = 60000
            }
        }

        //设置总时长60s, 每1s触发一次onTick
        val cdt: CountDownTimer = object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(l: Long) {
                // l 返回的是剩余毫秒数
                pushUpButton.text = (l / 1000).toString();
                // 倒计时期间禁止使用按钮
                pushUpButton.isClickable = false;
            }

            //倒计时结束后调用
            override fun onFinish() {
                // 结束时播放通知音
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rt = RingtoneManager.getRingtone(applicationContext, uri)
                rt.play()
                // 显示新的天数
                pushUpButton.text = dom.first().toString();
                // 倒计时结束释放使用按钮
                pushUpButton.isClickable = true;
                // 移除使用过的天
                dom -= dom.first();
            }
        }
        // 开始计时
        cdt.start();
    }
}
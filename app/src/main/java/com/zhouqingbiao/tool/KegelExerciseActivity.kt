package com.zhouqingbiao.tool

import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class KegelExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegel_exercise)

        // 解释: 给window设置一个标记 - 保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    fun onClick(view: View) {

        // 默认倒计时24秒
        var millisInFuture: Long = 24000

        val shrink = findViewById<TextView>(R.id.shrink)

        val relax = findViewById<TextView>(R.id.relax)


        //每1s触发一次onTick
        val cdt: CountDownTimer = object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(l: Long) {
                // l 返回的是剩余毫秒数

                if (l >= 12000) {
                    shrink.text = (l / 1000 - 12).toString();
                } else {
                    relax.text = (l / 1000).toString();
                }

            }

            //倒计时结束后调用
            override fun onFinish() {
                // 结束时播放通知音
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rt = RingtoneManager.getRingtone(applicationContext, uri)
                rt.play()
                shrink.text = 12.toString();
                relax.text = 12.toString();
            }
        }
        // 开始计时
        cdt.start();
    }
}
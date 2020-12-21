package com.zhouqingbiao.tool

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class CuoGuDaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuo_gu_dao)

        // 解释: 给window设置一个标记 - 保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    fun onClick(view: View) {
        // 禁用按钮
        findViewById<Button>(R.id.button).isClickable = false

        // 获取震动类
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // 间隔12秒震动一次
        val timings = longArrayOf(0, 12000)
        // 无限重复震动
        val repeat = 0

        // SDK判断
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createWaveform(timings, repeat))
        } else {
            vibrator.vibrate(timings, repeat)
        }

        // 默认12分钟
        val millisInFuture: Long = 720000

        // 间隔一秒显示时间
        val countDownInterval: Long = 1000

        // 计时
        val cdt: CountDownTimer = object : CountDownTimer(millisInFuture, countDownInterval) {
            // 倒计时开始时调用
            override fun onTick(l: Long) {
                // 显示倒计时时间
                findViewById<TextView>(R.id.textView).text = (l / 1000).toString()
            }

            // 倒计时结束时调用
            override fun onFinish() {
                // 恢复按钮
                findViewById<Button>(R.id.button).isClickable = true

                // 重置时间显示
                findViewById<TextView>(R.id.textView).text = null

                // 取消震动
                vibrator.cancel()
            }
        }

        // 开始计时
        cdt.start();
    }
}
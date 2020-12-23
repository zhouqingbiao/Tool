package com.zhouqingbiao.tool

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
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
        findViewById<Button>(R.id.go).isClickable = false

        // 获取震动类
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // 间隔12秒震动一次
        val timings = longArrayOf(0, 12000)

        // 是否重复震动：-1仅一次；0无限重复
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

        // 间隔十二秒显示动作
        val countDownIntervalVibrator: Long = 12000

        // 计时--动作
        val cdtVibrator: CountDownTimer =
            object : CountDownTimer(millisInFuture, countDownIntervalVibrator) {
                // 倒计时开始时调用
                override fun onTick(l: Long) {
                    // 切换动作显示
                    if (findViewById<TextView>(R.id.sr).text == "" || findViewById<TextView>(R.id.sr).text == "Relax") {
                        findViewById<TextView>(R.id.sr).text = "Shrink"
                    } else if (findViewById<TextView>(R.id.sr).text == "Shrink") {
                        findViewById<TextView>(R.id.sr).text = "Relax"
                    }
                }

                // 倒计时结束时调用
                override fun onFinish() {
                    // 重置动作显示
                    findViewById<TextView>(R.id.sr).text = null
                }
            }

        // 开始计时--动作
        cdtVibrator.start();

        // 计时·真
        val cdt: CountDownTimer = object : CountDownTimer(millisInFuture, countDownInterval) {
            // 倒计时开始时调用
            override fun onTick(l: Long) {
                // 显示倒计时时间
                findViewById<TextView>(R.id.countdown).text = (l / 1000).toString()
            }

            // 倒计时结束时调用
            override fun onFinish() {
                // 结束时播放通知音
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rt = RingtoneManager.getRingtone(applicationContext, uri)
                rt.play()

                // 取消震动
                vibrator.cancel()

                // 重置时间显示
                findViewById<TextView>(R.id.countdown).text = null

                // 恢复按钮
                findViewById<Button>(R.id.go).isClickable = true
            }
        }

        // 开始计时·真
        cdt.start();
    }
}
package com.zhouqingbiao.tool

import android.content.Context
import android.os.*
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CuoGuDaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuo_gu_dao)

        // 解释: 给window设置一个标记 - 保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    fun onClick(view: View) {

        findViewById<Button>(R.id.button).isClickable = false

        // 获取震动类
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        val timings = longArrayOf(0, 12000)
        val repeat = 0

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createWaveform(timings, repeat))
        } else {
            vibrator.vibrate(timings, repeat)
        }
    }
}
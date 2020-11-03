package com.zhouqingbiao.tool

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CreditCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)

        // 银行
        val banks = mapOf(1 to "中国农业银行", 2 to "中国建设银行", 3 to "中国银行", 4 to "中国工商银行", 0 to "中国邮政储蓄银行")

        // 日历
        var calendar: Calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH) + 1
        var dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        var dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)

        findViewById<TextView>(R.id.date).text =
            year.toString() + "年" + month.toString() + "月" + dayOfMonth.toString() + "日"
        findViewById<TextView>(R.id.dayOfYear).text = dayOfYear.toString()
        findViewById<TextView>(R.id.bank).text = banks[dayOfYear % banks.size]
    }
}
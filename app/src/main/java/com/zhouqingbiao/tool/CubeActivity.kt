package com.zhouqingbiao.tool

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CubeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cube)

        // 解释: 给window设置一个标记 - 保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // 初始化就随机显示CFOP图片、赋予tag、从MutableList中移除初始CFOP信息
        val f2lTemp = f2lTemps.random()
        findViewById<ImageView>(R.id.f2lImageView).setImageResource(f2lTemp)
        findViewById<ImageView>(R.id.f2lImageView).tag = f2lTemp
        f2lTemps.remove(f2lTemp)

        val ollTemp = ollTemps.random()
        findViewById<ImageView>(R.id.ollImageView).setImageResource(ollTemp)
        findViewById<ImageView>(R.id.ollImageView).tag = ollTemp
        ollTemps.remove(ollTemp)

        val pllTemp = pllTemps.random()
        findViewById<ImageView>(R.id.pllImageView).setImageResource(pllTemp)
        findViewById<ImageView>(R.id.pllImageView).tag = pllTemp
        pllTemps.remove(pllTemp)

        // 根据Switch开关是否显示公式
        if (findViewById<Switch>(R.id.formulaSwitch).isChecked) {
            findViewById<TextView>(R.id.f2lFormulasTextView).text = f2lFormulas[f2lTemp]
            findViewById<TextView>(R.id.ollFormulasTextView).text = ollFormulas[ollTemp]
            findViewById<TextView>(R.id.pllFormulasTextView).text = pllFormulas[pllTemp]
        } else {
            findViewById<TextView>(R.id.f2lFormulasTextView).text = null
            findViewById<TextView>(R.id.ollFormulasTextView).text = null
            findViewById<TextView>(R.id.pllFormulasTextView).text = null
        }
    }

    // Switch开关点击事件
    fun formulaSwitch(view: View) {
        if (findViewById<Switch>(R.id.formulaSwitch).isChecked) {

            findViewById<TextView>(R.id.f2lFormulasTextView).text =
                f2lFormulas[findViewById<ImageView>(R.id.f2lImageView).tag]

            findViewById<TextView>(R.id.ollFormulasTextView).text =
                ollFormulas[findViewById<ImageView>(R.id.ollImageView).tag]

            findViewById<TextView>(R.id.pllFormulasTextView).text =
                pllFormulas[findViewById<ImageView>(R.id.pllImageView).tag]
        } else {
            findViewById<TextView>(R.id.f2lFormulasTextView).text = null
            findViewById<TextView>(R.id.ollFormulasTextView).text = null
            findViewById<TextView>(R.id.pllFormulasTextView).text = null
        }
    }

    // F2L图片资源
    private val f2lImages = listOf(
        R.mipmap.f2l1,
        R.mipmap.f2l2,
        R.mipmap.f2l2_1,
        R.mipmap.f2l2_2,
        R.mipmap.f2l3,
        R.mipmap.f2l3_1,
        R.mipmap.f2l3_2,
        R.mipmap.f2l4,
        R.mipmap.f2l5,
        R.mipmap.f2l6,
        R.mipmap.f2l7,
        R.mipmap.f2l8,
        R.mipmap.f2l9,
        R.mipmap.f2l10,
        R.mipmap.f2l11,
        R.mipmap.f2l12,
        R.mipmap.f2l13,
        R.mipmap.f2l14,
        R.mipmap.f2l15,
        R.mipmap.f2l16,
        R.mipmap.f2l17,
        R.mipmap.f2l18,
        R.mipmap.f2l19,
        R.mipmap.f2l20,
        R.mipmap.f2l21,
        R.mipmap.f2l22,
        R.mipmap.f2l23,
        R.mipmap.f2l24,
        R.mipmap.f2l25,
        R.mipmap.f2l26,
        R.mipmap.f2l27,
        R.mipmap.f2l28,
        R.mipmap.f2l29,
        R.mipmap.f2l30,
        R.mipmap.f2l31,
        R.mipmap.f2l32,
        R.mipmap.f2l33,
        R.mipmap.f2l34,
        R.mipmap.f2l35,
        R.mipmap.f2l35_1,
        R.mipmap.f2l36,
        R.mipmap.f2l36_1,
        R.mipmap.f2l37,
        R.mipmap.f2l38,
        R.mipmap.f2l39,
        R.mipmap.f2l40,
        R.mipmap.f2l41
    )

    // F2L公式资源
    private val f2lFormulas = mapOf(
        R.mipmap.f2l1 to "(R U2' R' U)2 y'(R'U'R)\n" +
                "如果左前为空槽可做\n" +
                "D (R' F R F') (R U' R') D'\n" +
                "如果右后为空槽可做\n" +
                "D' (R' F R F') (R U' R') D",
        R.mipmap.f2l2 to "U (R U' R') U' (F' U F)",
        R.mipmap.f2l2_1 to "F r U r' F'\n" +
                "或 U' D F' U F D'",
        R.mipmap.f2l2_2 to "U' D' F' U F D",
        R.mipmap.f2l3 to "U' (F' U F) U (R U' R')",
        R.mipmap.f2l3_1 to "U D R U' R' D'",
        R.mipmap.f2l3_2 to "U D' R U' R' D",
        R.mipmap.f2l4 to "(R U' R') U' (R U R') U2 (R U' R')\n" +
                "如果左前为空槽可做\n" +
                "u' (R U' R' U) (R U' R') u\n" +
                "如果右后为空槽可做\n" +
                "u (R U' R' U) (R U' R') u'",
        R.mipmap.f2l5 to "(R U' R' U') (R U' R') U (F' U' F)",
        R.mipmap.f2l6 to "y L' U' L U L' U' L\n" +
                "或 y' (R' U' R U) (R' U' R)",
        R.mipmap.f2l7 to "(R U' R' U) (R U' R')",
        R.mipmap.f2l8 to "(R U' R' U) (R U2' R') U (R U' R')\n" +
                "如果左前为空槽可做\n" +
                "u' (R U R' U') (R U R') u\n" +
                "如果右后为空槽可做\n" +
                "u (R U R' U') (R U R') u'",
        R.mipmap.f2l9 to "(R U' R' U) d (R' U' R U') (R' U R)",
        R.mipmap.f2l10 to "y' (R' U R) U' (R' U R)\n" +
                "或 (R U R' U') (F R' F' R)",
        R.mipmap.f2l11 to "(R U R' U') (R U R')",
        R.mipmap.f2l12 to "(R U R' U') (R U R' U') (R U R')\n" +
                "或 (U R U' R') (U R U' R') (U R U' R')",
        R.mipmap.f2l13 to "(R U' R') d (R' U R)",
        R.mipmap.f2l14 to "y' (R' U2 R) U (R' U' R)",
        R.mipmap.f2l15 to "y' U' (R' U2 R) U' (R' U R)",
        R.mipmap.f2l16 to "y' U2 (R' U' R U') (R' U R)\n" +
                "或 y' (R' U R) U2 (R' U' R)",
        R.mipmap.f2l17 to "(R U R') d (R' U R U') (R' U R)",
        R.mipmap.f2l18 to "U2 R2 U2 (R' U' R U') R2\n" +
                "或 (R U R' U') U' (R U R' U') (R U R')",
        R.mipmap.f2l19 to "U2 (R U R' U) (R U' R')\n" +
                "或 (R U' R') U2 (R U R')\n",
        R.mipmap.f2l20 to "U R U2 R2' (F R F')\n" +
                "或 U (R U2 R') U (R U' R')",
        R.mipmap.f2l21 to "(R U2' R') U' (R U R')",
        R.mipmap.f2l22 to "(U' R U' R') U2 (R U' R')",
        R.mipmap.f2l23 to "(U' R U R') d (R' U' R)",
        R.mipmap.f2l24 to "d (R' U R U') (R' U' R)\n" +
                "如果右后槽为空槽可做\n" +
                "(R' U R) (F' U' F)",
        R.mipmap.f2l25 to "y' (R' U' R)\n" +
                "或 F' U' F",
        R.mipmap.f2l26 to "U y' (R' U' R U') (R' U' R)\n" +
                "如果右后槽为空槽可做\n" +
                "(R' U' R) (F' U' F)\n" +
                "如果左前为空槽可做\n" +
                "F U' F2' U' F",
        R.mipmap.f2l27 to "U' (R U2' R') d (R' U' R)\n" +
                "如果左前为空槽可做\n" +
                "F U2 F2' U' F",
        R.mipmap.f2l28 to "y' (R' U R U') d' (R U R')\n" +
                "或 M U L F' L' U' M'",
        R.mipmap.f2l29 to "U' (R U2' R') U2 (R U' R')\n" +
                "如果左前为空槽可做\n" +
                "F U2 F' (U R U' R')",
        R.mipmap.f2l30 to "(U' R U R') U2 (R U' R')\n" +
                "如果左前为空槽可做\n" +
                "F U F' U R U' R'",
        R.mipmap.f2l31 to "U R U' R'\n" +
                "或 R' F R F'",
        R.mipmap.f2l32 to "U' (R U2' R') U (R U R')\n" +
                "或 d (R' U R) U2 (R' U R)",
        R.mipmap.f2l33 to "d (R' U' R) d' (R U R')",
        R.mipmap.f2l34 to "y' U' (R' U R)\n" +
                "或 F R' F' R",
        R.mipmap.f2l35 to "d (R' U' R) U2' (R' U R)\n" +
                "如果右后槽为空槽可做\n" +
                "(R' U' R) y' U' (R' U R)",
        R.mipmap.f2l35_1 to "y R' F R F' L' U' L",
        R.mipmap.f2l36 to "d (R' U2 R) U2' (R' U R)\n" +
                "如果右后槽为空槽可做\n" +
                "(R' U2 R) y' U' (R' U R)",
        R.mipmap.f2l36_1 to "(r U' r' F) (R U R')",
        R.mipmap.f2l37 to "(R U' R' U) d (R' U' R)",
        R.mipmap.f2l38 to "d (R' U2 R) d' (R U R')\n" +
                "如果右后槽为空槽可做\n" +
                "R' U2 R2 U R'",
        R.mipmap.f2l39 to "U' (R U R' U) (R U R')\n" +
                "如果右后槽为空槽可做\n" +
                "R' U R2 U R'\n" +
                "如果左前为空槽可做\n" +
                "(F U F') (R U R')",
        R.mipmap.f2l40 to "(R U R')",
        R.mipmap.f2l41 to "U' (R U' R' U) (R U R')\n" +
                "如果左前为空槽可做\n" +
                "(F U' F') (R U R')"
    )

    // F2L临时List
    private var f2lTemps = f2lImages.toMutableList()

    // F2L图片点击事件
    fun f2lImageRandom(view: View) {
        // 随机图片资源
        val temp = f2lTemps.random()

        // 获取对应的ImageView
        val imageView = findViewById<ImageView>(R.id.f2lImageView)

        // 设置图片资源
        imageView.setImageResource(temp)

        // 设置图片tag
        imageView.tag = temp

        // 检查Switch开关并进行相应设置
        if (findViewById<Switch>(R.id.formulaSwitch).isChecked) {
            findViewById<TextView>(R.id.f2lFormulasTextView).text = f2lFormulas[temp]
        } else {
            findViewById<TextView>(R.id.f2lFormulasTextView).text = null
        }

        // 移除图片信息
        f2lTemps.remove(temp)

        // 列表使用完毕通知用户
        if (f2lTemps.size == 0) {
            f2lTemps = f2lImages.toMutableList()
            findViewById<TextView>(R.id.noticeTextView).text = getText(R.string.f2lNotice)
        } else {
            findViewById<TextView>(R.id.noticeTextView).text = null
        }
    }

    // OLL图片资源
    private val ollImages = listOf(
        R.mipmap.o1,
        R.mipmap.o2,
        R.mipmap.o3,
        R.mipmap.o4,
        R.mipmap.o5,
        R.mipmap.o6,
        R.mipmap.o7,
        R.mipmap.o8,
        R.mipmap.o9,
        R.mipmap.o10,
        R.mipmap.o11,
        R.mipmap.o12,
        R.mipmap.o13,
        R.mipmap.o14,
        R.mipmap.o15,
        R.mipmap.o16,
        R.mipmap.o17,
        R.mipmap.o18,
        R.mipmap.o19,
        R.mipmap.o20,
        R.mipmap.o21,
        R.mipmap.o22,
        R.mipmap.o23,
        R.mipmap.o24,
        R.mipmap.o25,
        R.mipmap.o26,
        R.mipmap.o27,
        R.mipmap.o28,
        R.mipmap.o29,
        R.mipmap.o30,
        R.mipmap.o31,
        R.mipmap.o32,
        R.mipmap.o33,
        R.mipmap.o34,
        R.mipmap.o35,
        R.mipmap.o36,
        R.mipmap.o37,
        R.mipmap.o38,
        R.mipmap.o39,
        R.mipmap.o40,
        R.mipmap.o41,
        R.mipmap.o42,
        R.mipmap.o43,
        R.mipmap.o44,
        R.mipmap.o45,
        R.mipmap.o46,
        R.mipmap.o47,
        R.mipmap.o48,
        R.mipmap.o49,
        R.mipmap.o50,
        R.mipmap.o51,
        R.mipmap.o52,
        R.mipmap.o53,
        R.mipmap.o54,
        R.mipmap.o55,
        R.mipmap.o56,
        R.mipmap.o57
    )

    // OLL公式资源
    private val ollFormulas = mapOf(
        R.mipmap.o1 to "(R U2') (R2' F R F') U2 (R' F R F')",
        R.mipmap.o2 to "F (R U R' U') F' f (R U R' U') f'",
        R.mipmap.o3 to "f (R U R' U') f' U' F (R U R' U') F'",
        R.mipmap.o4 to "f (R U R' U') f' U F (R U R' U') F'",
        R.mipmap.o5 to "(r' U2) (R U R'U) r",
        R.mipmap.o6 to "(r U2') (R' U' R U') r'",
        R.mipmap.o7 to "r U R' U R U2 r'",
        R.mipmap.o8 to "r' U' R U' R' U2' r",
        R.mipmap.o9 to "(R U R' U') (R' F) (R2 U R' U') F'",
        R.mipmap.o10 to "(L' U' L U) (L F') (L2' U' L U) F",
        R.mipmap.o11 to "F' (L' U' L U) F U' F' (L' U' L U) F",
        R.mipmap.o12 to "F (R U R' U') F' U F (R U R' U') F'",
        R.mipmap.o13 to "L F' (L' U' L F L') y (L' U L)",
        R.mipmap.o14 to "R' F (R U R' F' R) y' (R U' R')",
        R.mipmap.o15 to "(l' U' l) (L' U' L U) (l' U l)",
        R.mipmap.o16 to "(r U r') (R U R' U') (r U' r')",
        R.mipmap.o17 to "(R U R' U) (R' F R F') U2 (R' F R F')",
        R.mipmap.o18 to "F (R U R' U) y' (R' U2) (R' F R F')",
        R.mipmap.o19 to "(M U) (R U R' U') M' (R' F R F')",
        R.mipmap.o20 to "(M U) (R U R' U') M2 (U R U' r')",
        R.mipmap.o21 to "(R U2' R' U') (R U R' U') (R U' R')",
        R.mipmap.o22 to "R U2' (R2' U') (R2 U') R2' U2 R",
        R.mipmap.o23 to "(R2 D') (R U2') (R' D) (R U2' R)",
        R.mipmap.o24 to "(r U R' U') (r' F R F')",
        R.mipmap.o25 to "F' (r U R' U') (r' F R)",
        R.mipmap.o26 to "R U2' R' U' R U' R'",
        R.mipmap.o27 to "R' U2 R U R' U R",
        R.mipmap.o28 to "(r U R' U') (r' R) (U R U' R')",
        R.mipmap.o29 to "(r U2' R' U' R U' r') (R' U2 R U R' U R)",
        R.mipmap.o30 to "(r' U2 R U R' U r) (R U2' R' U' R U' R')",
        R.mipmap.o31 to "(R' U' F) (U R U') (R' F' R)",
        R.mipmap.o32 to "(R U) (B' U') (R' U R B R')",
        R.mipmap.o33 to "(R U R' U') (R' F R F')",
        R.mipmap.o34 to "(R U R' U') x D' (R' U R) E'",
        R.mipmap.o35 to "R U2' (R2' F R F') (R U2' R')",
        R.mipmap.o36 to "(R' U' R U') (R' U R U) (l U' R' U)",
        R.mipmap.o37 to "F (R U' R' U') (R U R' F')",
        R.mipmap.o38 to "(R U R' U) (R U' R' U') (R' F R F')",
        R.mipmap.o39 to "L F' (L' U' L U) F (U' L')",
        R.mipmap.o40 to "R' F (R U R'U') F' (U R)",
        R.mipmap.o41 to "(R U R' U R U2 R') F (R U R' U') F'",
        R.mipmap.o42 to "(R' U' R U' R' U2' R) F (R U R' U') F'",
        R.mipmap.o43 to "f' (L' U' L U) f",
        R.mipmap.o44 to "f (R U R' U') f'",
        R.mipmap.o45 to "F (R U R' U') F'",
        R.mipmap.o46 to "(R' U') (R' F R F') (U R)",
        R.mipmap.o47 to "F' (L' U' L U)2 F",
        R.mipmap.o48 to "F (R U R' U')2 F'",
        R.mipmap.o49 to "(R B') (R2 F) (R2 B) (R2 F') R",
        R.mipmap.o50 to "(R' F) (R2 B') (R2 F') (R2 B) R'",
        R.mipmap.o51 to "f (R U R' U')2 f'",
        R.mipmap.o52 to "(R' U' R U') (R' U) y' (R' U R B)",
        R.mipmap.o53 to "r' U2 (R U R' U') (R U R' U) r",
        R.mipmap.o54 to "r U (R' U R U')2 U' r'",
        R.mipmap.o55 to "R' F (U R U') (R2' F') (R2 U R' U' R)",
        R.mipmap.o56 to "(r U r') (U R U' R')2 (r U' r')",
        R.mipmap.o57 to "(R U R' U') r R' (U R U' r')"
    )

    // OLL临时List
    private var ollTemps = ollImages.toMutableList()

    // OLL图片点击事件
    fun ollImageRandom(view: View) {
        // 随机OLL图片资源
        val temp = ollTemps.random()

        // 获取对应的ImageView
        val imageView = findViewById<ImageView>(R.id.ollImageView)

        // 设置图片资源
        imageView.setImageResource(temp)

        // 设置图片tag
        imageView.tag = temp

        // 检查Switch开关并进行相应设置
        if (findViewById<Switch>(R.id.formulaSwitch).isChecked) {
            findViewById<TextView>(R.id.ollFormulasTextView).text = ollFormulas[temp]
        } else {
            findViewById<TextView>(R.id.ollFormulasTextView).text = null
        }

        // 移除图片信息
        ollTemps.remove(temp)

        // 列表使用完毕通知用户
        if (ollTemps.size == 0) {
            ollTemps = ollImages.toMutableList()
            findViewById<TextView>(R.id.noticeTextView).text = getText(R.string.ollNotice)
        } else {
            findViewById<TextView>(R.id.noticeTextView).text = null
        }
    }

    // PLL图片资源
    private val pllImages = listOf(
        R.mipmap.a,
        R.mipmap.a1,
        R.mipmap.e,
        R.mipmap.f,
        R.mipmap.g,
        R.mipmap.g1,
        R.mipmap.g2,
        R.mipmap.g3,
        R.mipmap.h,
        R.mipmap.j,
        R.mipmap.j1,
        R.mipmap.n,
        R.mipmap.n1,
        R.mipmap.r,
        R.mipmap.r1,
        R.mipmap.t,
        R.mipmap.u,
        R.mipmap.u1,
        R.mipmap.v,
        R.mipmap.y,
        R.mipmap.z
    )

    // PLL公式资源
    private val pllFormulas = mapOf(
        R.mipmap.a to "x' (R U' R) D2 (R' U R) D2 R2' x",
        R.mipmap.a1 to "x' R2 D2 (R' U' R) D2 (R' U R') x",
        R.mipmap.e to "(R2 U R' U') y (R U R' U')2 (R U R')\n" +
                "y' (R U' R2)",
        R.mipmap.f to "U' (R' U R U') R2 b' x (R' U R)\n" +
                "y' (R U R' U' R2)",
        R.mipmap.g to "(R U R') y' (R2 u') (R U' R' U) (R' u R2)",
        R.mipmap.g1 to "(R2 u') (R U' R U) (R' u R2) y (R U' R')",
        R.mipmap.g2 to "(R' U' R) y (R2 u) (R' U R U') (R u' R2)",
        R.mipmap.g3 to "(R2 u) (R' U R' U') (R u' R2) y' (R' U R)",
        R.mipmap.h to "M2 U M2 U2 M2 U M2",
        R.mipmap.j to "(R U R' F') (R U R' U') (R' F R2 U' R' U')",
        R.mipmap.j1 to "(L' U' L F) (L' U' L U) (L F' L2' U L U)",
        R.mipmap.n to "z (U' R D') (R2 U R' U')\n" +
                "z' (R U R') z (R2 U R') D R'",
        R.mipmap.n1 to "z (R' U R') z' (R U2' L' U R')\n" +
                "z (U R') z' (R U2' L' U R')",
        R.mipmap.r to "(R' U2) (R U2') (R' F R U R' U') (R' F' R2 U')",
        R.mipmap.r1 to "(R U2') (R' U2) (R B' R' U') (R U R B) R2' U",
        R.mipmap.t to "(R U R' U') (R' F R2 U' R' U') (R U R' F')",
        R.mipmap.u to "(R2 U R U) (R' U' R' U') (R' U R')",
        R.mipmap.u1 to "(R U' R) (U R U R) (U' R' U' R2')",
        R.mipmap.v to "(R' U R' d') (R' F') (R2 U' R' U) (R' F R F)",
        R.mipmap.y to "F (R U' R' U') (R U R' F')\n" +
                "(R U R' U') (R' F R F')",
        R.mipmap.z to "(M2 U M2 U) (M U2) (M2 U2) (M U2)"
    )

    // PLL临时列表
    private var pllTemps = pllImages.toMutableList()

    // PLL图片点击事件
    fun pllImageRandom(view: View) {
        // 随机PLL图片资源
        val temp = pllTemps.random()

        // 获取对应的ImageView
        val imageView = findViewById<ImageView>(R.id.pllImageView)

        // 设置图片资源
        imageView.setImageResource(temp)

        // 设置图片tag
        imageView.tag = temp

        // 检查Switch开关并进行相应设置
        if (findViewById<Switch>(R.id.formulaSwitch).isChecked) {
            findViewById<TextView>(R.id.pllFormulasTextView).text = pllFormulas[temp]
        } else {
            findViewById<TextView>(R.id.pllFormulasTextView).text = null
        }

        // 移除图片信息
        pllTemps.remove(temp)

        // 列表使用完毕通知用户
        if (pllTemps.size == 0) {
            pllTemps = pllImages.toMutableList()
            findViewById<TextView>(R.id.noticeTextView).text = getText(R.string.pllNotice)
        } else {
            findViewById<TextView>(R.id.noticeTextView).text = null
        }
    }

    // 书写公式开关
    fun switchMoveNotation(view: View) {
        // 检查Switch开关并进行相应设置
        if (findViewById<Switch>(R.id.notationSwitch).isChecked) {
            findViewById<TextView>(R.id.notationTextView).text = getText(R.string.notationText)
        } else {
            findViewById<TextView>(R.id.notationTextView).text = null
        }
    }
}
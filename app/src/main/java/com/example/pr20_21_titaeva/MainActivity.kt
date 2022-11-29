package com.example.pr20_21_titaeva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.ViewUtils
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), GameTask {
    lateinit var rootLayout: LinearLayout
    lateinit var startBtn: Button
    lateinit var mGameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this,this)

        startBtn.setOnClickListener{
            mGameView.setBackgroundResource(R.drawable.road)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE
        }
    }
    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)
        mGameView = GameView(this,this)// пификсил)
        startBtn.visibility = View.VISIBLE
        startBtn.text = "начать заново"
        score.visibility = View.VISIBLE


    }
}
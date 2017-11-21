package com.azharudhen.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.azharudhen.swoosh.Model.Player
import com.azharudhen.swoosh.R
import com.azharudhen.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player =  intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false
        player.skill = "Beginner"
    }

    fun onBallerClicked(view: View){
        beginnerSkillBtn.isChecked = false
        player.skill = "Baller"
    }

    fun onFinishClicked(view: View){
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please Select a make a skill level.", Toast.LENGTH_SHORT).show()
        }

    }
}

package com.azharudhen.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.azharudhen.swoosh.Utilities.EXTRA_LEAGUE
import com.azharudhen.swoosh.R
import com.azharudhen.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league =  intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false
        skill = "Beginner"
    }

    fun onBallerClicked(view: View){
        beginnerSkillBtn.isChecked = false
        skill = "Baller"
    }

    fun onFinishClicked(view: View){
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please Select a make a skill level.", Toast.LENGTH_SHORT).show()
        }

    }
}

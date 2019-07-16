package com.andela.testPhase1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        about_alc_btn.setOnClickListener(this)

        my_profile_btn.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.about_alc_btn -> {
                startActivity(Intent(this,AndelaWebPageActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }

            R.id.my_profile_btn -> {
                startActivity(Intent(this,ProfileActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }


}

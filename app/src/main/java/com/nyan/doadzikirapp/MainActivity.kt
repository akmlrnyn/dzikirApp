package com.nyan.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.card.MaterialCardView
import com.nyan.doadzikirapp.presentation.DzikirHarianActivity
import com.nyan.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.nyan.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.nyan.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //declare variable to get in touch with view in layout activity_main
    //use findViewById to communicate with the view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This method is from dependencies Splash Screen API 12
        installSplashScreen()
        //set content view is used to displaying layout in activity
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        val cardQauliyahShalat = findViewById<MaterialCardView>(R.id.card_qauliyah_shalat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_dzikir_pagi_petang)

        //when cardView is clicked, it will navigate to the other page
        //intent is used to navigate to other activity by clicking card
        cardQauliyahShalat.setOnClickListener{
            //Intent(argument context, which activity you want to go to)
            val intent = Intent(this, QauliyahShalatActivity::class.java)
            //start to go to the destination activity
            startActivity(intent)
        }
        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
       when (view?.id) {
           R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
           R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
           R.id.card_dzikir_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))

       }
    }
}
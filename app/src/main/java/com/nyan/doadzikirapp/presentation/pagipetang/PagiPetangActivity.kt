package com.nyan.doadzikirapp.presentation.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.nyan.doadzikirapp.R
import com.nyan.doadzikirapp.databinding.ActivityPagiPetangBinding

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityPagiPetangBinding? = null
    private val binding get() = _binding as ActivityPagiPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityPagiPetangBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
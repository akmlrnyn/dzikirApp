package com.nyan.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyan.doadzikirapp.adapter.DoaDzikirAdapter
import com.nyan.doadzikirapp.databinding.ActivityPetangBinding
import com.nyan.doadzikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = DoaDzikirAdapter()
        myAdapter.setData(DataDoaDzikir.listDzikirPetang())
        binding.rvDzikirPetang.adapter = myAdapter
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
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
package com.nyan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyan.doadzikirapp.DoaDzikirAdapter
import com.nyan.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.nyan.doadzikirapp.model.DataDoaDzikir

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = DoaDzikirAdapter()
        myAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikirSetiapSaat.adapter = myAdapter
        //layoutManager is a class to set our structure of recyclerView to display dataset
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
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
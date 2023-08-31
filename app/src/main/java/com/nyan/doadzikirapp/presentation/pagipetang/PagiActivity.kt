package com.nyan.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyan.doadzikirapp.adapter.DoaDzikirAdapter
import com.nyan.doadzikirapp.R
import com.nyan.doadzikirapp.databinding.ActivityPagiBinding
import com.nyan.doadzikirapp.model.DataDoaDzikir

class PagiActivity : AppCompatActivity() {
    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //change title text in action bar
        title = resources.getString(R.string.txt_dzikir_pagi)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = DoaDzikirAdapter()
        myAdapter.setData(DataDoaDzikir.listDzikirPagi())
        binding.rvDzikirPagi.adapter = myAdapter
        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
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
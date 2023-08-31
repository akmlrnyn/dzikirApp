package com.nyan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyan.doadzikirapp.adapter.DoaDzikirAdapter
import com.nyan.doadzikirapp.model.DataDoaDzikir.listQauliyah
import com.nyan.doadzikirapp.databinding.ActivityQauliyahShalatBinding

class QauliyahShalatActivity : AppCompatActivity() {
    //implement viewBinding feature
    //viewBinding is a feature that makes you easier to write code and interact with views
    //viewBinding is to replace findViewById to optimize it
    private var _binding: ActivityQauliyahShalatBinding? = null
    private val binding get() = _binding as ActivityQauliyahShalatBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityQauliyahShalatBinding.inflate(layoutInflater)
        //replace argument of setContentView using viewBinding
        //this is for connect the view using binding
        setContentView(binding.root)

        //set recyclerView
        val myAdapter = DoaDzikirAdapter()
        myAdapter.setData(listQauliyah)
        binding.rvQauliyahShalat.adapter = myAdapter
        //layoutManager is a class to set our structure of recyclerView to display dataset
        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
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
package com.nyan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyan.doadzikirapp.DoaDzikirAdapter
import com.nyan.doadzikirapp.R
import com.nyan.doadzikirapp.databinding.ActivityDzikirHarianBinding
import com.nyan.doadzikirapp.model.DataDoaDzikir
import com.nyan.doadzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //show page navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()

    }

    private fun initView() {
        //apply is a scope function
        //in this case, the object is rvDzikirHarian
        //if you use this, it will make rvDzikirHarian as a context
        binding.rvDzikirHarian.apply {
            val myAdapter = DoaDzikirAdapter()
            myAdapter.setData(providingDzikirDatas())
            adapter = myAdapter
            //this is a return context, use @dzikirHarianActivity to make siure that we gonna use activity to apply instead of rv
            layoutManager = LinearLayoutManager(this@DzikirHarianActivity)
        }
    }

    private fun providingDzikirDatas() : List<DoaDzikirItem> {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)


        val listData = arrayListOf<DoaDzikirItem>()
        for (i in titleDzikir.indices) {
            val data = DoaDzikirItem(
                titleDzikir[i],
                arabicDzikir[i],
                translateDzikir[i]
            )
            listData.add(data)
        }
        return listData
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
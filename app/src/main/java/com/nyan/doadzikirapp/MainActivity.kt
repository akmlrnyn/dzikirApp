package com.nyan.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.nyan.doadzikirapp.adapter.ArticleAdapter
import com.nyan.doadzikirapp.databinding.ActivityMainBinding
import com.nyan.doadzikirapp.model.ArticleItem
import com.nyan.doadzikirapp.presentation.DetailActivity
import com.nyan.doadzikirapp.presentation.DzikirHarianActivity
import com.nyan.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.nyan.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.nyan.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array<ImageView?>

    private val listArtikel: ArrayList<ArticleItem> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    //declare variable to get in touch with view in layout activity_main
    //use findViewById to communicate with the view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This method is from dependencies Splash Screen API 12
        installSplashScreen()

        _binding = ActivityMainBinding.inflate(layoutInflater)

        //set content view is used to displaying layout in activity
        setContentView(binding.root)

        initData()
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            binding.dots.addView(sliderIndicator[i], params)
        }
    }

    private fun initData() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (data in titleArtikel.indices) {
            val artikel = ArticleItem(
                titleArtikel[data],
                imgArtikel.getResourceId(data, 0),
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
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

        binding.vpArticle.apply {
            val mAdapter = ArticleAdapter()
            mAdapter.setData(listArtikel)
            mAdapter.setOnItemClickCallback(object : ArticleAdapter.OnItemCallback {
                override fun onItemClicked(item: ArticleItem) {
                    val intent = Intent(applicationContext, DetailActivity::class.java)

                    intent.putExtra("title", item.titleArticle)
                    intent.putExtra("desc", item.contentArticle)
                    intent.putExtra("image", item.imageArticle)

//                intent.putExtra("data", data)
                    startActivity(intent)
                }
            })
            adapter = mAdapter
            registerOnPageChangeCallback(slidingCallback)
        }
    }

    override fun onClick(view: View?) {
       when (view?.id) {
           R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
           R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
           R.id.card_dzikir_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))

       }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
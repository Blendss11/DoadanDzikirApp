package com.idn.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadandzikirapp.R.drawable
import com.idn.doadandzikirapp.Utills.OnitemCallBack
import com.idn.doadandzikirapp.adapter.ArtikelAdapter
import com.idn.doadandzikirapp.model.Artikel
import com.idn.doadandzikirapp.ui.HarianDzikirDoaActivity
import com.idn.doadandzikirapp.ui.PagiPetangDzikirActivity
import com.idn.doadandzikirapp.ui.Qauliyah_Sholat
import com.idn.doadandzikirapp.ui.SetiapSaatDzikirActivity
import com.idn.doadandzikirapp.ui.detail.DetailArtikelActivity

class MainActivity : AppCompatActivity() {

    private var keep = true
    private val runner = Runnable { keep = false }
    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array<ImageView?>

    private val listArtikel: ArrayList<Artikel> = arrayListOf()



    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, drawable.dot_inactive)
                )
            }

            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
            .setKeepOnScreenCondition { keep }
        val handler = Handler()
        handler.postDelayed(runner, 1800)
        setContentView(R.layout.activity_main)

        initData()
        initView()
       setupViewPager()
    }

    private fun setupViewPager() {
       val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size){
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext,
                drawable.dot_inactive)
            )

            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            param.setMargins(9,0,8,0)
            param.gravity = Gravity.CENTER_VERTICAL

            llSliderDots.addView(sliderIndicator[i],param)
        }

        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,drawable.dot_active
            )
        )
    }

    private fun initData(): List<Artikel> {
        // bagian artikel
        val judulArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

    val listData = arrayListOf<Artikel>()
        for (i in judulArtikel.indices) {
            val data = Artikel(
                imgArtikel.getResourceId(i, 0),
                judulArtikel[i],
                descArtikel[i]
            )
            listData.add(data)
            listArtikel.add(data)
        }
        imgArtikel.recycle()
         return listData
    }



        private fun initView() {
            val llDzikirDoaShalat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
            llDzikirDoaShalat.setOnClickListener {
                startActivity(Intent(this, Qauliyah_Sholat::class.java))
            }

            val llDzikirSetiapSaat = findViewById<LinearLayout>(R.id.ll_dzikir_setiap_saat)
            llDzikirSetiapSaat.setOnClickListener {
                startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
            }

            val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
            llDzikirDoaHarian.setOnClickListener {
                startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
            }

            val llDzikirPagiPetang: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
            llDzikirPagiPetang.setOnClickListener {
                startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
            }

            vpArtikel = findViewById(R.id.vp_article)
             val mAdapter = ArtikelAdapter(listArtikel)
            mAdapter.setData(listArtikel)
            vpArtikel.adapter = mAdapter


            vpArtikel.registerOnPageChangeCallback(slidingCallback)

            mAdapter.setOnItemClickCallback(object : OnitemCallBack{
                override fun onItemClicked(item: Artikel) {
                    val intent = Intent(this@MainActivity,DetailArtikelActivity::class.java)
                    intent.putExtra("data",item)
                    startActivity(intent)
                }
            })
        }

//        override fun onDestroy() {
//            super.onDestroy()
//            vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
//        }


    }







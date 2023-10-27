package com.idn.doadandzikirapp.ui.detail

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.databinding.ActivityDetailArtikelBinding
import com.idn.doadandzikirapp.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {
private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding
    companion object {
        const val DATA_TITLE = "title"
        const val DATA_DESC = "data"
        const val DATA_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        setContentView(R.layout.activity_detail_artikel)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)

            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as? Artikel
        }



        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it)}
        }

//        val dataTitle = intent.getStringExtra(DATA_TITLE)
//        val dataDesc = intent.getStringExtra(DATA_DESC)
//        val dataImage = intent.getIntExtra(DATA_IMAGE, 0)
//
//        val tvTitle: TextView = findViewById(R.id.tv_detail_title)
//        tvTitle.text = dataTitle
//        val tvDesc: TextView = findViewById(R.id.tv_detail_desc)
//        tvDesc.text = dataDesc
//        val imgArtikel: ImageView = findViewById(R.id.img_detail)
//        imgArtikel.setImageResource(dataImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
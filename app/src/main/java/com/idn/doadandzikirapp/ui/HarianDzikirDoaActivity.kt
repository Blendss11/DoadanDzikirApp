package com.idn.doadandzikirapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.adapter.DzikirDoaAdapter
import com.idn.doadandzikirapp.databinding.ActivityHarianDzikirDoaBinding
import com.idn.doadandzikirapp.model.DzikirDoa


class HarianDzikirDoaActivity : AppCompatActivity() {

    private var _binding: ActivityHarianDzikirDoaBinding? = null

    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa)

        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)

        setContentView(binding.root)


        providingDzikirData()
        initView()

    }

    private fun initView() {
        val mAdapter = DzikirDoaAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }


    private fun providingDzikirData(): List<DzikirDoa> {

        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val ArabText = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val TerjemahText = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DzikirDoa>()
        for (i in titleDzikir.indices) {
            val data = DzikirDoa(
                titleDzikir[i],
                ArabText[i],
                TerjemahText[i]
            )

            listData.add(data)
        }

        return listData
    }

        override fun onSupportNavigateUp(): Boolean {
            onBackPressedDispatcher.onBackPressed()
            return super.onSupportNavigateUp()
        }

}


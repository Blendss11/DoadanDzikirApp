package com.idn.doadandzikirapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.adapter.DzikirDoaAdapter
import com.idn.doadandzikirapp.databinding.ActivitySetiapSaatDzikirBinding
import com.idn.doadandzikirapp.model.DataDzikirDoa

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private var _binding : ActivitySetiapSaatDzikirBinding? = null

    private val binding get() = _binding as ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_setiap_saat_dzikir)
        _binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val mAdapter = DzikirDoaAdapter()
        mAdapter.setData(DataDzikirDoa.listDzikir)
        binding.rvDzikirSetiapSaat.adapter = mAdapter
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
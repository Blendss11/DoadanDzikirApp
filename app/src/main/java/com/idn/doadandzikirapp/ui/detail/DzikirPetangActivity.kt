package com.idn.doadandzikirapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.adapter.DzikirDoaAdapter
import com.idn.doadandzikirapp.databinding.ActivityDzikirPetangBinding
import com.idn.doadandzikirapp.model.DataDzikirDoa

class DzikirPetangActivity : AppCompatActivity() {
    private var _binding : ActivityDzikirPetangBinding? = null

    private val binding get() = _binding as ActivityDzikirPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_petang)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val rvDzikirPetang = findViewById<RecyclerView>(R.id.rv_dzikir_petang)
        rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        val adapter = DzikirDoaAdapter()
        adapter.setData(DataDzikirDoa.listDataQauliyah)

        rvDzikirPetang.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
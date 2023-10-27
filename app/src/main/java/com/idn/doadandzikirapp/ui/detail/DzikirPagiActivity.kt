package com.idn.doadandzikirapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.adapter.DzikirDoaAdapter
import com.idn.doadandzikirapp.databinding.ActivityDzikirPagiBinding
import com.idn.doadandzikirapp.model.DataDzikirDoa

class DzikirPagiActivity : AppCompatActivity() {

    private var _binding : ActivityDzikirPagiBinding? = null

    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_pagi)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)

        setContentView(binding.root)



        val rvDzikirPagi = findViewById<RecyclerView>(R.id.rv_dzikir_pagi)
        rvDzikirPagi.layoutManager = LinearLayoutManager(this)
        val adapter = DzikirDoaAdapter()
        adapter.setData(DataDzikirDoa.listDzikirPagi)

        rvDzikirPagi.adapter = adapter


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
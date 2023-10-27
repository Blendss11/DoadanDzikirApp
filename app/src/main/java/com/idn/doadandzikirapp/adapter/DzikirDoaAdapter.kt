package com.idn.doadandzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.model.DzikirDoa

class DzikirDoaAdapter : RecyclerView.Adapter<DzikirDoaAdapter.DzikirHolder>() {

    private val listData = arrayListOf<DzikirDoa>()

    fun setData(list: List<DzikirDoa>){
        listData.clear()
        listData.addAll(list)
    }

    inner class DzikirHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)
        val tvBacaan = view.findViewById<TextView>(R.id.tv_lafaz)
        val tvTerjemah = view.findViewById<TextView>(R.id.tv_terjemah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirHolder, position: Int) {

        holder.apply {
            tvDesc.text = listData[position].desc
            tvBacaan.text = listData[position].lafaz
            tvTerjemah.text = listData[position].terjemah
        }

    }

}
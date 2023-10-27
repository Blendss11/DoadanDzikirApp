package com.idn.doadandzikirapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.Utills.OnitemCallBack
import com.idn.doadandzikirapp.databinding.FragmenArticleBinding
import com.idn.doadandzikirapp.model.Artikel

class ArtikelAdapter(listArtikel: ArrayList<Artikel>) : RecyclerView.Adapter<ArtikelAdapter.ArticleMyViewHolder>(){

    private var listArtikel = ArrayList<Artikel>()
    private var onItemCallBack : OnitemCallBack? = null

    fun setData(list: List<Artikel>){
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnitemCallBack) {
        this.onItemCallBack = onItemCallback
    }

    inner class ArticleMyViewHolder (val view: FragmenArticleBinding) : RecyclerView.ViewHolder(view.root)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleMyViewHolder (
        FragmenArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun getItemCount()  = listArtikel.size

    override fun onBindViewHolder(holder: ArticleMyViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener{
            onItemCallBack?.onItemClicked(data)
        }
    }

}

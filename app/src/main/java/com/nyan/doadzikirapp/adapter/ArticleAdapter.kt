package com.nyan.doadzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nyan.doadzikirapp.R
import com.nyan.doadzikirapp.databinding.ItemArtikelBinding
import com.nyan.doadzikirapp.model.ArticleItem

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val listArticle = ArrayList<ArticleItem>()
    private var onItemCallback: OnItemCallback? = null
    fun setData(list: List<ArticleItem>){
        listArticle.clear()
        listArticle.addAll(list)
    }
    inner class ArticleViewHolder(val binding: ItemArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ArticleViewHolder (
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.binding.apply {
            listArticle[position].imageArticle?.let { itemArticle.setImageResource(it) }
        }
        holder.itemView.setOnClickListener {
            onItemCallback?.onItemClicked(listArticle[position])
        }
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    interface OnItemCallback {
        fun onItemClicked(item: ArticleItem)
    }
}
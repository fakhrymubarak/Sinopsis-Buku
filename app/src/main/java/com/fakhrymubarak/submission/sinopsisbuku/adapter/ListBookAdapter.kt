package com.fakhrymubarak.submission.sinopsisbuku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fakhrymubarak.submission.sinopsisbuku.R
import com.fakhrymubarak.submission.sinopsisbuku.model.Book

class ListBookAdapter(private val listBooks: ArrayList<Book>) :
    RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Book)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_book, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBooks[position]
        Glide.with(holder.itemView.context)
            .load(book.cover)
            .into(holder.ivCover)
        holder.tvTitle.text = book.title
        holder.tvWriter.text = book.writer
        holder.tvCategory.text = book.category
        holder.tvRating.text = book.rating

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBooks[position]) }
    }

    override fun getItemCount(): Int = listBooks.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvWriter: TextView = itemView.findViewById(R.id.tv_item_writer)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_item_category)
        var tvRating: TextView = itemView.findViewById(R.id.tv_item_rating)
    }
}
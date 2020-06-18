package com.fakhrymubarak.submission.sinopsisbuku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SynopsisActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_WRITER = "extra_writer"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_SYNOPSIS = "extra_synopsis"
        const val EXTRA_COVER = "extra_cover"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synopsis)
        supportActionBar?.title = intent.getStringExtra(EXTRA_TITLE)

        val tvTitle: TextView = findViewById(R.id.tv_item_title)
        val tvWriter: TextView = findViewById(R.id.tv_item_writer)
        val tvCategory: TextView = findViewById(R.id.tv_item_category)
        val tvRating: TextView = findViewById(R.id.tv_item_rating)
        val tvSynopsis: TextView = findViewById(R.id.tv_item_synopsis)
        val ivCover: ImageView = findViewById(R.id.iv_cover)

        tvTitle.text = intent.getStringExtra(EXTRA_TITLE)
        tvWriter.text = intent.getStringExtra(EXTRA_WRITER)
        tvCategory.text = intent.getStringExtra(EXTRA_CATEGORY)
        tvRating.text = intent.getStringExtra(EXTRA_RATING)
        tvSynopsis.text = intent.getStringExtra(EXTRA_SYNOPSIS)

        Glide.with(this)
            .load(intent.getIntExtra(EXTRA_COVER, 0))
            .into(ivCover)
    }
}

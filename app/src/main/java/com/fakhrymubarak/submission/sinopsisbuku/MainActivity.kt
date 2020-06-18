package com.fakhrymubarak.submission.sinopsisbuku

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhrymubarak.submission.sinopsisbuku.adapter.ListBookAdapter
import com.fakhrymubarak.submission.sinopsisbuku.model.Book
import com.fakhrymubarak.submission.sinopsisbuku.model.BooksData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Pilih Buku"

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(BooksData.listData)
        showRecyclerList()

        rv_books.setOnClickListener {
            Toast.makeText(
                this,
                "Recycler View berhasil dijalankan",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedBook(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedBook(book: Book) {
        Toast.makeText(this, "Kamu memilih buku " + book.title, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SynopsisActivity::class.java)
        intent.putExtra(SynopsisActivity.EXTRA_TITLE, book.title)
        intent.putExtra(SynopsisActivity.EXTRA_WRITER, book.writer)
        intent.putExtra(SynopsisActivity.EXTRA_CATEGORY, book.category)
        intent.putExtra(SynopsisActivity.EXTRA_RATING, book.rating)
        intent.putExtra(SynopsisActivity.EXTRA_SYNOPSIS, book.synopsis)
        intent.putExtra(SynopsisActivity.EXTRA_COVER, book.cover)
        startActivity(intent)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_home -> {
                Toast.makeText(this, "You are now in home section.", Toast.LENGTH_SHORT).show()
            }
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
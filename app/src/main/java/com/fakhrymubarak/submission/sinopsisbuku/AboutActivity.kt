package com.fakhrymubarak.submission.sinopsisbuku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About Developer"

        Glide.with(this)
            .load(R.drawable.developer_pictures)
            .into(findViewById(R.id.img_developer))

        tv_dev_mail.setOnClickListener {
            "Your Dicoding Submission Has Been Checked!".composeEmailTo(
                arrayOf("fakhrymubarak@gmail.com")
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun String.composeEmailTo(addresses: Array<String>) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, this@composeEmailTo)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

    }


    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_home -> {
                val intent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.action_about -> {
                Toast.makeText(this, "You are now in about section.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

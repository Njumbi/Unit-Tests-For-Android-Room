package com.example.words.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.words.R
import com.example.words.databinding.ActivityAddNameBinding
import com.example.words.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.show()

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddNameActivity::class.java)
            startActivity(intent)
        }

    }
}
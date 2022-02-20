package com.example.words.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words.databinding.ActivityAddNameBinding


class AddNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNameBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}
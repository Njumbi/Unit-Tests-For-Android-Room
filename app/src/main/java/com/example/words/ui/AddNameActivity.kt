package com.example.words.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.words.data.Word
import com.example.words.databinding.ActivityAddNameBinding
import com.example.words.viewModel.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNameBinding

    private val vm: WordsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertWord()
    }

    fun insertWord() {

        binding.button.setOnClickListener {
            val newWord = binding.etName.text
            if (newWord.isEmpty() || newWord.isBlank()) {
                Toast.makeText(this, "Please enter a name !", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }
            val insertNewWord = newWord.toString()

            val request = Word(
                name = insertNewWord
            )

            vm.insertWord(request)
            Toast.makeText(this,"Transaction Added Successfully",Toast.LENGTH_LONG).show()

            finish()

        }
    }


}
package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.utils.SharedPrefHelper
import java.util.UUID


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = SharedPrefHelper(this)
        checkToken()

        binding.cbPass.setOnClickListener {
            val cbPass = binding.cbPass
            if (cbPass.isChecked) {
                binding.etPass.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.etPass.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        binding.btnLogin.setOnClickListener {
            if (binding.etName.text.isEmpty().not() && binding.etPass.text.isEmpty().not()) {
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                handleRegister()
            } else {
                showToast("isi pass dan user first")
            }
        }
    }

    private fun checkToken() {
        val getToken = sharePref.getToken()
        if (getToken.isNotEmpty()) {
            handleRegister()
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


    }

    private fun handleRegister() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }


    private fun handleProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    interface PlayMusic {
        fun play()
        fun stop()

    }

}
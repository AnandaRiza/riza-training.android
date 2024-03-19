package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.presentation.RegisterActivity.Companion.KEY_NAME
import com.example.bcasyariah.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra(KEY_NAME)
        binding.tvName.text = getName

        binding.vComponentTopbar.tvTitle.text = "Profile Feature"
        binding.vComponentTopbar.ivBack.setOnClickListener{
            onBackPressed()
        }

//        setContentView(R.layout.activity_profile)

        val btnlogout = findViewById<TextView>(R.id.btnLogout)
        btnlogout.setOnClickListener {
            handleLogout()
        }






    }


    private fun handleLogout(){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }







}
package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private var defaultPasswordVisibility = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleRegister()

        binding.ivImage.setOnClickListener {
            defaultPasswordVisibility = !defaultPasswordVisibility

            if(defaultPasswordVisibility) {
                binding.ivImage.setImageResource(R.drawable.baseline_blur_on_24)
                binding.etPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }else{
                binding.ivImage.setImageResource(R.drawable.baseline_blur_off_24)
                binding.etPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
        }

    }


    private fun showToast(message:  String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


    }

    private fun handleRegister(){

        val etName = binding.etName.text
        val etAddress = binding.etAddress.text
        val etPass = binding.etPass.text



        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)

            intent.putExtra(KEY_NAME, etName.toString())

            startActivity(intent)

        }

//        btnRegister.setOnClickListener {
//
//            if (nameValue.isEmpty()
//                || PassValue.isEmpty()
//                || nameAddress.isEmpty())
//            {
//                showToast("Isi dulu yaa")
//            }else{
//             Toast.makeText(this, "你好吗 $nameValue, $PassValue, $nameAddress", Toast.LENGTH_SHORT).show()
//                showToast("Halo selamat datang")
//
//            }

        }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"
    }

    }




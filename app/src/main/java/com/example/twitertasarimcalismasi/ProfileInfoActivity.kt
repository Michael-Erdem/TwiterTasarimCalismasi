package com.example.twitertasarimcalismasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.twitertasarimcalismasi.databinding.ActivityProfileInfoBinding

class ProfileInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var followTF = true
        binding.button.setOnClickListener {
            if (followTF) {
                binding.button.text = "Following"
                Toast.makeText(this,"You Followed",Toast.LENGTH_SHORT).show()
                followTF = false
                binding.button.isEnabled = false
            }else{
                binding.button.text = "Follow"
                Toast.makeText(this,"You UnFollowed",Toast.LENGTH_SHORT).show()
                followTF = true
                binding.button.isEnabled = false
            }
            Handler(Looper.getMainLooper()).postDelayed({
                binding.button.isEnabled = true
            }, 2500)
        }
    }
}
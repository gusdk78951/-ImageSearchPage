package com.hyuna.imagesearchpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.hyuna.imagesearchpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            imageButtonHome.setOnClickListener {
                setFragment(SearchFragment())
            }
            imageButtonFolder.setOnClickListener {
                setFragment(SaveFragment())
            }
        }
        setFragment(SearchFragment())
    }

    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
        }
    }
}
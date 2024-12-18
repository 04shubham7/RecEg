package com.example.recyclerviewusingviewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewusingviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var RAdapter:RvAdapter
    var studentnames= arrayOf("aaaa","bbbb","cccc","dddd")
    var studentnumber= arrayOf(6545,5556,9988,3657)
    var studentimages= arrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher,R.mipmap.ic_launcher_round)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       val newsArray=ArrayList<data>()

        for(i in studentimages.indices) {
            val new = data(studentnames[i], studentnumber[i], studentimages[i])
            newsArray.add(new)
        }
            binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerView.adapter=RvAdapter(this,newsArray)


    }
}
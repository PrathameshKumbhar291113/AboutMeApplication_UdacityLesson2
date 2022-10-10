package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import coil.load
import coil.transform.CircleCropTransformation
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myName: MyName = MyName("Prathamesh Kumbhar")
//    private lateinit var binding : ActivityMainBinding
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        binding.starImg.load("https://i.imgur.com/fi4BK5A.jpg"){
            crossfade(true)
        }

        binding.doneBtn.setOnClickListener {
            addNickname(it)
        }

//        setContentView(binding.root)
    }

    private fun addNickname(view : View){
//        val editText = findViewById<EditText>(R.id.nickName_edit)
//        val showNickname = findViewById<TextView>(R.id.showNickName_text)
//        val imgView = findViewById<ImageView>(R.id.starImg)
        binding.apply {
            invalidateAll()
//            showNickNameText.text = nickNameEdit.text
            myName?.nickname = nickNameEdit.text.toString()
            nickNameEdit.visibility = View.GONE
            view.visibility = View.GONE
            showNickNameText.visibility = View.VISIBLE
        }

//        binding.starImg.load("https://i.imgur.com/gQa7JVP.png"){
//               crossfade(true)
//        }

        // Hide keyboard code
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
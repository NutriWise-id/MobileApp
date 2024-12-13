package com.nutriwise.universe.ui.learning.learningPage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.nutriwise.universe.databinding.ActivityDetailLearningPageBinding
import com.nutriwise.universe.ui.learning.DummyDataLearning

class DetailLearningPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailLearningPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailLearningPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDetailPage()
    }

    private fun setupDetailPage(){
        val id = intent.getStringExtra("PROJECT_ID")
        val data = DummyDataLearning.getLearningData()[id!!.toInt()-1]

        binding.ivDetailLearning.setImageResource(data.image)
        binding.tvDetailLearningTitle.text = data.judul
        binding.tvDetailLearningDescription.text = data.deskripsi
    }
    companion object {
        val PROJECT_ID ="PROJECT_ID"
    }
}
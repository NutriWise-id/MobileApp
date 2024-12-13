package com.nutriwise.universe.ui.learning

import android.content.Intent
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.nutriwise.universe.MainActivity
import com.nutriwise.universe.databinding.ActivitySignInBinding
import com.nutriwise.universe.databinding.ItemFragmentHomeLearningSectionBinding

class HomeSectionLearningAdapter(private val learningData: List<LearningData>): RecyclerView.Adapter<HomeSectionLearningAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemFragmentHomeLearningSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningData) {
            binding.apply {
                tvItemLearningFragmentHome.text = item.judul
                ivItemLearningFragmentHome.setImageResource(item.image)
                binding.layoutItemLearningHomeFragment.setOnClickListener {
                    val intent = Intent(itemView.context, MainActivity::class.java)
                    intent.putExtra(DetailHistoryActivity.JUDULARTIKEL, item.judul)
                    intent.putExtra(DetailHistoryActivity.THUMNAIL, item.img_sejarah)
                    intent.putExtra(DetailHistoryActivity.ARTIKEL, item.desc)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeSectionLearningAdapter.MyViewHolder {
        val nama =""
        return
    }

    override fun onBindViewHolder(holder: HomeSectionLearningAdapter.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
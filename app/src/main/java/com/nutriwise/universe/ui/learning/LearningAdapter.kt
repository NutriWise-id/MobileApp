package com.nutriwise.universe.ui.learning

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nutriwise.universe.databinding.ItemFragmentLearningBinding
import com.nutriwise.universe.ui.learning.learningPage.DetailLearningPageActivity

class LearningAdapter(val learningData: List<LearningData>):
    RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

        class LearningViewHolder(private val binding: ItemFragmentLearningBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item: LearningData){
                binding.apply {
                    ivImageItemLearning.setImageResource(item.image)
                    tvLearningTitle.text = item.judul
                    binding.frameLayoutLearningItem.setOnClickListener{
                        val intent = Intent(itemView.context, DetailLearningPageActivity::class.java)
                        intent.putExtra(DetailLearningPageActivity.PROJECT_ID, item.id.toString())
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): LearningAdapter.LearningViewHolder {
            val binding = ItemFragmentLearningBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LearningViewHolder(binding)
        }

        override fun onBindViewHolder(holder: LearningAdapter.LearningViewHolder, position: Int) {
            val item = learningData[position]
            holder.bind(item)
        }

        override fun getItemCount(): Int {
            return learningData.size
        }
}
package com.nutriwise.universe.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nutriwise.universe.databinding.ItemFragmentHomeLearningSectionBinding
import com.nutriwise.universe.ui.learning.LearningData
import com.nutriwise.universe.ui.learning.learningPage.DetailLearningPageActivity

class HomeSectionLearningAdapter(private val learningData: List<LearningData>): RecyclerView.Adapter<HomeSectionLearningAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemFragmentHomeLearningSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningData) {
            binding.apply {
                tvItemLearningFragmentHome.text = item.judul
                ivItemLearningFragmentHome.setImageResource(item.image)
                binding.layoutItemLearningHomeFragment.setOnClickListener {
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
    ): MyViewHolder {
        val binding = ItemFragmentHomeLearningSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item =learningData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
       return learningData.size
    }
}
package com.nutriwise.universe.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutriwise.universe.R
import com.nutriwise.universe.ui.learning.DummyDataLearning
import com.nutriwise.universe.ui.learning.LearningData


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLearningItemSection()
    }

    private fun setupLearningItemSection(){
        val learningData: List<LearningData> = DummyDataLearning.getLearningData()
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_item_learning_fragment_home)
        recyclerView?.layoutManager = layoutManager

        val adapter = HomeSectionLearningAdapter(learningData)
        recyclerView?.adapter = adapter
    }
}
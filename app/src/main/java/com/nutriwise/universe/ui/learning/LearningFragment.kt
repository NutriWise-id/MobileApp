package com.nutriwise.universe.ui.learning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.nutriwise.universe.R
import com.nutriwise.universe.ui.home.HomeSectionLearningAdapter

class LearningFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_learning, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpItemLearning()
    }

    private fun setUpItemLearning(){
        val learningData: List<LearningData> = DummyDataLearning.getLearningData()
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_item_learning_fragment)
        recyclerView?.layoutManager = layoutManager

        val adapter = LearningAdapter(learningData)
        recyclerView?.adapter = adapter
    }
}
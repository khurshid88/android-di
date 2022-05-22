package com.pdp.android_di.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pdp.android_di.R
import com.pdp.android_di.adapter.PostAdapter
import com.pdp.android_di.model.Post
import com.pdp.android_di.utils.SampleClass
import com.pdp.android_di.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private val viewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.apiPostList()
        viewModel.allPosts.observe(this, Observer {
            refreshAdapter(it)
        })
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }
}



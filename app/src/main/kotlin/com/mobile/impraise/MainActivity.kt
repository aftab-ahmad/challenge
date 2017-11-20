package com.mobile.impraise

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.mobile.impraise.models.BaseContentModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by aftab on 2017-11-16.
 */

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    private val tag = MainActivity::class.java.name

    @Inject
    lateinit var presenter: MainContract.Presenter

    @BindView(R.id.recycler_view)
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun displayData(itemList: List<BaseContentModel>) {
        recyclerView.adapter = ContentAdapter(itemList)
    }

    override fun displayError() {
        Log.e(tag, "Error. No data available")
    }
}
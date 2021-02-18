package com.example.flowersmvvm.view

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flowersmvvm.R
import com.example.flowersmvvm.adapter.FlowersAdapter
import com.example.flowersmvvm.databinding.ActivityMainBinding
import com.example.flowersmvvm.viewmodel.FlowersViewModel
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private var flowerAdapter: FlowersAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(FlowersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel

        flowerAdapter = FlowersAdapter()

        binding.root.flowersRecycler.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = flowerAdapter
        }

        viewModel.flowersList.observe(this,
            {
                flowersList ->
                flowersList?.apply {
                    flowerAdapter?.flowersList = this
                }
            })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
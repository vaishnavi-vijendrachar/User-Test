package com.vaishnavi.optustest.album

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishnavi.optustest.MainViewModel
import com.vaishnavi.optustest.R
import com.vaishnavi.optustest.UserAdapter
import com.vaishnavi.optustest.data.Album
import com.vaishnavi.optustest.data.User
import kotlinx.android.synthetic.main.activity_main.*

class AlbumActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_album)
        setSupportActionBar(toolbar)

        //set up recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.albumRecyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set Up ViewModel
        val viewModel : AlbumViewModel = ViewModelProviders.of(this)[AlbumViewModel::class.java]
        viewModel.getAlbum().observe(this, object : Observer<List<Album>> {
            override fun onChanged(list: List<Album>) {
                recyclerView.adapter = AlbumAdapter(applicationContext, list)
            }
        })
    }
}
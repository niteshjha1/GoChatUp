package com.example.niteshrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.galacticon.ImageRequester
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var adapter: RecyclerAdapter

class MainActivity : AppCompatActivity(), ImageRequester.ImageRequesterResponse {

    private var photosList: ArrayList<Photo> = ArrayList()
    private lateinit var imageRequester: ImageRequester

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter(photosList)
        recyclerView.adapter = adapter


        imageRequester = ImageRequester(this)
    }

    override fun onStart() {
        super.onStart()
    }

    private fun requestPhoto() {
        try {
            imageRequester.getPhoto()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun receivedNewPhoto(newPhoto: Photo) {
        runOnUiThread {
            photosList.add(newPhoto)
        }
    }
}

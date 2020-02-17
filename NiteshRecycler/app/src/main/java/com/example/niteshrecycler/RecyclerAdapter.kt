package com.example.niteshrecycler

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.galacticon.PhotoActivity


class RecyclerAdapter(private val photos: ArrayList<Photo>)

RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.PhotoHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return PhotoHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        override fun getItemCount() = photos.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.PhotoHolder, position: Int) {
        RecyclerAdapter.PhotoHolder {
            val context = itemView.context
            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
            showPhotoIntent.putExtra(PHOTO_KEY, photo)
            context.startActivity(showPhotoIntent)
        }

    }
}

//1
class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    //2
    val context = itemView.context
    val showPhotoIntent = Intent(context, PhotoActivity::class.java)
    showPhotoIntent.putExtra(PHOTO_KEY, photo)
    context.startActivity(showPhotoIntent)

    private var view: View = v
    private var photo: Photo? = null

    //3
    init {
        v.setOnClickListener(this)
    }

    //4
    override fun onClick(v: View) {
        val context = itemView.context
        val showPhotoIntent = Intent(context, PhotoActivity::class.java)
        showPhotoIntent.putExtra(PHOTO_KEY, photo)
        context.startActivity(showPhotoIntent)
    }

    companion object {
        //5
        private val PHOTO_KEY = "PHOTO"
    }
}
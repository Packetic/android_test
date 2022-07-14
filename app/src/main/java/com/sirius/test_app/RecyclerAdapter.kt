package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var dataModel = DataModel()

    // creating lists of data
    // DO NOT CHANGE BEFORE CHANGING DataModel.kt
    private var names = arrayOf(dataModel.reviews[0].userName, dataModel.reviews[1].userName)
    private var datas = arrayOf(dataModel.reviews[0].date, dataModel.reviews[1].date)
    private var reviews = arrayOf(dataModel.reviews[0].message, dataModel.reviews[1].message)
    private var images = intArrayOf(R.drawable.img_user_1, R.drawable.img_user_2)

    // putting comment model to the recycleView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.for_recycle, parent, false)
        return ViewHolder(v)
    }

    // creating bond between holder element and actual data
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemName.text = names[position]
        holder.itemData.text = datas[position]
        holder.itemReview.text = reviews[position]
        holder.itemImage.setImageResource(images[position])
    }

    // amount of items in recycleView
    override fun getItemCount(): Int {
        return names.size
    }

    // creating fields of holder
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemData: TextView
        var itemReview: TextView

        init {
            itemImage = itemView.findViewById(R.id.image_user)
            itemName = itemView.findViewById(R.id.name)
            itemData = itemView.findViewById(R.id.data)
            itemReview = itemView.findViewById(R.id.review)
        }
    }
}
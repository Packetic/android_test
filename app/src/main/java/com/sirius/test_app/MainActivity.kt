package com.sirius.test_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        this.supportActionBar?.hide()

        val model = DataModel()

        // getting views from xml file
        val dota: TextView = findViewById(R.id.dotaText)
        val mils: TextView = findViewById(R.id._70mil)
        val moba: TextView = findViewById(R.id.moba)
        val multiplayer: TextView = findViewById(R.id.multiplayer)
        val strategy: TextView = findViewById(R.id.strategy)
        val description: TextView = findViewById(R.id.description)
        val reviewsRatings: TextView = findViewById(R.id.reviews_amp_ratings)
        val rating: TextView = findViewById(R.id.average)
        val numRatings: TextView = findViewById(R.id.num_of_ratings_ext)
        val background: ImageView = findViewById(R.id.background)
        val icon: ImageView = findViewById(R.id.icon)
        val button: Button = findViewById(R.id.button_install)

        // setting data to views from the model
        dota.text = model.name
        mils.text = model.gradeCnt
        moba.text = model.tags[0]
        multiplayer.text = model.tags[1]
        strategy.text = model.tags[2]
        description.text = model.description
        reviewsRatings.text = "Reviews & ratings"
        rating.text = model.rating.toString()
        numRatings.text = "70M Reviews"
        background.setBackgroundResource(R.drawable.img_background)
        icon.setBackgroundResource(R.drawable.img_logo)
        button.text = model.action.name

        // to make layoutManager work
        layoutManager = LinearLayoutManager(this)

        // setting adapter and layoutManager of recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.comments)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
    }
}
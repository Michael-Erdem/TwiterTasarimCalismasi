package com.example.twitertasarimcalismasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitertasarimcalismasi.R
import com.example.twitertasarimcalismasi.data.StoryProfile
import com.google.android.material.snackbar.Snackbar

class StoryProfileAdapter
    (
    private val context: Context,
    private val storyList: List<StoryProfile>)
    : RecyclerView.Adapter<StoryProfileAdapter.CardViewHolder>(){
    inner class CardViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nameTextView: TextView
        var profileImage: ImageView
        var cardView: CardView

        init {
            nameTextView = view.findViewById(R.id.textViewProfileName)
            profileImage = view.findViewById(R.id.profileImageStory)
            cardView = view.findViewById(R.id.cardView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var profileView = LayoutInflater.from(context).inflate(R.layout.story_profile,parent,false)

        return CardViewHolder(profileView)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val storyProfile = storyList[position]

        holder.nameTextView.text = storyProfile.profileName
        holder.profileImage.setImageResource(context.resources.getIdentifier(storyProfile.porfileImage,"drawable",context.packageName))

        holder.cardView.setOnClickListener{
            Snackbar.make(it,"Name = ${storyProfile.profileName}",Snackbar.LENGTH_SHORT).show()
        }

    }

}
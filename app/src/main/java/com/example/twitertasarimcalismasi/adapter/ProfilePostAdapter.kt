package com.example.twitertasarimcalismasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.twitertasarimcalismasi.R
import com.example.twitertasarimcalismasi.data.ProfilePost

class ProfilePostAdapter (
    private val context: Context,
    private val postList: List<ProfilePost>)
    :RecyclerView.Adapter<ProfilePostAdapter.CardViewHolder>(){
    inner class CardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var profilePicture: ImageView
        var profileName: TextView
        var profileNickName: TextView
        var postText: TextView
        var postImage: ImageView
        var commentNumber: TextView
        var remixNumber: TextView
        var heartNumber: TextView
        var likeAnimation:LottieAnimationView
        var ImageViewThreeDot:ImageView
        init {
            ImageViewThreeDot = view.findViewById(R.id.imageViewThreeDots)
            likeAnimation = view.findViewById(R.id.like_animation)
            profilePicture = view.findViewById(R.id.profileImagePost)
            profileName = view.findViewById(R.id.textViewName)
            profileNickName = view.findViewById(R.id.textViewNickName)
            postText = view.findViewById(R.id.textViewStoryText)
            postImage = view.findViewById(R.id.imageViewPhoto)
            commentNumber = view.findViewById(R.id.textViewCommentNumber)
            remixNumber = view.findViewById(R.id.textViewRemixNumber)
            heartNumber = view.findViewById(R.id.textViewHearthNumber)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var postView = LayoutInflater.from(context).inflate(R.layout.post_card,parent,false)

        return CardViewHolder(postView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var post = postList[position]
        holder.profileName.text = post.profileName
        holder.profileNickName.text = post.profileNickName
        holder.profilePicture.setImageResource(context.resources.getIdentifier(post.profilePicture,"drawable",context.packageName))
        if (post.postImageTF){
            holder.postImage.visibility = View.VISIBLE
            holder.postImage.setImageResource(context.resources.getIdentifier(post.postImage,"drawable",context.packageName))
        }else{
            holder.postImage.visibility = View.GONE
        }
        holder.commentNumber.text = post.commentNumber.toString()
        holder.remixNumber.text = post.remixNumber.toString()
        holder.heartNumber.text = post.heartNumber.toString()
        holder.postText.text = post.postText
        var heartTF = true
        holder.heartNumber.setOnClickListener {
                holder.heartNumber.visibility = View.INVISIBLE
                holder.likeAnimation.visibility = View.VISIBLE
                holder.likeAnimation.playAnimation()

        }
        holder.likeAnimation.setOnClickListener{
            holder.heartNumber.visibility = View.VISIBLE
            holder.likeAnimation.visibility = View.INVISIBLE
        }
        holder.ImageViewThreeDot.setOnClickListener{
            val popup = PopupMenu(context,holder.ImageViewThreeDot)
            popup.menuInflater.inflate(R.menu.post_menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.block_user -> {
                        Toast.makeText(context,"Clicked Block User",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.report_user -> {
                        Toast.makeText(context,"Clicked Report User",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }

}
package com.example.twitertasarimcalismasi

import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.twitertasarimcalismasi.adapter.ProfilePostAdapter
import com.example.twitertasarimcalismasi.adapter.StoryProfileAdapter
import com.example.twitertasarimcalismasi.data.ProfilePost
import com.example.twitertasarimcalismasi.data.StoryProfile
import com.example.twitertasarimcalismasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var storyProfileListesi: ArrayList<StoryProfile>
    lateinit var adapterStoryProfile: StoryProfileAdapter
    lateinit var postProfileListesi: ArrayList<ProfilePost>
    lateinit var adapterPostProfile: ProfilePostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewStory.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.recyclerViewPost.layoutManager = LinearLayoutManager(this@MainActivity)
        var story1 = StoryProfile("bill_gates","Bill Gates")
        var story2 = StoryProfile("steve_jobs","Steve Jobs")
        var story3 = StoryProfile("michael","Michael")
        var story4 = StoryProfile("bob","Bob")
        var story5 = StoryProfile("andrew_tate","Andrew Tate")
        var story6 = StoryProfile("elon_musk","Elon Musk")
        var story7 = StoryProfile("sezen_aksu","Sezen Aksu")
        var story8 = StoryProfile("selena","Selena")
        var story9 = StoryProfile("marry","Mary")
        var story10 = StoryProfile("action_hero","Steve")
        storyProfileListesi = ArrayList()
        storyProfileListesi.add(story1)
        storyProfileListesi.add(story2)
        storyProfileListesi.add(story3)
        storyProfileListesi.add(story4)
        storyProfileListesi.add(story5)
        storyProfileListesi.add(story6)
        storyProfileListesi.add(story7)
        storyProfileListesi.add(story8)
        storyProfileListesi.add(story9)
        storyProfileListesi.add(story10)

        adapterStoryProfile = StoryProfileAdapter(this@MainActivity,storyProfileListesi)

        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(this@MainActivity,"You Clicked This Fab Button",Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewStory.adapter = adapterStoryProfile
        //****************************************************************************************************************//
        //postRecyclerView
        var post1 = ProfilePost("bob","Bob","@Bob1539","Hello I am new to this app can someone teach me how to use this app","",3,1,4,false)
        var post2 = ProfilePost("michael","Michael","@MichaelPro1639","I like this app so much that I use it every day to have some fun by reading peoples posts","",6,2,8,false)
        var post3 = ProfilePost("andrew_tate","Andrew Tate","@AndrewTate","I went to a holiday you broke guys go breath air","sea_photo",185,89,1419,true)
        var post4 = ProfilePost("elon_musk","Elon musk","@ElonMusk","Hello I am the owner of this app","",154,1,14321,false)
        var post5 = ProfilePost("sezen_aksu","Sezen Aksu","@SezenAksu","Hello I went to a place where it is so good","ballon_photo",231,1,45634,true)
        var post6 = ProfilePost("steve_jobs","Steve Jobs","@SteveJobs","I worked so hard in my life it is time to play Minecraft at a good quality","maxresdefault",2143,18,95852,true)
        var post7 = ProfilePost("action_hero","Steve","@Steve9345","Hello I can make a burger","",7,4,9,false)
        var post8 = ProfilePost("selena","Selena","@Selena","Hello I am a popular person in a film","",4532,2,9331,false)
        var post9 = ProfilePost("marry","Marry","@Marryy92","I am a popular person do you guys know who I am?","",6723,6,4261,false)
        var post10 = ProfilePost("steve_jobs","Steve Jobs","@SteveJobs","I created a brand called Apple","",41392,1,39134,false)

        postProfileListesi = ArrayList()
        postProfileListesi.add(post1)
        postProfileListesi.add(post2)
        postProfileListesi.add(post3)
        postProfileListesi.add(post4)
        postProfileListesi.add(post5)
        postProfileListesi.add(post6)
        postProfileListesi.add(post7)
        postProfileListesi.add(post8)
        postProfileListesi.add(post9)
        postProfileListesi.add(post10)
        adapterPostProfile = ProfilePostAdapter(this@MainActivity,postProfileListesi)
        binding.recyclerViewPost.adapter = adapterPostProfile



    }
}
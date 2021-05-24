package com.example.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.Interface.NetworkApi
import com.example.test.Model.PostsItem
import com.example.test.R
import com.example.test.ServiceBuilder
import com.example.test.adapters.PostItemAdapter
import kotlinx.android.synthetic.main.fragment_names.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentNames : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        val request = ServiceBuilder.buildService(NetworkApi::class.java)
        val call = request.getAllPosts()

        call.enqueue(object : Callback<PostsItem> {
            override fun onFailure(call: Call<PostsItem>, t: Throwable) {
             }

            override fun onResponse(call: Call<PostsItem>, response: Response<PostsItem>) {
                if (response.isSuccessful) {
                    rv_post_list.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = PostItemAdapter(response.body()!!.data)
                    }
                }

            }

        })






        return inflater.inflate(R.layout.fragment_names, container, false)
    }

}
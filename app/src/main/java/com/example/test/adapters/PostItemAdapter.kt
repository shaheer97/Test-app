package com.example.test.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.Model.Data
import com.example.test.R
import kotlinx.android.synthetic.main.post_item_layout.view.*

class PostItemAdapter(val postList: List<Data> ) :
    RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {



        fun bind(data: Data) {

            name.text=data.name
            trans.text=data.transliteration
            meaning.text=data.en.meaning
        }

        var name: TextView
        var trans: TextView
        var meaning: TextView



        init {
            name = view.text_name
            trans = view.text_trans
            meaning = view.text_meaning
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {

            return postList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        return holder.bind(postList[position])






    }


}


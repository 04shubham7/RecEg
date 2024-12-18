package com.example.recyclerviewusingviewbinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewusingviewbinding.databinding.RvItemRowBinding
import kotlin.contracts.contract

class RvAdapter(var context: Context,var newsArray: ArrayList<data>):RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    inner class ViewHolder(val binding:RvItemRowBinding):RecyclerView.ViewHolder(binding.root){
//        val textView: TextView=itemView.findViewById(R.id.textView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var binding=RvItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)


//
//        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.rv_item_row,parent,false)
//        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val current=newsArray[position]
        holder.binding.tv1.text=current.stunames
        holder.binding.tv2.text=current.stunumber.toString()
        holder.binding.iv1.setImageResource(current.stuimages)
        holder.binding.iv1.setOnClickListener {
            Toast.makeText(context, "Image" + position, Toast.LENGTH_LONG).show()
        }
        holder.binding.cv1.setOnClickListener{
            Toast.makeText(context,"Layout"+position,Toast.LENGTH_LONG).show()
        }

    }

}
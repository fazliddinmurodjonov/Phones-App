package com.example.androiddatabaselesson2phoneapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabaselesson2phoneapp.databinding.ItemPhoneLBinding
import com.example.androiddatabaselesson2phoneapp.model.Phone

class PhonesAdapter(var phoneList: ArrayList<Phone>) :
    RecyclerView.Adapter<PhonesAdapter.MyViewHolder>() {
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(phone: Phone, position: Int)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }

    inner class MyViewHolder(var binding: ItemPhoneLBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(phone: Phone, position: Int) {
            binding.Phone.text = phone.name
            binding.root.setOnClickListener {
                adapterListener.onClick(phone, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPhoneLBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val phone = phoneList[position]
        holder.onBind(phone, position)
    }

    override fun getItemCount(): Int = phoneList.size


}
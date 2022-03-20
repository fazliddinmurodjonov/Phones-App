package com.example.androiddatabaselesson2phoneapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabaselesson2phoneapp.databinding.ItemPhoneLBinding

class PhoneAdapterToAddPhone(var phoneTypeList:ArrayList<String>) :RecyclerView.Adapter<PhoneAdapterToAddPhone.MyViewHolder>(){
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(phoneType: String, position: Int)
    }

    fun setOnMyItemClickListener(listener:OnMyItemClickListener) {
        adapterListener = listener
    }

    inner class MyViewHolder(var binding: ItemPhoneLBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(phoneType: String, position: Int) {
            binding.Phone.text = phoneType
            binding.root.setOnClickListener {
                adapterListener.onClick(phoneType, position)
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
        val phone = phoneTypeList[position]
        holder.onBind(phone, position)
    }

    override fun getItemCount(): Int = phoneTypeList.size


}
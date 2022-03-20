package com.example.androiddatabaselesson2phoneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2phoneapp.adapter.PhoneAdapterToAddPhone
import com.example.androiddatabaselesson2phoneapp.adapter.PhoneAdapterToPhone
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentPhonesBinding
import com.example.androiddatabaselesson2phoneapp.db.PhoneDbHelper
import com.example.androiddatabaselesson2phoneapp.util.Constant
import com.example.androiddatabaselesson2phoneapp.util.PhoneType


class PhonesFragment : Fragment() {

    lateinit var binding: FragmentPhonesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonesBinding.inflate(inflater, container, false)
        val phoneTypeList = PhoneType().phoneTypes()
        var adapterToPhone = PhoneAdapterToPhone(phoneTypeList)
        binding.phonesTypeRV.adapter = adapterToPhone

        adapterToPhone.setOnMyItemClickListener(object : PhoneAdapterToPhone.OnMyItemClickListener {
            override fun onClick(phoneType: String, position: Int) {
                val bundleOf = bundleOf("phoneType" to phoneType)
                findNavController().navigate(R.id.phoneListFragment, bundleOf)
            }

        })

        return binding.root
    }

}
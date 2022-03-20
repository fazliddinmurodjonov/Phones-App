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
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentAddPhoneTypeBinding
import com.example.androiddatabaselesson2phoneapp.util.PhoneType


class AddPhoneTypeFragment : Fragment() {
    lateinit var binding: FragmentAddPhoneTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPhoneTypeBinding.inflate(inflater, container, false)

        var phoneTypeList = PhoneType().phoneTypes()
        var adapterToAddPhone = PhoneAdapterToAddPhone(phoneTypeList)
        binding.phoneRV.adapter = adapterToAddPhone

        adapterToAddPhone.setOnMyItemClickListener(object:PhoneAdapterToAddPhone.OnMyItemClickListener{
            override fun onClick(phoneType: String, position: Int) {
                val bundleOf = bundleOf("phoneType" to phoneType)
                findNavController().navigate(R.id.addPhoneDetailsFragment,bundleOf)
            }

        })
        return binding.root

    }


}
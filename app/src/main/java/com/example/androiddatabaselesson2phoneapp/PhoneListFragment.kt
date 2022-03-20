package com.example.androiddatabaselesson2phoneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2phoneapp.adapter.PhoneAdapterToAddPhone
import com.example.androiddatabaselesson2phoneapp.adapter.PhonesAdapter
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentPhoneListBinding
import com.example.androiddatabaselesson2phoneapp.db.PhoneDbHelper
import com.example.androiddatabaselesson2phoneapp.model.Phone
import com.example.androiddatabaselesson2phoneapp.util.PhoneType


class PhoneListFragment : Fragment() {

    lateinit var binding: FragmentPhoneListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneListBinding.inflate(inflater, container, false)
        val phoneDbHelper = PhoneDbHelper(requireContext())
        val phoneType = arguments?.getString("phoneType")
        val phoneTypesList = phoneDbHelper.getAllPhoneByType(phoneType!!)

        var phonesAdapter = PhonesAdapter(phoneTypesList)
        binding.phoneTypesRV.adapter = phonesAdapter


        phonesAdapter.setOnMyItemClickListener(object : PhonesAdapter.OnMyItemClickListener{
            override fun onClick(phone: Phone, position: Int) {
                val bundleOf = bundleOf("id" to phone.id)
                findNavController().navigate(R.id.aboutPhoneFragment,bundleOf)
            }

        })

        return binding.root
    }


}
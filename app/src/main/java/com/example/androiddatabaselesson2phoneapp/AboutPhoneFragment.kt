package com.example.androiddatabaselesson2phoneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentAboutPhoneBinding
import com.example.androiddatabaselesson2phoneapp.db.PhoneDbHelper


class AboutPhoneFragment : Fragment() {
    lateinit var binding: FragmentAboutPhoneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutPhoneBinding.inflate(inflater, container, false)
        val id = arguments?.getInt("id")
        val phoneDbHelper = PhoneDbHelper(requireContext())
        val phoneById = phoneDbHelper.getPhoneById(id!!)
        binding.phoneNameAbout.text = phoneById.name
        binding.phoneFeaturesAbout.text = phoneById.features
        return binding.root
    }

}
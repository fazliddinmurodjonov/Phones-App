package com.example.androiddatabaselesson2phoneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.phones.setOnClickListener {
            findNavController().navigate(R.id.phonesFragment)
        }
        binding.addPhone.setOnClickListener {
            findNavController().navigate(R.id.addPhoneTypeFragment)
        }
        return binding.root
    }

}
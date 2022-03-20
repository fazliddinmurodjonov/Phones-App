package com.example.androiddatabaselesson2phoneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2phoneapp.databinding.FragmentAddPhoneDetailsBinding
import com.example.androiddatabaselesson2phoneapp.db.PhoneDbHelper
import com.example.androiddatabaselesson2phoneapp.model.Phone

class AddPhoneDetailsFragment : Fragment() {

    lateinit var binding: FragmentAddPhoneDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPhoneDetailsBinding.inflate(inflater, container, false)
        val phoneType = arguments?.getString("phoneType")
        val phoneDbHelper = PhoneDbHelper(requireContext())
        binding.AddButton.setOnClickListener {
            var phoneName = binding.AddPhoneName.text.toString()
            var phoneFeatures = binding.AddPhoneFeatures.text.toString()
            var emptyOne: Boolean = false
            var emptyTwo: Boolean = false
            for (c in phoneName) {
                if (c != ' ') {
                    emptyOne = true
                    break
                }
            }
            for (phoneFeature in phoneFeatures) {
                if (phoneFeature != ' ') {
                    emptyTwo = true
                    break
                }
            }
            if (phoneName != "" && phoneFeatures != "" && emptyOne && emptyTwo) {
                var phone = Phone(phoneName, phoneFeatures, phoneType)
                phoneDbHelper.addPhone(phone)
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack(R.id.mainFragment, false)
            }
        }

        return binding.root
    }


}
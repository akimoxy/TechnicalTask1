package com.example.technicaltask1.login.firstPage.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.technicaltask1.R
import com.example.technicaltask1.databinding.FragmentLoginPageFirstBinding

class LoginFirstPageFragment : Fragment() {
    private var _binding: FragmentLoginPageFirstBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginPageFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonContinueLogic()
        inputEditTextLogic()
        otherSetOnClickListenerLogic()
    }

    private fun buttonContinueLogic() {
        with(binding) {
            bttnContinue.isEnabled = false
            bttnContinue.alpha = 0.9F
            bttnContinue.setOnClickListener {
                if (Patterns.EMAIL_ADDRESS.matcher(etInput.text.toString()).matches()) {
                    firstPageFrame1.setBackground(getResources().getDrawable(R.drawable.edit_text_search_background))
                    redTextFirstScreen.isVisible = false
                    findNavController().navigate(R.id.action_loginFirstPageFragment_to_loginSecondPageFragment)
                } else {
                    firstPageFrame1.setBackground(getResources().getDrawable(R.drawable.edit_text_stroke_red))
                    redTextFirstScreen.isVisible = true
                }
            }
        }
    }

    private fun inputEditTextLogic() {
        binding.etInput.doOnTextChanged { text, _, _, _ ->
            if (text!!.isNotEmpty()) {
                binding.bttnContinue.isEnabled = true
                binding.bttnContinue.alpha = 1F
            }
            binding.etInput.setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    binding.closeIvFirstPage.isVisible = true
                }
            }
        }
    }

    private fun otherSetOnClickListenerLogic() {
        binding.closeIvFirstPage.setOnClickListener {
            binding.etInput.text.clear()
            binding.bttnContinue.isEnabled = false
            binding.firstPageFrame1.setBackground(getResources().getDrawable(R.drawable.edit_text_search_background))
            binding.redTextFirstScreen.isVisible = false
        }

        binding.bttnLogin.setOnClickListener {
            // some logic
        }
        binding.bttnSearchEmployees.setOnClickListener {
            // some logic
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
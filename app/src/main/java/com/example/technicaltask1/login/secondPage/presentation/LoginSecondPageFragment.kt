package com.example.technicaltask1.login.secondPage.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.technicaltask1.R
import com.example.technicaltask1.databinding.FragmentLoginPageSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginSecondPageFragment : Fragment() {
    private var _binding: FragmentLoginPageSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SecondPageViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginPageSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = arguments?.getString("password").toString()
        binding.emailSecondPage.text = email
        binding.bttnContinueSecond.isEnabled = false

        viewModel.getState().observe(viewLifecycleOwner) { showView(it, binding) }

        transformationDotEditText(binding)
        startEnterPassword(binding, viewModel)


       binding.bttnContinueSecond.setOnClickListener {
           findNavController().navigate(R.id.action_loginSecondPageFragment_to_searchFragment)
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun showView(it: SecondPageState, binding: FragmentLoginPageSecondBinding) {
    when (it) {
        is SecondPageState.Password -> {
            binding.bttnContinueSecond.alpha = 0.7F
            binding.bttnContinueSecond.isEnabled = false
        }

        is SecondPageState.AllDigitInPassword -> {
            binding.bttnContinueSecond.isEnabled = true
            binding.bttnContinueSecond.alpha = 1F
        }
    }
}

private fun passwordTransformationMethod() = object : PasswordTransformationMethod() {
    override fun getTransformation(
        source: CharSequence?,
        view: View?
    ): CharSequence {
        return PasswordCharSequence(super.getTransformation(source, view))
    }

    inner class PasswordCharSequence(private val source: CharSequence) : CharSequence {
        override val length: Int get() = source.length
        override fun get(index: Int): Char {
            //Only modify char '\u2022' if you want to keep the default behaviour
            return if (source[index] == '\u2022') '*' else source[index]
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return source.subSequence(startIndex, endIndex)
        }
    }
}

private fun transformationDotEditText(binding: FragmentLoginPageSecondBinding) {
    binding.otp1.transformationMethod = passwordTransformationMethod()
    binding.otp2.transformationMethod = passwordTransformationMethod()
    binding.otp3.transformationMethod = passwordTransformationMethod()
    binding.otp4.transformationMethod = passwordTransformationMethod()
}

fun saveDigit(
    editText: EditText,
    binding: FragmentLoginPageSecondBinding,
    p0: CharSequence?,
    viewModel: SecondPageViewModel
) {
    if (editText == binding.otp1) if (p0 != null) viewModel.saveDigit1(
        p0.toString().toInt()
    ) else viewModel.saveDigit1(null)
    if (editText == binding.otp2) if (p0 != null) viewModel.saveDigit2(
        p0.toString().toInt()
    ) else viewModel.saveDigit2(null)
    if (editText == binding.otp3) if (p0 != null) viewModel.saveDigit3(
        p0.toString().toInt()
    ) else viewModel.saveDigit3(null)
    if (editText == binding.otp4) if (p0 != null) viewModel.saveDigit4(
        p0.toString().toInt()
    ) else viewModel.saveDigit4(null)
}

private fun startEnterPassword(
    binding: FragmentLoginPageSecondBinding,
    viewModel: SecondPageViewModel
) {
    with(binding) {
        otp2.isEnabled = false
        otp3.isEnabled = false
        otp4.isEnabled = false
        textWatcher(otp1, otp2, binding, viewModel)
        textWatcher(otp2, otp3, binding, viewModel)
        textWatcher(otp3, otp4, binding, viewModel)
        textWatcher(otp4, null, binding, viewModel)
    }
}

private fun textWatcher(
    currentEditText: EditText,
    nextEditText: EditText?,
    binding: FragmentLoginPageSecondBinding,
    viewModel: SecondPageViewModel
) {
    currentEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {
            if (p0?.length == 1) {
                saveDigit(currentEditText, binding, p0, viewModel)
                // Move focus to next EditText
                nextEditText?.isEnabled = true
                nextEditText?.requestFocus()
                viewModel.passwordCheck()
            }
            if (p0?.length == 0) {
                saveDigit(currentEditText, binding, null, viewModel)
                binding.bttnContinueSecond.isEnabled = false
                viewModel.passwordCheck()
            }
        }
    })
}
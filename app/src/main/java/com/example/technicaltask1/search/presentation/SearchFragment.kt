package com.example.technicaltask1.search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicaltask1.R
import com.example.technicaltask1.databinding.FragmentLoginPageFirstBinding
import com.example.technicaltask1.databinding.FragmentSearchBinding
import com.example.technicaltask1.search.domain.Vacancy


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val listVacancy = listOf<Vacancy>()
    private val adapterVacacancy: VacancyAdapter =
        VacancyAdapter(listVacancy, ::vacancyClickListener)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapterAndRecycler()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun vacancyClickListener(vacancy: Vacancy) {
//some logic
    }
    private fun initAdapterAndRecycler(){
        binding.searchRecyclerVacancy.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.searchRecyclerVacancy.adapter = adapterVacacancy
    }
}

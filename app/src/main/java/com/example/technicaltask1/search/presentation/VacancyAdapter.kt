package com.example.technicaltask1.search.presentation

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.technicaltask1.R
import com.example.technicaltask1.databinding.FragmentSearchBinding
import com.example.technicaltask1.databinding.VacancyItemBinding
import com.example.technicaltask1.search.domain.Vacancy
import com.example.technicaltask1.utils.dpToPx
import java.text.SimpleDateFormat
import java.util.Locale

class VacancyAdapter(
    private var listVacancy: List<Vacancy>, private var clickListener: (vacancy: Vacancy) -> Unit
) : RecyclerView.Adapter<VacancyAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VacancyItemBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listVacancy[position])
        holder.itemView.setOnClickListener {
            clickListener(listVacancy[position])
        }
    }


    fun updateList(newList: List<Vacancy>) {
        listVacancy = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listVacancy.size
    }

    inner class SearchViewHolder(private val binding: VacancyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Vacancy) {
            if (item.lookingNumber != null) binding.searchTvCountOfPeople.text =
                item.lookingNumber.toString() else binding.searchTvCountOfPeople.visibility =
                View.GONE
            if (item.isFavorite) binding.searchLikeBttn.setBackgroundResource(R.drawable.like_bttn_blue) else binding.searchLikeBttn.setBackgroundResource(
                R.drawable.heart_icon
            )
            binding.searchVacancyTitle.text = item.title
            if (item.adress?.town != null) binding.searchVacancyTown.text =
                item.adress!!.town else binding.searchVacancyTown.visibility = View.GONE
            binding.searchVacancyCompany.text = item.company
            binding.searchVacancyExperience.text = item.experience!!.previewText

            binding.searchVacancyPublishedDate.text = "заменить->опубликванo" + item.publishedDate


        }

    }
}
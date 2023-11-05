package com.asoom.repositoriesgit.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.asoom.repositoriesgit.databinding.FragmentDetailsBinding
import com.asoom.repositoriesgit.viewmodel.RepoDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private val viewModel: RepoDetailsViewModel by viewModels()
    private lateinit var binding: FragmentDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val owner = arguments?.getString("owner")
        val repo = arguments?.getString("repo")


        owner?.let { owner ->
            repo?.let { repo ->
                viewModel.fetchRepoDetails(owner, repo)
            }
        }

        val view = binding.root

        fun formatDate(date: Date): String {
            val currentDate = Calendar.getInstance().time
            val diff = currentDate.time - date.time
            val daysAgo = diff / (1000 * 60 * 60 * 24)

            return when {
                daysAgo in 180..365  -> {
                    val dateFormat = SimpleDateFormat("EEEE, MMM d, yyyy", Locale.getDefault())
                    dateFormat.format(date)
                }
                daysAgo in 120..180 -> {
                    val monthsAgo = (daysAgo/30).toInt()
                    "$monthsAgo months ago"

                }
                daysAgo > 365 -> {
                    val yearsAgo = (daysAgo / 365).toInt()
                    "$yearsAgo years ago"
                }
                else -> "Today"
            }
        }


        fun formatCreationDate(date: Date): String {
            return formatDate(date)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.repositoryDetails.collect { details ->

                binding.details = details
                details?.let {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    val date = dateFormat.parse(it.createdAt!!)
                    val formattedDate = formatCreationDate(date!!)
                    binding.createdDate.text = formattedDate
                }
            }
        }
        return view
    }
}

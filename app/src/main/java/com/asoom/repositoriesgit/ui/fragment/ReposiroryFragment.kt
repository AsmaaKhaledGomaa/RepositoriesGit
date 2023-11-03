package com.asoom.repositoriesgit.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asoom.repositoriesgit.R
import com.asoom.repositoriesgit.databinding.FragmentReposiroryBinding
import com.asoom.repositoriesgit.viewmodel.RepoViewModel
import com.asoom.repository.adapter.RepoAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ReposiroryFragment : Fragment() {

    private var _binding: FragmentReposiroryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RepoViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RepoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposiroryBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.viewModel = viewModel

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = RepoAdapter { clickedRepo ->
            val action = ReposiroryFragmentDirections.actionReposiroryFragmentToDetailsFragment(
                owner = clickedRepo.owner.login,
                repo = clickedRepo.name
            )
            findNavController().navigate(action)
            Log.d("Fragment", "Received details: ${action.arguments}")
        }
        recyclerView.adapter = adapter

        // Observe the repositories and update the adapter when the data changes
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.repositories.collect { repositories ->
                adapter.setItems(repositories)

            }
        }

        // Fetch repositories when the fragment is created
        viewModel.fetchRepositories()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
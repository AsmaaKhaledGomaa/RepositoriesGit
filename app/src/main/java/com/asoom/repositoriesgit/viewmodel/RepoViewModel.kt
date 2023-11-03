package com.asoom.repositoriesgit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asoom.domain.entity.GitHupRepo
import com.asoom.domain.usecase.FetchRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(
    private val fetchRepositoriesUseCase: FetchRepositoriesUseCase,
) : ViewModel() {

    private val _repositories: MutableStateFlow<List<GitHupRepo>> = MutableStateFlow(emptyList())
    val repositories: StateFlow<List<GitHupRepo>> = _repositories

    fun fetchRepositories() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newRepositories = fetchRepositoriesUseCase()
                _repositories.value = newRepositories
            } catch (e: Exception) {
            }
        }
    }
}

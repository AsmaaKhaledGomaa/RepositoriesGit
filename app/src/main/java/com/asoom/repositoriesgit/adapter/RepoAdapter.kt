package com.asoom.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asoom.domain.entity.GitHupRepo
import com.asoom.repositoriesgit.databinding.RepositoryItemBinding
import com.bumptech.glide.Glide


class RepoAdapter(private val onItemClick: (GitHupRepo) -> Unit)
    : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private val items = mutableListOf<GitHupRepo>()

    fun setItems(repoDetails: List<GitHupRepo>) {
        items.clear()
        items.addAll(repoDetails)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepositoryItemBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items[position]
        holder.bind(repo)

        // Set the click listener for the item view
        holder.itemView.setOnClickListener {
            onItemClick(repo)
        }
    }

    inner class RepoViewHolder(private val binding: RepositoryItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(gitHupRepo: GitHupRepo) {
            binding.gitHupRepo = gitHupRepo

            Glide.with(binding.root.context)
                .load(gitHupRepo.owner.avatar_url)
                .circleCrop() // for circular avatars
                .into(binding.avatar)
        }
    }
}


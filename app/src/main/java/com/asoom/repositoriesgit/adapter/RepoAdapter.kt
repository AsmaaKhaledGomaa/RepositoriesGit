package com.asoom.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asoom.domain.entity.GitHubRepo
import com.asoom.repositoriesgit.databinding.RepositoryItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class RepoAdapter(private val onItemClick: (GitHubRepo) -> Unit)
    : ListAdapter<GitHubRepo, RepoAdapter.RepoViewHolder>(RepoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepositoryItemBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = getItem(position)
        holder.bind(repo)

        // Set the click listener for the item view
        holder.itemView.setOnClickListener {
            onItemClick(repo)
        }
    }

    inner class RepoViewHolder(private val binding: RepositoryItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(gitHubRepo: GitHubRepo) {
            binding.gitHupRepo = gitHubRepo

            Glide.with(binding.root.context)
                .load(gitHubRepo.owner.avatarUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop() // for circular avatars
                .into(binding.avatar)
        }
    }
    class RepoDiffCallback : DiffUtil.ItemCallback<GitHubRepo>() {
        override fun areItemsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem == newItem
        }
    }

}

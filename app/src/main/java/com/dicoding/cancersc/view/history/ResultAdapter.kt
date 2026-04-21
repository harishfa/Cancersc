package com.dicoding.cancersc.view.history

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.cancersc.R
import com.dicoding.cancersc.data.local.ClassificationResult
import com.dicoding.cancersc.databinding.ClassificationResultItemBinding
import com.dicoding.cancersc.util.parseTimestamp
import com.dicoding.cancersc.view.result.ResultActivity
import java.text.NumberFormat

class ResultAdapter : ListAdapter<ClassificationResult, ResultAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(private val binding: ClassificationResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassificationResult) {
            Glide.with(itemView)
                .load(item.imageUri)
                .into(binding.ivImage)
            binding.tvLabel.text = item.label
            binding.tvScore.text = NumberFormat.getPercentInstance().format(item.score)
            binding.tvTimestamp.text = parseTimestamp(item.timestamp)
            if (item.label != "Cancer") {
                binding.tvLabel.setTextColor(itemView.context.getColor(R.color.pink))
                binding.tvScore.setTextColor(itemView.context.getColor(R.color.pink))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ClassificationResult>() {
            override fun areItemsTheSame(
                oldItem: ClassificationResult,
                newItem: ClassificationResult,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ClassificationResult,
                newItem: ClassificationResult,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ClassificationResultItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(ResultActivity.EXTRA_RESULT, item)
            context.startActivity(intent)
        }
    }
}

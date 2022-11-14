package com.example.todoapp.fragments.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.models.ToDoData
import com.example.todoapp.databinding.RowLayoutBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

     var dataList = emptyList<ToDoData>()

    class MyViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(toDoData: ToDoData) {
            binding.toDoData = toDoData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)

        /*
//        holder.binding.titleTxt.text = dataList[position].title
//        holder.binding.descriptionTxt.text = dataList[position].description
//
//        holder.binding.rowBackground.setOnClickListener {
//            val action =
//                ListFragmentDirections.actionListFragmentToUpdateFragment(dataList[position])
//            holder.binding.root.findNavController().navigate(action)
//        }
//        when (dataList[position].priority) {
//            Priority.HIGH -> holder.binding.prioritiesIndicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.binding.root.context,
//                    R.color.red
//                )
//            )
//            Priority.MEDIUM -> holder.binding.prioritiesIndicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.binding.root.context,
//                    R.color.yellow
//                )
//            )
//            Priority.LOW -> holder.binding.prioritiesIndicator.setCardBackgroundColor(
//                ContextCompat.getColor(
//                    holder.binding.root.context,
//                    R.color.green
//                )
//            )
//        }
*/

    }

    fun setData(toDoData: List<ToDoData>) {
        val toDoDiffUtil = ToDoDiffUtil(dataList,toDoData)
        val toDoDiffResult = DiffUtil.calculateDiff(toDoDiffUtil)
        this.dataList = toDoData
        toDoDiffResult.dispatchUpdatesTo(this)

    }

    override fun getItemCount(): Int = dataList.size
}
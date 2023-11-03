package com.example.listemail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCaption: TextView = itemView.findViewById(R.id.text_caption)
        val textMessage: TextView = itemView.findViewById(R.id.text_mess)
        val textTime: TextView = itemView.findViewById(R.id.text_time)
        val imageAvatar: ImageView = itemView.findViewById(R.id.image_avatar)
        val checkSelected: CheckBox = itemView.findViewById(R.id.check_selected)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.textCaption.text = item.caption
        holder.textMessage.text = item.message
        holder.textTime.text = item.timer
        holder.imageAvatar.setImageResource(item.imageThumb)
        holder.checkSelected.isChecked = item.selected

        holder.checkSelected.setOnCheckedChangeListener { _, isChecked ->
            item.selected = isChecked
            val drawableResId = if (isChecked) R.drawable.star_on else R.drawable.star_off
            holder.checkSelected.setBackgroundResource(drawableResId)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

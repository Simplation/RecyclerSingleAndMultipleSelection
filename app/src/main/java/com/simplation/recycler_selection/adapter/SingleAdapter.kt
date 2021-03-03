package com.simplation.recycler_selection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simplation.recycler_selection.R


/**
 * @作者: Simplation
 * @日期: 2020/1/16
 * @描述:
 * @更新:
 */
class SingleAdapter(context: Context, private var datas: List<String>) :
    RecyclerView.Adapter<SingleAdapter.SingleViewHolder>() {

    private var selected = -1

    fun SingleAdapter(datas: List<String>) {
        this.datas = datas
    }

    var onClick: OnItemClickListener? = null

    fun setOnItemClickLitener(mOnItemClickListener: OnItemClickListener) {
        this.onClick = mOnItemClickListener
    }

    fun setSelection(position: Int) {
        selected = position
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return SingleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {
        val name = datas[position]
        holder.mTvName.text = name
        if (selected == position) {
            holder.mCheckBox.isChecked = true
            holder.itemView.isSelected = true
        } else {
            holder.mCheckBox.isChecked = false
            holder.itemView.isSelected = false
        }
        if (onClick != null) {
            holder.itemView.setOnClickListener {
                onClick!!.onItemClick(
                    holder.itemView,
                    holder.adapterPosition
                )
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }


    inner class SingleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTvName: TextView = itemView.findViewById(R.id.tv_name)
        var mCheckBox: CheckBox = itemView.findViewById(R.id.checkbox)
    }

}

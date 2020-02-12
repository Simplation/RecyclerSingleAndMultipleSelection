package com.sunnyit.recycler_single_multiple_selection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunnyit.recycler_single_multiple_selection.Bean
import com.sunnyit.recycler_single_multiple_selection.R
import java.util.*


/**
 * @作者: Simplation.WANG
 * @日期: 2020/1/16
 * @描述:
 * @更新:
 */
class MultipleAdapter(context: Context, private var datas: List<Bean>) :
    RecyclerView.Adapter<MultipleAdapter.MultipleViewHolder>() {

    var onClick: OnItemClickListener? = null

    fun setOnItemClickLitener(mOnItemClickLitener: OnItemClickListener?) {
        this.onClick = mOnItemClickLitener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MultipleViewHolder(view)
    }


    override fun getItemCount(): Int {
        return datas.size
    }


    override fun onBindViewHolder(holder: MultipleViewHolder, position: Int) {
        val viewHolder: MultipleViewHolder = holder
        val bean = datas[position]
        val name = bean.title
        viewHolder.mTvName.text = name
        viewHolder.mCheckBox.isChecked = bean.isSelect
        viewHolder.itemView.isSelected = bean.isSelect
        if (onClick != null) viewHolder.itemView.setOnClickListener {
            bean.isSelect = !bean.isSelect
            notifyDataSetChanged()
            onClick!!.onItemClick(bean)
        }
    }


    interface OnItemClickListener {
        fun onItemClick(bean: Bean)
    }


    inner class MultipleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTvName: TextView = itemView.findViewById(R.id.tv_name)
        var mCheckBox: CheckBox = itemView.findViewById(R.id.checkbox)
    }


}

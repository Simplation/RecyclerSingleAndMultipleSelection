package com.simplation.recycler_selection.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.simplation.recycler_selection.R
import com.simplation.recycler_selection.adapter.SingleAdapter
import kotlinx.android.synthetic.main.activity_single_selection.*


/**
 * @作者: Simplation
 * @日期: 2020/1/16
 * @描述: 单选
 * @更新:
 */
class SingleSelectionActivity : AppCompatActivity() {

    private val datas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_selection)

        title = intent.getStringExtra("title")

        // 创建模拟数据
        createData()

        single_recyclerview.layoutManager = LinearLayoutManager(this)
        val singleAdapter = SingleAdapter(this, datas)
        single_recyclerview.adapter = singleAdapter

        singleAdapter.setOnItemClickLitener(object : SingleAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                singleAdapter.setSelection(position)
            }

        })
    }

    private fun createData() {
        for (i in 0..19) {
            datas.add("测试单选数据$i")
        }
    }

}

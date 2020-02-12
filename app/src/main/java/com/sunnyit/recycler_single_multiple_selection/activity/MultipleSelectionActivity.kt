package com.sunnyit.recycler_single_multiple_selection.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunnyit.recycler_single_multiple_selection.Bean
import com.sunnyit.recycler_single_multiple_selection.R
import com.sunnyit.recycler_single_multiple_selection.adapter.MultipleAdapter
import kotlinx.android.synthetic.main.activity_multiple_selection.*


/**
 * @作者: Simplation.WANG
 * @日期: 2020/1/16
 * @描述: 多选
 * @更新:
 */
class MultipleSelectionActivity : AppCompatActivity() {

    var datas = mutableListOf<Bean>()
    val selectDatas = mutableListOf<Bean>()
    private var multipleAdapter: MultipleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_selection)

        title = intent.getStringExtra("title")

        initData()

        multiple_recycler.setHasFixedSize(true)
        multiple_recycler.layoutManager = LinearLayoutManager(this)
        multipleAdapter = MultipleAdapter(this, datas)
        multiple_recycler.adapter = multipleAdapter


        multipleAdapter!!.setOnItemClickLitener(object : MultipleAdapter.OnItemClickListener {
            override fun onItemClick(bean: Bean) {
                if (bean.isSelect) {
                    selectDatas.add(bean)
                } else {
                    selectDatas.remove(bean)
                }
                tv_count.text = String.format("已选中 %s 项", selectDatas.size)
            }

        })
    }

    /**
     * 全选
     * @param view
     */
    /*fun all(view: View?) {
        selectDatas.clear()
        for (i in datas.indices) {
            selectDatas.add(datas[i])
        }
        multipleAdapter!!.notifyDataSetChanged()
        tv_count.text = String.format("已选中 %s 项", selectDatas.size)
    }*/


    /**
     * 反选
     * @param view
     */
    /*fun inverse(view: View?) {
        for (i in datas.indices) {
            if (multipleAdapter!!.isSelected[i]!!) {
                multipleAdapter!!.isSelected[i] = false
                selectDatas.remove(datas[i])
            } else {
                multipleAdapter!!.isSelected[i] = true
                selectDatas.add(datas[i])
            }
        }
        multipleAdapter!!.notifyDataSetChanged()
        tv_count.text = String.format("已选中 %s 项", selectDatas.size)
    }*/

    /**
     * 取消已选
     * @param view
     */
    /*fun cancel(view: View?) {
        for (i in datas.indices) {
            if (multipleAdapter!!.isSelected[i]!!) {
                multipleAdapter!!.isSelected[i] = false
                selectDatas.remove(datas[i])
            }
        }
        multipleAdapter!!.notifyDataSetChanged()
        tv_count.text = String.format("已选中 %s 项", selectDatas.size)
    }*/

    private fun initData() {
        datas = ArrayList()

        for (i in 0..19) {
            datas.add(Bean("测试$i"))
        }
    }
}

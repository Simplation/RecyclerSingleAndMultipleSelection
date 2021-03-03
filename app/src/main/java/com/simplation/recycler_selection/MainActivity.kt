package com.simplation.recycler_selection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.simplation.recycler_selection.activity.MultipleSelectionActivity
import com.simplation.recycler_selection.activity.SingleSelectionActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author: Simplation
 * Date: 2021/03/03 09:48
 * Description:
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        single_selection.setOnClickListener(onClickListener)
        multiple_selection.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            // 单选
            R.id.single_selection -> {
                Intent(this, SingleSelectionActivity::class.java).run {
                    putExtra("title", "Single Selection")
                    startActivity(this)
                }
            }

            // 多选
            R.id.multiple_selection -> {
                Intent(this, MultipleSelectionActivity::class.java).run {
                    putExtra("title", "Multiple Selection")
                    startActivity(this)
                }
            }

        }

    }
}

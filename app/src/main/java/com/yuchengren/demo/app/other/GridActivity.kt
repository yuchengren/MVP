package com.yuchengren.demo.app.other

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.ycr.lib.ui.view.gridimage.BaseRecyclerAdapter
import com.ycr.lib.ui.view.gridimage.GridImageCheckRecyclerAdapter
import com.ycr.lib.ui.view.gridimage.ImageCheckEntity
import com.ycr.lib.ui.view.gridimage.OnItemLoadImageListener
import com.yuchengren.demo.R
import com.yuchengren.demo.base.BaseActivity
import com.yuchengren.demo.util.ToastHelper
import kotlinx.android.synthetic.main.activity_grid.*

/**
 * Created by yuchengren on 2018/12/27.
 */
class GridActivity : BaseActivity() {


    override fun getRootLayoutResId(): Int {
        return R.layout.activity_grid
    }

    override fun afterBindView(rootView: View?, savedInstanceState: Bundle?) {
        super.afterBindView(rootView, savedInstanceState)
        val  url = "file://${Environment.getExternalStorageDirectory().absolutePath + "/test.png"}"
        val item1 = ImageCheckEntity(url, false)
        val item2 = ImageCheckEntity(url, false)
        val item3 = ImageCheckEntity(url, false)
        val item4 = ImageCheckEntity(url, false)
        val mutableList = mutableListOf(item1, item2, item3, item4)

        gridRecyclerView.adapter = GridImageCheckRecyclerAdapter(mutableList,R.layout.item_grid_check).apply {
            setOnItemLoadImageListener { item, view, position ->
                Glide.with(this@GridActivity).load(item.url).into(view)
            }

            setOnItemCheckChangeListener { item, position, checked ->
                ToastHelper.show("点击checkbox,position = $position,checked = $checked")
            }

            onItemChildClickListener = object : BaseRecyclerAdapter.OnItemChildClickListener{
                override fun onItemChildClick(adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int) {
                    ToastHelper.show("点击图片")
                }

            }
        }

        rootView?.postDelayed({
            //            Glide.with(this).load("file://${Environment.getExternalStorageDirectory().absolutePath + "/test.png"}").into(gridImageView)
//            gridImageView.setImageResource(R.drawable.test)
        }, 100)
    }

}
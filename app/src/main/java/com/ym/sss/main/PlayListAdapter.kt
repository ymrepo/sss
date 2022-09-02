package com.ym.sss.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ym.sss.base.bean.FeedBean
import com.ym.sss.databinding.ItemPlayListBinding

class PlayListAdapter : BaseQuickAdapter<FeedBean, PlayListAdapter.PlayListHolder>() {

    inner class PlayListHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: PlayListHolder, position: Int, item: FeedBean) {
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): PlayListHolder {
        val view = ItemPlayListBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return PlayListHolder(view.root)
    }
}
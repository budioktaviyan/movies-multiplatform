package id.kotlin.multiplatform.home

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.multiplatform.R
import id.kotlin.multiplatform.data.Result
import id.kotlin.multiplatform.home.HomeAdapter.HomeHolder
import id.kotlin.multiplatform.inflate
import id.kotlin.multiplatform.load
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val results: List<Result>) : Adapter<HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder =
            HomeHolder(parent.inflate(parent.context, R.layout.item_home, false))

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bindView(results[holder.adapterPosition])
    }

    override fun getItemCount(): Int = results.size

    inner class HomeHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(result: Result) {
            itemView.iv_home.load(result.posterPath)
            itemView.tv_home.text = result.title
        }
    }
}
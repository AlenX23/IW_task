package com.example.iw_task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iw_task.Model.ProductModelClass
import kotlinx.android.synthetic.main.recycle_item.view.*

class ProductAdapter(
    private val context: Context,
    private val items: ArrayList<ProductModelClass>,
    private val supportFragmentManager: FragmentManager
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycle_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val product = ProductInfoFragment()

        holder.productId.text = item.id.toString()
        holder.productName.text = item.name

        product.arguments?.putString("image", item.image)
        product.arguments?.putString("name", item.name)
        product.arguments?.putString("des", item.description)

        holder.itemView.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.MainActivity, product)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productId = view.product_id!!
        val productName = view.product_name!!
    }
}
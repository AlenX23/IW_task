package com.example.iw_task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_company.back_main
import kotlinx.android.synthetic.main.fragment_product_info.*

class ProductInfoFragment : Fragment(R.layout.fragment_product_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val i = arguments?.getString("image")
        Picasso.with(context).load(i).fit().into(product_image)
        product_name.text = arguments?.get("name").toString()
        product_des.text = arguments?.get("des").toString()

        back_main.setOnClickListener {
            /*val action = ProductInfoFragmentDirections.actionProductInfoToMainFragment()
            findNavController().navigate(action)*/
            Toast.makeText(context, "NO WORKING. PRESS BACK BUTTON", Toast.LENGTH_SHORT).show()
        }
    }
}
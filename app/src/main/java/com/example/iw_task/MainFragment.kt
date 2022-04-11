package com.example.iw_task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iw_task.Model.ProductModelClass
import kotlinx.android.synthetic.main.fragment_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        about_company.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCompanyFragment()
            findNavController().navigate(action)
        }

        val productsList: ArrayList<ProductModelClass> = ArrayList()
        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val productsArray = obj.getJSONArray("products")

            for (i in 0 until productsArray.length()) {
                val product = productsArray.getJSONObject(i)
                val id = product.getInt("id")
                val name = product.getString("name")
                val image = product.getString("image")
                val description = product.getString("description")
                val productDetails = ProductModelClass(id, name, image, description)

                productsList.add(productDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Product_View.layoutManager = LinearLayoutManager(context)
        Product_View.adapter = ProductAdapter(requireContext(), productsList, parentFragmentManager)


    }

    private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = requireContext().assets.open("products.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
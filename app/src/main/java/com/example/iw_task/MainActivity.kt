package com.example.iw_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iw_task.Model.ProductModelClass
import kotlinx.android.synthetic.main.fragment_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val productsList: ArrayList<ProductModelClass> = ArrayList()
        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val productsArray = obj.getJSONArray("products")

            for (i in 0 until productsArray.length()) {
                val product = productsArray.getJSONObject(i)
                val id = product.getInt("id")
                val name = product.getString("name")
                val productDetails = ProductModelClass(id, name)

                productsList.add(productDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Product_View.layoutManager = LinearLayoutManager(this)
        Product_View.adapter = ProductAdapter(this, productsList)*/
    }

    /*private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("products.json")
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
    }*/
}
package com.example.iw_task

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_company.*

class CompanyFragment : Fragment(R.layout.fragment_company) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_main.setOnClickListener {
            val action = CompanyFragmentDirections.actionCompanyFragmentToMainFragment()
            findNavController().navigate(action)
        }

        link.setOnClickListener {
            AlertDialog.Builder(this.requireContext())
                .setTitle("Открыть сайт в браузере?")
                .setNegativeButton("Отмена") { _, _ -> }
                .setPositiveButton("ОК") { _, _ ->
                    val browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.ironwaterstudio.com/ru")
                    )
                    startActivity(browserIntent)
                }.show()
        }

    }

}
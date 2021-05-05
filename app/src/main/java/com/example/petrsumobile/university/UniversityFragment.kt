package com.example.petrsumobile.university

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.petrsumobile.R
import ovh.plrapps.mapview.MapView

/**
 * A simple [Fragment] subclass.
 */
class UniversityFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_university, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        setupWithNavController(toolbar, findNavController())
        

        return view
    }
}
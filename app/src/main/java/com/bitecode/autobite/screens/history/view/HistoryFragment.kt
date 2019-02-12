package com.bitecode.autobite.screens.history.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitecode.autobite.R

class HistoryFragment : Fragment() {

    private lateinit var rootPOV: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootPOV = inflater.inflate(R.layout.fra_history, container, false)
        return rootPOV
    }
}
package com.ricaurte.bookproject.ui.delete

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bookproject.R
import com.ricaurte.bookproject.databinding.FragmentDeleteBinding

class DeleteFragment : Fragment() {

    private lateinit var deleteBinding: FragmentDeleteBinding
    private lateinit var deleteViewModel: DeleteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        deleteBinding = FragmentDeleteBinding.inflate(inflater, container, false)
        deleteViewModel = ViewModelProvider(this)[DeleteViewModel::class.java]
        return deleteBinding.root
    }

}
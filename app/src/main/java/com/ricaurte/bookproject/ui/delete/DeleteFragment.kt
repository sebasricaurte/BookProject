package com.ricaurte.bookproject.ui.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ricaurte.bookproject.R
import com.ricaurte.bookproject.databinding.FragmentDeleteBinding
import com.ricaurte.bookproject.local.Book

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deleteViewModel.findBookDone.observe(viewLifecycleOwner) { result ->
            onFindBookDoneSubscribe(result)
        }

        with(deleteBinding) {
            searchButton.setOnClickListener {
                deleteViewModel.searchBook(nameEditText.text.toString())
            }
        }
    }

    private fun onFindBookDoneSubscribe(book: Book) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.warning_title))
            .setMessage(resources.getString(R.string.delete_book_msg, book.name, book.author))
            .setNegativeButton(resources.getString(R.string.cancel)){ dialog, which ->
            }
            .setPositiveButton(resources.getString(R.string.accept)){dialog, which ->
                deleteViewModel.deleteBook(book)
                deleteBinding.nameEditText.text?.clear()
            }
            .show()
    }
}


package com.ricaurte.bookproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ricaurte.bookproject.databinding.FragmentListBinding
import com.ricaurte.bookproject.model.Book

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var booksAdapter: BooksAdapter
    private var booksList: ArrayList<Book> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        booksList.add(
            Book(
                "EL sicoanalista",
                "John KAtzenbach",
                280,
                "hola Doctor",
                "Suspenso",
                5,
                "10-ene-2000"
            )
        )

        booksList.add(
            Book(
                "La chica del tren",
                "Paula Hawkins",
                280,
                "Una chica en el tren",
                "Suspenso",
                4,
                "01-feb-2018"
            )
        )

        booksList.add(
            Book(
                "el principito",
                "Antoine Exupery",
                150,
                "Erase una vez un principito",
                "Fantasia",
                3,
                "01-feb-1980"
            )
        )

        booksAdapter = BooksAdapter(booksList)

        listBinding.booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = booksAdapter
            setHasFixedSize(false)
        }

        listBinding.newButton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToNewBookFragment())
        }
    }

}
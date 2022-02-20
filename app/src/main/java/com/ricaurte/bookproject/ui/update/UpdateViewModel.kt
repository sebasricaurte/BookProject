package com.ricaurte.bookproject.ui.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ricaurte.bookproject.local.Book
import com.ricaurte.bookproject.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateViewModel : ViewModel() {

    val bookRepository = BookRepository()

    private val findBook: MutableLiveData<Book> = MutableLiveData()
    val findBookDone: LiveData<Book> = findBook

    fun searchBook(nameBook: String) {
        GlobalScope.launch(Dispatchers.IO) {
            findBook.postValue(bookRepository.searchBook(nameBook))
        }

    }

    fun updatebook(book: Book) {
        GlobalScope.launch(Dispatchers.IO) {
            bookRepository.updateBook(book)
        }
    }
    // TODO: Implement the ViewModel
}
package com.ricaurte.bookproject.ui.tabs.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ricaurte.bookproject.R
import com.ricaurte.bookproject.ui.delete.DeleteFragment
import com.ricaurte.bookproject.ui.list.ListFragment
import com.ricaurte.bookproject.ui.newbook.NewBookFragment
import com.ricaurte.bookproject.ui.update.UpdateFragment

private val TAB_TITLES = arrayOf(
    R.string.title_list,
    R.string.title_new,
    R.string.title_update,
    R.string.title_delete,
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return ListFragment()
            1 -> return NewBookFragment()
            2 -> return UpdateFragment()
            else -> return DeleteFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}
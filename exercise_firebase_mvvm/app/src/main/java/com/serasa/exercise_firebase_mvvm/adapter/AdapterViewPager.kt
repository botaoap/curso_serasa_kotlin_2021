package com.serasa.exercise_firebase_mvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.serasa.exercise_firebase_mvvm.view.DetailListFragment

class AdapterViewPager(
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    private val lisfOfFrags = listOf<Fragment>(
        DetailListFragment.newInstance(),
        DetailListFragment.newInstance()
    )

    override fun getItem(position: Int): Fragment {
        return lisfOfFrags[position]
    }

    override fun getCount(): Int {
        return lisfOfFrags.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab $position"
    }
}
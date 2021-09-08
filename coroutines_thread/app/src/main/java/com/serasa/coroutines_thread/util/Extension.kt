package com.serasa.coroutines_thread.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.serasa.coroutines_thread.R

fun FragmentActivity.replaceView(fragment: Fragment, @IdRes idContainer: Int = R.id.container) {
    supportFragmentManager.beginTransaction()
        .replace(idContainer, fragment)
        .commitNow()
}
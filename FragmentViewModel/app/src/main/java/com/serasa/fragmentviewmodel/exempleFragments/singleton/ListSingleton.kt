package com.serasa.fragmentviewmodel.exempleFragments.singleton

import com.serasa.fragmentviewmodel.exempleFragments.model.ListWhatEver

object ListSingleton {

    val listOfWhatEver = mutableListOf<ListWhatEver>(
        ListWhatEver("aaa"),
        ListWhatEver("bbb"),
        ListWhatEver("ccc"),
        ListWhatEver("ddd")
    )


}
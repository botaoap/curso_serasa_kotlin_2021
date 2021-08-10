package com.serasa.fragmentviewmodel.singleton

import com.serasa.fragmentviewmodel.model.ListWhatEver

object ListSingleton {

    val listOfWhatEver = mutableListOf<ListWhatEver>(
        ListWhatEver("aaa"),
        ListWhatEver("bbb"),
        ListWhatEver("ccc"),
        ListWhatEver("ddd")
    )


}
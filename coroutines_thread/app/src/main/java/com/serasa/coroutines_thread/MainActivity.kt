package com.serasa.coroutines_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.coroutines_thread.databinding.MainActivityBinding
import com.serasa.coroutines_thread.util.replaceView
import com.serasa.coroutines_thread.view.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: MainActivityBinding
    private var listOfName = mutableListOf<String>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        loadList()
//        executeCoroutines()
        callFragment()
    }

    fun callFragment() {
        replaceView(MainFragment.newInstance())
    }

//    fun executeCoroutines() {
//        val returnAsyn = CoroutineScope(Dispatchers.Main).async {
//            delayToChangeName()
//        }
//
//        CoroutineScope(Dispatchers.Main).launch {
//            val result = returnAsyn.await()
//            while(true) {
//                listOfName.forEachIndexed { index, string ->
//                    if (result) {
//                        binding.texteViewChangeName.text = string
//                        binding.texteViewCountNumbers.text = "Position: ${(index+1)}"
//                        delayToChangeName()
//                    }
//                }
//                listOfName.reversed().forEachIndexed { index, string ->
//                    val count = listOfName.size
//                    if (result) {
//                        binding.texteViewChangeName.text = string
//                        binding.texteViewCountNumbers.text = "Position: ${(count-(index))}"
//                        delayToChangeName()
//                    }
//                }
//                continue
//            }
//        }
//    }
//
//    private suspend fun delayToChangeName(): Boolean {
//        delay(1000)
//        return true
//    }
//
//
//    fun loadList() {
//        listOfName = mutableListOf(
//            "Arthur","Bia","Carlos","Daniel","Gabriel","Heloise")
//    }
}
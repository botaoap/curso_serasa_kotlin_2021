package com.serasa.coroutines_thread.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.serasa.coroutines_thread.R
import com.serasa.coroutines_thread.databinding.MainFragmentBinding
import com.serasa.coroutines_thread.model.User
import com.serasa.coroutines_thread.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private var listOfName = mutableListOf<String>()

    private val observerUser =  Observer<List<User>> {
        println(it)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadList()
        loadComponents(view)
        executeComponents()
        executeCoroutines()
    }

    fun loadComponents(view: View) {
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    fun executeComponents() {
        viewModel.user.observe(viewLifecycleOwner, observerUser)
    }

    fun executeCoroutines() {
        val returnAsyn = CoroutineScope(Dispatchers.Main).async {
            delayToChangeName()
        }

        CoroutineScope(Dispatchers.Main).launch {
            val result = returnAsyn.await()
            while(true) {
                listOfName.forEachIndexed { index, string ->
                    if (result) {
                        binding.texteViewChangeName.text = string
                        binding.texteViewCountNumbers.text = "Position: ${(index+1)}"
                        delayToChangeName()
                    }
                }
                listOfName.reversed().forEachIndexed { index, string ->
                    val count = listOfName.size
                    if (result) {
                        binding.texteViewChangeName.text = string
                        binding.texteViewCountNumbers.text = "Position: ${(count-(index))}"
                        delayToChangeName()
                    }
                }
                continue
            }
        }
    }

    private suspend fun delayToChangeName(): Boolean {
        delay(1000)
        return true
    }


    fun loadList() {
        listOfName = mutableListOf(
            "Arthur","Bia","Carlos","Daniel","Gabriel","Heloise")
    }


}
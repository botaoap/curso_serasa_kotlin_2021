package com.serasa.coroutines_thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.coroutines_thread.databinding.ActivitySplashBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivitySplashBinding

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val returnAsync = CoroutineScope(Dispatchers.Main).async {
            waitSplashScreen()
        }

        CoroutineScope(Dispatchers.Main).launch {
            val result = returnAsync.await()

            if (result) {
                callNewActivity()
            }
        }

    }

    private suspend fun waitSplashScreen(): Boolean {
        delay(2000)
        return true
    }

    private suspend fun callNewActivity() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    private suspend fun toNextActivity() {
        Intent(this, MainActivity::class.java).let {
            delay(2000)
            withContext(Dispatchers.Main) {
                startActivity(it)
            }
            withContext(Dispatchers.IO) {
                startActivity(it)
            }
        }
    }

}
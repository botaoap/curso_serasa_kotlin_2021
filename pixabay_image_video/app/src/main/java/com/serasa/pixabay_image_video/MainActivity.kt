package com.serasa.pixabay_image_video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.pixabay_image_video.databinding.MainActivityBinding
import com.serasa.pixabay_image_video.view.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButtonGroup.check(R.id.buttonImage)
        binding.toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            when(checkedId) {
                R.id.buttonImage -> replaceFrag(MainFragment.FeedType.IMAGE)
                R.id.buttonVideo -> replaceFrag(MainFragment.FeedType.VIDEO)
            }
        }

        replaceFrag(MainFragment.FeedType.IMAGE)

    }

    fun replaceFrag(feedType: MainFragment.FeedType) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment(feedType))
            .commitNow()
    }


}
package com.serasa.final_resume.view

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.serasa.final_resume.MainActivity
import com.serasa.final_resume.R
import com.serasa.final_resume.adapter.ImageAdapter
import com.serasa.final_resume.adapter.SearchAdapter
import com.serasa.final_resume.databinding.FeedFragmentBinding
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.servie.AppJobService
import com.serasa.final_resume.servie.NotificationHandler
import com.serasa.final_resume.util.hideKeyboard
import com.serasa.final_resume.view_model.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.feed_fragment) {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    lateinit var notificationHandler: NotificationHandler

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding: FeedFragmentBinding
    private var page: Int = 1
    private var search: String = ""
    lateinit var adapters: ConcatAdapter
    private var adapterImage = ImageAdapter()
    private var adaptersearch = SearchAdapter {
        search = it
        page = 1
        adapterImage.refresh(listOf(),true)
        viewModel.fetchImage(search, page)
    }

    private var observerImage = Observer<List<Image>> {
        binding.progressBar.visibility = INVISIBLE
        adapterImage.refresh(it)
    }

    private var observerImagefromDb = Observer<List<Image>> {
        binding.progressBar.visibility = INVISIBLE
        adapterImage.refresh(it)
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchImageFromDb()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        setupRecyclerView()
        loadObserver()
        executeComponents()
        (requireActivity() as? MainActivity)?.supportActionBar?.show()
        startJob()

    }

    private fun loadObserver() {
        viewModel.image.observe(viewLifecycleOwner, observerImage)
        viewModel.imageDb.observe(viewLifecycleOwner, observerImagefromDb)
    }

    private fun loadComponents(view: View) {
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

    }

    private fun setupRecyclerView() = with(binding.recyclerViewImage) {
//        adapter = adapterImage
        adapters = ConcatAdapter(adaptersearch, adapterImage)
        adapter = adapters
        layoutManager = GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == 0) 2 else 1
                }

            }
        }
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    binding.progressBar.visibility = VISIBLE
//                    if (feedType == FeedType.VIDEO) {
//                        viewModel.fetchVideo(q = search, page = page++)
//                    }
//                    else
//                    viewModel.fetchImageFromDb()
                    viewModel.fetchImage(q = search, page = page++)
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                requireActivity().hideKeyboard()
            }
        })
    }

    private fun executeComponents() {

        binding.buttonGoToDetail.setOnClickListener {
            findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToDetailFragment())
        }

        binding.buttonShowNotification.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        notificationHandler.createNotification("Notificacao", "Mostre as suas fotos").run {
            val notificationManager = NotificationManagerCompat.from(requireContext())
            notificationManager.notify(1, this)
        }
    }

    fun startJob() {
        val component = ComponentName(requireContext(), AppJobService::class.java)
        val jobInfo = JobInfo.Builder(1, component)
            .setPeriodic(5000)
            .build()
        val jobScheduler =
            requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(jobInfo)
    }

}
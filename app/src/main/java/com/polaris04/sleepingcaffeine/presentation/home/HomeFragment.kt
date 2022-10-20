package com.polaris04.sleepingcaffeine.presentation.home

import android.content.Intent
import com.polaris04.sleepingcaffeine.databinding.FragmentHomeBinding
import com.polaris04.sleepingcaffeine.extensions.loadCenterCrop
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.DrinkListActivity
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter
import org.koin.android.ext.android.inject


internal class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    companion object {
        const val TAG = "HomeFragment"
    }

    override val viewModel by inject<HomeViewModel>()

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)


    override fun observeData() = viewModel.homeState.observe(this) {
        when (it) {
            is HomeState.UnInitialized -> {
                initView()
            }
            is HomeState.Loading -> {
                handleLoading()
            }
            is HomeState.Success -> {
                handleItemSuccessState(it)
            }
            is HomeState.Error -> {
                handleError()
            }
        }
    }

    private fun initView() = with(binding){
        initCircleFlowingView()
        loadImage()

        binding.addCaffeineButton.setOnClickListener {
            startActivity(Intent(binding.root.context, DrinkListActivity::class.java))
        }




    }

    private fun loadImage() =with(binding){
        profileImageView.loadCenterCrop(viewModel.preferenceManager.getString("profileImage").toString(),20f)
    }

    private fun handleItemSuccessState(state: HomeState.Success)= with(binding){
        var adapter= DrinkAdapter()
        userCaffeineRecyclerView.adapter=adapter
        adapter.setDrinkList(state.drinkList!!.drinkEntities)


    }

    private fun handleLoading(){

    }
    private fun handleError(){

    }

    private fun initCircleFlowingView()= with(binding){
        circleFlowingView.setLineColor("#000000")
        circleFlowingView.setSpeed(2)
        circleFlowingView.setProgress(50f)
    }
}
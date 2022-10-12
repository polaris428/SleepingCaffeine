package com.polaris04.sleepingcaffeine.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.FragmentHomeBinding
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.DrinkListActivity
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter
import com.polaris04.sleepingcaffeine.presentation.home.adpter.UserCaffeineAdapter
import com.polaris04.sleepingcaffeine.presentation.main.MainState
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

    private fun initView() {
        binding.addCaffeineButton.setOnClickListener {
            startActivity(Intent(binding.root.context, DrinkListActivity::class.java))
        }
    }

    private fun handleItemSuccessState(state: HomeState.Success)= with(binding){
        var adapter= DrinkAdapter()
        userCaffeineRecyclerView.adapter=adapter
        adapter.setDrinkList(state.drinkList!!.drinks)


    }

    private fun handleLoading(){

    }
    private fun handleError(){

    }
}
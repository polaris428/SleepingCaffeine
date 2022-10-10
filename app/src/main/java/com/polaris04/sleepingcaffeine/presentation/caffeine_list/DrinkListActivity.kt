package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import android.app.Activity
import android.content.ClipData.newIntent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.net.toUri
import androidx.core.view.isVisible
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ActivityDrinkListBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter
import com.polaris04.sleepingcaffeine.presentation.drink_detail.DrinkDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class DrinkListActivity : BaseActivity<DrinkListViewModel, ActivityDrinkListBinding>() {
    override val viewModel by viewModel<DrinkListViewModel>()
    var adapter = DrinkAdapter()
    override fun getViewBinding() = ActivityDrinkListBinding.inflate(layoutInflater)


    override fun observeData() = viewModel.drinkListState.observe(this) {
        when (it) {
            is DrinkListState.UnInitialized -> {
                initView()
            }
            is DrinkListState.Loading -> {
                handleLoading()
            }
            is DrinkListState.Success -> {
                handleSuccessState(it)
            }

        }
    }
    private fun initView()= with(binding){
        caffeineDrinkRecyclerView.adapter = adapter
    }
    private fun handleLoading()= with(binding){
        caffeineDrinkProgressBar.isVisible=true
    }
    private fun handleSuccessState(state: DrinkListState.Success) = with(binding) {
        caffeineDrinkProgressBar.isVisible=false
        adapter.setDrinkList(drinkList = state.drinkList.data){
            Log.d("asfdf","adsfsa")
            startActivity(
                DrinkDetailActivity.newIntent(this@DrinkListActivity , it._id)
            )
        }

    }

}



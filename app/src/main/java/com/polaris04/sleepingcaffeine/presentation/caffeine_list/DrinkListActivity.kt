package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import android.util.Log
import androidx.core.view.isVisible
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
                Log.d("오오옹","오옹")
                handleSuccessState(it)

            }
            is DrinkListState.Error->{

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
        adapter.setDrinkList(drinkEntityList = state.drinkList!!.data){
            startActivity(
                DrinkDetailActivity.newIntent(this@DrinkListActivity , it._id)
            )
        }

    }

}



package com.polaris04.sleepingcaffeine.presentation.caffeine_list

import android.app.Activity
import android.os.Bundle
import androidx.core.net.toUri
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ActivityDrinkListBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class DrinkListActivity : BaseActivity<DrinkListViewModel, ActivityDrinkListBinding>() {
    override val viewModel by viewModel<DrinkListViewModel>()
    var adapter = DrinkAdapter()
    override fun getViewBinding() = ActivityDrinkListBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    private fun initView() {
        with(binding) {
            caffeineDrinkRecyclerView.adapter = adapter
            adapter.setDrinkList(
                drinkList = listOf<Drink>(
                    Drink(
                        "1",
                        "adsf",
                        "asdf".toUri(),
                        "asf",
                        100,
                        listOf()
                    ),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf()),
                    Drink("1", "adsf", "asdf".toUri(), "asf", 100, listOf())
                )
            )
        }
    }


    override fun observeData() {

    }
}
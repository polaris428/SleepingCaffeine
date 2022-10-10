package com.polaris04.sleepingcaffeine.presentation.drink_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.ActivityDrinkDetailBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

internal class DrinkDetailActivity : BaseActivity<DrinkDetailViewModel,ActivityDrinkDetailBinding>() {
    companion object {
        const val PRODUCT_ID_KEY = "PRODUCT_ID_KEY"
        fun newIntent(context: Context, drinkId:String) =

            Intent(context, DrinkDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID_KEY, drinkId)
                Log.d("아이디",drinkId)
            }

    }

    override val viewModel by inject<DrinkDetailViewModel>(){
        parametersOf(
            intent.getStringExtra(PRODUCT_ID_KEY)
        )
    }

    override fun getViewBinding()= ActivityDrinkDetailBinding.inflate(layoutInflater)

    override fun observeData()=viewModel.drinkDetailState.observe(this){

    }
}
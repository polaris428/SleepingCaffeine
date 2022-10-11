package com.polaris04.sleepingcaffeine.presentation.drink_detail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.ActivityDrinkDetailBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivityDataBinding
import com.polaris04.sleepingcaffeine.presentation.drink_detail.adapter.DrinkDetailAdapter
import com.polaris04.sleepingcaffeine.presentation.main.MainActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.net.URL
import kotlin.concurrent.thread


internal class DrinkDetailActivity :
    BaseActivityDataBinding<DrinkDetailViewModel, ActivityDrinkDetailBinding>(R.layout.activity_drink_detail) {
    companion object {
        const val PRODUCT_ID_KEY = "PRODUCT_ID_KEY"
        fun newIntent(context: Context, drinkId: String) =

            Intent(context, DrinkDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID_KEY, drinkId)
            }

    }

    var adapter = DrinkDetailAdapter()


    override val viewModel by inject<DrinkDetailViewModel>() {
        parametersOf(
            intent.getStringExtra(PRODUCT_ID_KEY)
        )
    }

    override fun getViewBinding() = ActivityDrinkDetailBinding.inflate(layoutInflater)

    override fun observeData() = viewModel.drinkDetailState.observe(this) {
        when (it) {
            is DrinkDetailState.UnInitialized -> {
                initViews()
            }
            is DrinkDetailState.ItemLoading -> {
                handleLoading()
            }
            is DrinkDetailState.ListLoading -> {

            }
            is DrinkDetailState.ItemSuccess -> {
                handleItemSuccessState(it)
            }
            is DrinkDetailState.ListSuccess -> {
                handleListSuccessState(it)
            }
            is DrinkDetailState.AddDrink -> {
                handleAddDrink()
            }
            is DrinkDetailState.Error -> {

            }

        }
    }

    private fun initViews() = with(binding) {
        alternativeCaffeineRecyclerView.layoutManager =
            LinearLayoutManager(root.context, RecyclerView.HORIZONTAL, false)
        alternativeCaffeineRecyclerView.adapter = adapter
    }

    private fun handleLoading() = with(binding) {
        progressBar.isVisible = true
    }

    private fun handleItemSuccessState(state: DrinkDetailState.ItemSuccess) = with(binding) {
        val drink = state.drink
        val url = URL(state.drink.photo)
        title = state.drink.name
        progressBar.isGone = true
        thread {
            val mIcon1 = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            createPaletteAsync(mIcon1)
        }
        drinkAddButton.setOnClickListener {
            viewModel.postCaffeine(drinkId = drink._id, caffeine = drink.caffeine)
        }

    }

    private fun handleListSuccessState(state: DrinkDetailState.ListSuccess) = with(binding) {
        adapter.setDrinkList(state.caffeineDrinkEntity.data)
        state.caffeineDrinkEntity
    }

    private fun handleAddDrink() = with(binding) {
        var intent = Intent(this@DrinkDetailActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP //액티비티 스택제거
        startActivity(intent)
    }

    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            val vibrantSwatch = palette!!.darkVibrantSwatch
            if (vibrantSwatch != null) {
                val color = vibrantSwatch.rgb
                binding.drinkImageView.setBackgroundColor(color)
            } else {
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
package com.polaris04.sleepingcaffeine.presentation.drink_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polaris04.sleepingcaffeine.R

class DrinkDetailActivity : AppCompatActivity() {
    companion object {
        const val PRODUCT_ID_KEY = "PRODUCT_ID_KEY"
        const val PRODUCT_ORDERED_RESULT_CODE = 99
        fun newIntent(context: Context, drink:String) =
            Intent(context, DrinkDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID_KEY, drink)
            }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_detail)
    }
}
package com.polaris04.sleepingcaffeine.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.ActivityMainBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {
    override val viewModel by viewModel<MainViewModel>()
    override fun getViewBinding(): ActivityMainBinding =ActivityMainBinding.inflate(layoutInflater)

    override fun observeData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }
    private fun initViews() = with(binding) {
//        bottomNavigationView.setOnItemSelectedListener(this@MainActivity)
//        showFragment(ProductListFragment(), ProductListFragment.TAG)
    }


}
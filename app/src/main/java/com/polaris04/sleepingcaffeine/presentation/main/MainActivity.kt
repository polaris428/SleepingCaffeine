package com.polaris04.sleepingcaffeine.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.ActivityMainBinding
import com.polaris04.sleepingcaffeine.presentation.BaseActivity
import com.polaris04.sleepingcaffeine.presentation.graph.GraphFragment
import com.polaris04.sleepingcaffeine.presentation.home.HomeFragment
import com.polaris04.sleepingcaffeine.presentation.user.UserFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val viewModel by viewModel<MainViewModel>()
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        observeFragmentData()
    }

    private fun initViews() = with(binding) {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    viewModel.setMainState(MainState.Home)
                    true

                }
                R.id.menu_graph->{
                    viewModel.setMainState(MainState.Graph)
                    true
                }
                R.id.menu_user->{
                    viewModel.setMainState(MainState.User)
                    true
                }

                else -> {
                    true
                }
            }
        }

    }
    override fun observeData() = viewModel.mainStateLiveData.observe(this){
        when(it){
            is MainState.Home->{
                viewModel.setFragment(HomeFragment())
                viewModel.setTag(HomeFragment.TAG)

            }
            is MainState.Graph->{
                viewModel.setFragment(GraphFragment())
                viewModel.setTag(GraphFragment.TAG)
            }
            is MainState.User->{
                viewModel.setFragment(UserFragment())
                viewModel.setTag(UserFragment.TAG)
            }
        }

    }

    private fun observeFragmentData()=viewModel.tag.observe(this){
        showFragment(viewModel.fragment.value!!,viewModel.tag.value!!)
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.fragments.forEach { fm ->
            supportFragmentManager.beginTransaction().hide(fm).commit()
        }
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commit()

        } ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragment, tag)
                .commitAllowingStateLoss()
        }
    }



}
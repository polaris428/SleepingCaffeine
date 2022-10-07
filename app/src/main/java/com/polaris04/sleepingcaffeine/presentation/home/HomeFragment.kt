package com.polaris04.sleepingcaffeine.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.FragmentHomeBinding
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import org.koin.android.ext.android.inject


internal class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {
  companion  object {
      const val TAG="HomeFragment"
    }
    override val viewModel by inject<HomeViewModel>()

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun observeData() {

    }

}
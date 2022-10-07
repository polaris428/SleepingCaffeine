package com.polaris04.sleepingcaffeine.presentation.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.FragmentUserBinding
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import org.koin.android.ext.android.inject


internal class UserFragment : BaseFragment<UserViewModel,FragmentUserBinding>() {
    companion object {
        var TAG="UserFragment"
    }
    override val viewModel by inject<UserViewModel> ()

    override fun getViewBinding()=FragmentUserBinding.inflate(layoutInflater)

    override fun observeData() {

    }

}
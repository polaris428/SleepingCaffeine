package com.polaris04.sleepingcaffeine.presentation.graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.FragmentGraphBinding
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import com.polaris04.sleepingcaffeine.presentation.BaseViewModel
import org.koin.android.ext.android.inject



internal class GraphFragment : BaseFragment<GraphViewModel,FragmentGraphBinding>() {
    companion object {
        var TAG="GraphFragment"
    }
    override val viewModel by inject<GraphViewModel>()

    override fun getViewBinding()= FragmentGraphBinding.inflate(layoutInflater)

    override fun observeData() {

    }


}
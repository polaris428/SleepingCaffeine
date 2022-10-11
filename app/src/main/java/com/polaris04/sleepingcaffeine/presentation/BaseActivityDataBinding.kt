package com.polaris04.sleepingcaffeine.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

internal abstract class BaseActivityDataBinding<VM : BaseViewModel, VB : ViewBinding> (@LayoutRes private val layoutId: Int): AppCompatActivity() {
    abstract val viewModel: VM

    protected lateinit var binding: VB


    abstract fun getViewBinding(): VB

    private lateinit var fetchJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutId)
        fetchJob = viewModel.fetchData()
        observeData()

    }

    abstract fun observeData()
    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()
    }




}

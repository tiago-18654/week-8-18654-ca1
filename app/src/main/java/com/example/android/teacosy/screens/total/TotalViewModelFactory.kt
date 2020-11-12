package com.example.android.teacosy.screens.total

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TotalViewModelFactory(private val finalScore: Float) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TotalViewModel::class.java)) {
            return TotalViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
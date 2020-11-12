package com.example.android.teacosy.screens.total

import android.util.Log
import androidx.lifecycle.ViewModel

class TotalViewModel(finalTotal: Float) : ViewModel() {
    // The final score
    var total = finalTotal
    var fee = 0;

    init {
        Log.i("TOtalViewModel", "The total is $finalTotal")
    }
}
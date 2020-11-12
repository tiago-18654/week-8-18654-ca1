/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.teacosy.screens.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.android.teacosy.R
import com.example.android.teacosy.databinding.TeaFragmentBinding

/**
 * Fragment where the game is played
 */
class ShopFragment : Fragment() {

    private lateinit var binding: TeaFragmentBinding;
    private lateinit var cartModel: ShopCartModel;


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.tea_fragment,
                container,
                false
        )

        Log.i("GameFragment", "Called ViewModelProvider.get")
        cartModel = ViewModelProvider(this).get(ShopCartModel::class.java)

        binding.correctButton.setOnClickListener { onCorrect() }

        return binding.root

    }

    private fun onCorrect() {
        onCheckboxClicked();
        Toast.makeText(activity, "Go to pay your cart", Toast.LENGTH_SHORT).show()
        val action = ShopFragmentDirections.actionGameToScore()
        action.total = cartModel.total
        //action. = cartModel.fee;
        NavHostFragment.findNavController(this).navigate(action)
    }

    fun onCheckboxClicked(){
        if (binding.checkboxDarjelling.isChecked) {
            cartModel.total = cartModel.total + 8.50f;
        }
        if (binding.checkboxAssam.isChecked) {
            cartModel.total = cartModel.total + 7.50f;
        }
        if (binding.checkboxLapsang.isChecked) {
            cartModel.total = cartModel.total + 9.50f;
        }
        if (binding.checkboxEarlGrey.isChecked) {
            cartModel.total = cartModel.total + 3.50f;
        }
        if (binding.checkboxIrishBreakfast.isChecked) {
            cartModel.total = cartModel.total + 2.50f;
        }
    }
}

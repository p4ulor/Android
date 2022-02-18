/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import java.text.NumberFormat
import java.util.*

/**
 * Activity for cupcake order flow.
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController) //configures the Up (←) button during navigation
    }
}

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {
    val quantity = MutableLiveData<Int>()
    val flavor = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val price = MutableLiveData<Double>()
    val presentablePrice: LiveData<String> = Transformations.map(price) {
        NumberFormat.getCurrencyInstance().format(it)
    }
    @RequiresApi(Build.VERSION_CODES.N) val dateOptions = getPickupOptions()

    init { resetOrder() }

    private fun resetOrder() {
        quantity.value = 0
        flavor.value = ""
        date.value = dateOptions[0]
        price.value = 0.0
    }

    fun setQuantity(numberCupcakes: Int) {
        quantity.value = numberCupcakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) { flavor.value = desiredFlavor }

    fun setDate(pickupDate: String) {
        date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavorSet() : Boolean = flavor.value.isNullOrEmpty()

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // Create a list of dates starting with the current date and the following 3 dates
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    private fun updatePrice() {
        var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        if (dateOptions[0] == date.value) calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        price.value = calculatedPrice
    }

}
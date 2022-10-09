package com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding

class DrinkAdapter : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {
    private var drinkList: List<Drink> = listOf()

    class DrinkViewHolder(val binding: ItemDrinkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(drink: Drink) {

            binding.drink = drink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount() = drinkList.size

    fun setDrinkList(drinkList: List<Drink>) {
        this.drinkList = drinkList
        notifyDataSetChanged()
    }
}
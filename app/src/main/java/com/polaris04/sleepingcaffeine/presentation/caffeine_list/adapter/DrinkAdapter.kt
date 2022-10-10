package com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding

class DrinkAdapter : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {
    private var drinkList: List<Drink> = listOf()
    private lateinit var productItemClickListener: (Drink) -> Unit

    class DrinkViewHolder(
        val binding: ItemDrinkBinding,
        val productItemClickListener: (Drink) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(drink: Drink) {

            binding.drink = drink
            binding.root.setOnClickListener {
                productItemClickListener(drink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return DrinkViewHolder(binding,productItemClickListener)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount() = drinkList.size

    fun setDrinkList(drinkList: List<Drink>, drinkItemClickListener: (Drink) -> Unit = { }) {
        this.drinkList = drinkList
        this.productItemClickListener = drinkItemClickListener
        notifyDataSetChanged()
    }
}
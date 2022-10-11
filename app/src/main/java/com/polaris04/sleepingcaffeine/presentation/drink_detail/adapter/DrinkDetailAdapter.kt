package com.polaris04.sleepingcaffeine.presentation.drink_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.CaffeineDrinkEntity
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter

class DrinkDetailAdapter : RecyclerView.Adapter<DrinkDetailAdapter.DrinkDetailViewHolder>() {
    private var drinkList:List<Drink> = listOf()
    private lateinit var productItemClickListener: (Drink) -> Unit

    class DrinkDetailViewHolder(
        val itemDrinkBinding: ItemDrinkBinding,
        val productItemClickListener: (Drink) -> Unit
    ) : RecyclerView.ViewHolder(itemDrinkBinding.root) {
            fun  bind(drink:Drink){
                itemDrinkBinding.drink = drink
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return DrinkDetailViewHolder(binding, productItemClickListener)
    }

    override fun onBindViewHolder(holder: DrinkDetailViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount() = drinkList.size

    fun setDrinkList(drinkList: List<Drink>, drinkItemClickListener: (Drink) -> Unit = { }) {
        this.drinkList = drinkList
        this.productItemClickListener = drinkItemClickListener
        notifyDataSetChanged()
    }
}
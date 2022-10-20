package com.polaris04.sleepingcaffeine.presentation.drink_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding

class DrinkDetailAdapter : RecyclerView.Adapter<DrinkDetailAdapter.DrinkDetailViewHolder>() {
    private var drinkEntityList:List<DrinkEntity> = listOf()
    private lateinit var productItemClickListener: (DrinkEntity) -> Unit

    class DrinkDetailViewHolder(
        val itemDrinkBinding: ItemDrinkBinding,
        val productItemClickListener: (DrinkEntity) -> Unit
    ) : RecyclerView.ViewHolder(itemDrinkBinding.root) {
            fun  bind(drinkEntity:DrinkEntity){
                itemDrinkBinding.drink = drinkEntity
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return DrinkDetailViewHolder(binding, productItemClickListener)
    }

    override fun onBindViewHolder(holder: DrinkDetailViewHolder, position: Int) {
        holder.bind(drinkEntityList[position])
    }

    override fun getItemCount() = drinkEntityList.size

    fun setDrinkList(drinkEntityList: List<DrinkEntity>, drinkItemClickListener: (DrinkEntity) -> Unit = { }) {
        this.drinkEntityList = drinkEntityList
        this.productItemClickListener = drinkItemClickListener
        notifyDataSetChanged()
    }
}
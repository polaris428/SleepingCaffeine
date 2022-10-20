package com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding

class DrinkAdapter : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {
    private var drinkEntityList: List<DrinkEntity> = listOf()
    private lateinit var productItemClickListener: (DrinkEntity) -> Unit

    class DrinkViewHolder(
        val binding: ItemDrinkBinding,
        val productItemClickListener: (DrinkEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(drinkEntity: DrinkEntity) {

            binding.drink = drinkEntity
            binding.root.setOnClickListener {
                productItemClickListener(drinkEntity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return DrinkViewHolder(binding,productItemClickListener)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkEntityList[position])
    }

    override fun getItemCount() = drinkEntityList.size

    fun setDrinkList(drinkEntityList: List<DrinkEntity>, drinkItemClickListener: (DrinkEntity) -> Unit = { }) {
        this.drinkEntityList = drinkEntityList
        this.productItemClickListener = drinkItemClickListener
        notifyDataSetChanged()
    }
}
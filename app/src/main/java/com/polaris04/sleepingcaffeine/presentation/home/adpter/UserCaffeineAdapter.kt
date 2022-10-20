package com.polaris04.sleepingcaffeine.presentation.home.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.DrinkEntity
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding

class UserCaffeineAdapter: RecyclerView.Adapter<UserCaffeineAdapter.UserCaffeineViewHolder>() {
    private var drinkEntityList: List<DrinkEntity> = listOf()
    private lateinit var productItemClickListener: (DrinkEntity) -> Unit

    class UserCaffeineViewHolder(
        val binding: ItemDrinkBinding,
        val productItemClickListener: (DrinkEntity) -> Unit)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(drinkEntity: DrinkEntity) {

            binding.drink = drinkEntity
            binding.root.setOnClickListener {
                productItemClickListener(drinkEntity)
            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCaffeineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return UserCaffeineAdapter.UserCaffeineViewHolder(binding, productItemClickListener)

    }

    override fun onBindViewHolder(holder: UserCaffeineViewHolder, position: Int) {
        holder.bind(drinkEntityList[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
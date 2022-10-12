package com.polaris04.sleepingcaffeine.presentation.home.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polaris04.sleepingcaffeine.data.entity.drink.Drink
import com.polaris04.sleepingcaffeine.databinding.ItemDrinkBinding
import com.polaris04.sleepingcaffeine.presentation.caffeine_list.adapter.DrinkAdapter

class UserCaffeineAdapter: RecyclerView.Adapter<UserCaffeineAdapter.UserCaffeineViewHolder>() {
    private var drinkList: List<Drink> = listOf()
    private lateinit var productItemClickListener: (Drink) -> Unit

    class UserCaffeineViewHolder(
        val binding: ItemDrinkBinding,
        val productItemClickListener: (Drink) -> Unit)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(drink: Drink) {

            binding.drink = drink
            binding.root.setOnClickListener {
                productItemClickListener(drink)
            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCaffeineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false)
        return UserCaffeineAdapter.UserCaffeineViewHolder(binding, productItemClickListener)

    }

    override fun onBindViewHolder(holder: UserCaffeineViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
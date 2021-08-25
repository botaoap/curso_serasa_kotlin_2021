package com.serasa.pokemon_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serasa.pokemon_mvvm.R
import com.serasa.pokemon_mvvm.databinding.BottomSheetFragmentBinding
import com.serasa.pokemon_mvvm.databinding.ItemPokemonListBinding
import com.serasa.pokemon_mvvm.databinding.MainFragmentBinding
import com.serasa.pokemon_mvvm.databinding.TypesIconPokemonBinding
import com.serasa.pokemon_mvvm.model.PokemonDetails
import com.serasa.pokemon_mvvm.model.relatedTypes

class AdapterTypesWeaknesses() : RecyclerView.Adapter<ItemTypesWeaknessesViewHolder>() {

    private var listOfTyperWeaknesses = mutableListOf<relatedTypes>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemTypesWeaknessesViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.types_icon_pokemon, parent, false).apply {
            return ItemTypesWeaknessesViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemTypesWeaknessesViewHolder, position: Int) {
        listOfTyperWeaknesses[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfTyperWeaknesses.size
    }

    fun refresh(newlist: List<relatedTypes>) {
        listOfTyperWeaknesses.clear()
        listOfTyperWeaknesses.addAll(newlist)
        notifyDataSetChanged()
    }
}

class ItemTypesWeaknessesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var binding: TypesIconPokemonBinding = TypesIconPokemonBinding.bind(itemView)

    fun bind(pokemonEnum: relatedTypes) {
        binding.imageViewIconTypes.apply {
            setImageResource(pokemonEnum.typeIcon)
            setColorFilter(context.getColor(pokemonEnum.bgcolor))
        }
    }
}
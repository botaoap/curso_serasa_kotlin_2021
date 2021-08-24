package com.serasa.pokemon_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.pokemon_mvvm.R
import com.serasa.pokemon_mvvm.databinding.ItemPokemonListBinding
import com.serasa.pokemon_mvvm.model.Pokemon

class AdapterPokemon(): RecyclerView.Adapter<ItemPokemonViewHolder>(){


    private val listOf = mutableListOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_list, parent, false)
        return ItemPokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemPokemonViewHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOf.size
    }

    fun refresh(newList: List<Pokemon>) {
        listOf.clear()
        listOf.addAll(newList)
        notifyDataSetChanged()
    }

}

class ItemPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding: ItemPokemonListBinding = ItemPokemonListBinding.bind(itemView)

    fun bind(pokemon : Pokemon) {
        binding.textViewIdPokemon.text = "#${pokemon.extracIfFromUrl(withPads = true)}"
        binding.textViewNamePokemon.text = pokemon.name.capitalize()
        pokemon.details?.let {
            Glide.with(itemView.context)
                .load(it.sprites.other.artWork?.image)
                .into(binding.imageViewAvatarPokemon)
        }
    }
}
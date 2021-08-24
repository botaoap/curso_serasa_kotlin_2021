package com.serasa.pokemon_mvvm.model

import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.serasa.pokemon_mvvm.R
import retrofit2.SkipCallbackExecutor

@Entity
data class PokemonDetails(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "detail_id")
    val id: Int,

    @SerializedName("sprites")
    @Embedded
    val sprites: Sprites,

    @SerializedName("types")
    val types: List<Types>
)

@Entity
data class Sprites(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sprites_id")
    val id: Int,

    @SerializedName("other")
    @Embedded
    val other: Other
)

@Entity
data class Other(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "other_id")
    val id: Int,

    @SerializedName("official-artwork")
    @Embedded
    val artWork: ArtWork?
)

@Entity
data class ArtWork(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artwork_id")
    val id: Int,

    @SerializedName("front_default")
    val image: String?
)

@Entity
data class Types(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "types_pokemon_id")
    val id: Int,

    @SerializedName("slot")
    val slot: String,

    @Embedded
    @SerializedName("type")
    val type: PokemonType
)

@Entity
data class PokemonType(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pokemon_type_name")
    val id: Int,

    @SerializedName("name")
    val typeName: String,

    @ColumnInfo(name = "pokemon_type_url")
    @SerializedName("url")
    val typeUrl: String
) {
    fun extractColor(): relatedTypes {
        return when(typeName) {
            "bug" -> relatedTypes.BUG
            "water" -> relatedTypes.WATER
            "fairy" -> relatedTypes.FAIRY
            "ghost" -> relatedTypes.GHOST
            "normal" -> relatedTypes.NORMAL
            "dark" -> relatedTypes.DARK
            "figthing" -> relatedTypes.FIGTHING
            "grass" -> relatedTypes.GRASS
            "poison" -> relatedTypes.POISON
            "dragon" -> relatedTypes.DRAGON
            "fire" -> relatedTypes.FIRE
            "ground" -> relatedTypes.GROUND
            "psychic" -> relatedTypes.PSYCHIC
            "eletric" -> relatedTypes.ELETRIC
            "flying" -> relatedTypes.FLYING
            "ice" -> relatedTypes.ICE
            "rock" -> relatedTypes.ROCK
            else -> relatedTypes.NORMAL
        }
    }
}

enum class relatedTypes(val bgcolor: Int, val typeColor: Int, val typeIcon: Int ){
    NORMAL(R.color.bg_type_normal, R.color.type_normal, R.drawable.ic_normal),
    ROCK(R.color.bg_type_rock, R.color.type_rock, R.drawable.ic_rock),
    ICE(R.color.bg_type_ice, R.color.type_ice, R.drawable.ic_ice),
    FLYING(R.color.bg_type_flying, R.color.type_flying, R.drawable.ic_flying),
    ELETRIC(R.color.bg_type_eletric, R.color.type_eletric, R.drawable.ic_electric),
    PSYCHIC(R.color.bg_type_psychic, R.color.type_psychic, R.drawable.ic_psychic),
    GROUND(R.color.bg_type_ground, R.color.type_ground, R.drawable.ic_ground),
    FIRE(R.color.bg_type_fire, R.color.type_fire, R.drawable.ic_fire),
    DRAGON(R.color.bg_type_dragon, R.color.type_dragon, R.drawable.ic_dragon),
    POISON(R.color.bg_type_poison, R.color.type_poison, R.drawable.ic_poison),
    GRASS(R.color.bg_type_grass, R.color.type_grass, R.drawable.ic_grass),
    FIGTHING(R.color.bg_type_figthing, R.color.type_fighting, R.drawable.ic_fighting),
    DARK(R.color.bg_type_dark, R.color.type_dark, R.drawable.ic_dark),
    GHOST(R.color.bg_type_ghost, R.color.type_ghost, R.drawable.ic_ghost),
    FAIRY(R.color.bg_type_fairy, R.color.type_fairy, R.drawable.ic_fairy),
    WATER(R.color.bg_type_water, R.color.type_water, R.drawable.ic_water),
    BUG(R.color.bg_type_bug, R.color.type_bug, R.drawable.ic_bug),
}


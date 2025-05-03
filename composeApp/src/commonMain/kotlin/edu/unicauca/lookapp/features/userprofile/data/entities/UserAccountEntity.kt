package edu.unicauca.lookapp.features.userprofile.data.entities

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity


data class UserAccountEntity (
    val userAccountId: Long = 0,
    var name: String,
    val email: String,
    val savedItems: List<ItemEntity>
)
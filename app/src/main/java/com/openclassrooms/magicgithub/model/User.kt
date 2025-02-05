package com.openclassrooms.magicgithub.model

data class User(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    var isActive: Boolean = true
)

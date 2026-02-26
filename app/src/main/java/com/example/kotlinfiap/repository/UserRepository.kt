package com.example.kotlinfiap.repository

import com.example.kotlinfiap.model.User

interface UserRepository {
    fun save(user: User)
    fun getUser(): User
    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean

}
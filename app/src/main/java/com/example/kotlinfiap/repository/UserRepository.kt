package com.example.kotlinfiap.repository

import com.example.kotlinfiap.model.User

interface UserRepository {
    fun saveUser(user: User)
    fun getUser(): User
    fun getUser(id: Int): User
    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean

    fun update(user: User): Int

}
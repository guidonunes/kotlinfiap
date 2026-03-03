package com.example.kotlinfiap.repository

import android.content.Context
import com.example.kotlinfiap.dao.ReviewDatabase
import com.example.kotlinfiap.model.User

class RoomUserRepository(context: Context): UserRepository {
    private val reviewDatabase = ReviewDatabase.getDatabase(context).userDao()

    override fun saveUser(user: User) {
        reviewDatabase.save(user)
    }

    override fun getUser(): User {
        TODO("Not yet implemented")
    }

    override fun getUser(id: Int): User {
        return reviewDatabase.getUserById(1)?: User()
    }

    override fun getUserByEmail(email: String): User? {
        return reviewDatabase.getUserByEmail(email)

    }

    override fun login(email: String, password: String): Boolean {
        val user = reviewDatabase.login(email, password)
        return user != null
    }

    override fun update(user: User): Int {
        return reviewDatabase.update(user)
    }
}
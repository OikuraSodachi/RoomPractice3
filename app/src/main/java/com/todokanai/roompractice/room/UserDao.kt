package com.todokanai.roompractice.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface UserDao {

    @Query("select * from room_user")
    fun getAll() : Flow<List<User>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(user : User)

    @Delete
    suspend fun delete(user : User)

    @Query("delete from room_user")
    suspend fun deleteAll()
}
package ru.s4nchez.bookstracker.data.common.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T): Single<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item: T): Completable
}
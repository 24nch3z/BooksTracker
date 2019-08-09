package ru.s4nchez.bookstracker.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

@SuppressLint("ApplySharedPref")
class SharedPrefHelper(context: Context) {

    private val sharedPref: SharedPreferences
    private val filename = "shared"

    init {
        sharedPref = context.getSharedPreferences(filename, Context.MODE_PRIVATE)
    }

    fun <T> save(key: String, value: T) {
        val editor = sharedPref.edit()
        when (value) {
            is Long -> editor.putLong(key, value)
        }
        editor.commit()
    }

    fun getLong(key: String, defaultValue: Long) = sharedPref.getLong(key, defaultValue)

    fun contains(key: String) = sharedPref.contains(key)

    fun remove(key: String) {
        val editor = sharedPref.edit()
        editor.remove(key)
        editor.commit()
    }
}
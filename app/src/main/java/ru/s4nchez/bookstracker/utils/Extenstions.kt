package ru.s4nchez.bookstracker.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import ru.s4nchez.bookstracker.MyApp

val Activity.app: MyApp
    get() = this.application as MyApp

val Fragment.app: MyApp
    get() = this.activity?.app!!
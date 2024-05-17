package eu.tutorials.mywishlistapp

import android.content.Context
import androidx.room.Room
import eu.tutorials.mywishlistapp.data.WishDatabase
import eu.tutorials.mywishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDatabase  // as same as we do in viemodel where class extend Viewmodel class and using viewmode
                                    // function we create instance of that class similarly here where Wishdata base class extend
                              // room database and using Room.databasebuilder function we create instance of database

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())  // database.wishDao return wishdao class refrence
    }                          // that is what provide by dagger hilt in newsapp

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}
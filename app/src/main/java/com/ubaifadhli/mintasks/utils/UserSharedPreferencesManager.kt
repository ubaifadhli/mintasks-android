package com.ubaifadhli.mintasks.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.ubaifadhli.mintasks.data.model.User

class UserSharedPreferencesManager (var context: Context) {

    private fun getManager () : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    private fun getEditor () : SharedPreferences.Editor {
        return getManager().edit()
    }

    fun setToken (token : String) {
        var editor = getEditor()
        editor.putString(TOKEN_SHARED_PREFERENCES_KEY, token)
        editor.commit()
    }

    fun getToken () : String? {
        var manager = getManager()
        var token = manager.getString(TOKEN_SHARED_PREFERENCES_KEY, "")

        return if (token == null) "" else token
    }

    fun setLoggedInUser (user : User) {
        var userGson = Gson().toJson(user)

        var editor = getEditor()
        editor.putString(USER_SHARED_PREFERENCES_KEY, userGson)

        editor.commit()
    }

    fun getLoggedInUser () : User {
        var manager = getManager()
        var userGson = manager.getString(USER_SHARED_PREFERENCES_KEY, "")

        var user : User

        if (userGson == null) {
            user = User()
        } else {
            user = Gson().fromJson(userGson, User::class.java)
        }

        return user
    }

    companion object {
        val SHARED_PREFERENCES_NAME = "USER_SHARED_PREFERENCES"
        val USER_SHARED_PREFERENCES_KEY = "USER_KEY"
        val TOKEN_SHARED_PREFERENCES_KEY = "TOKEN_KEY"
    }
}
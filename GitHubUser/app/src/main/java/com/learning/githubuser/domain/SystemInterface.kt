package com.learning.githubuser

import java.io.IOException
import java.net.URL

import com.learning.githubuser.domain.utils.HttpParams
import com.learning.githubuser.domain.utils.Pair
import com.learning.githubuser.domain.utils.function



interface SystemInterface {

    fun doOnBackground(background: ()->Unit)
    fun doOnForeground(foreground: ()->Unit)
    @Throws(IOException::class)
    fun httpGet(url: URL, params: HttpParams?): Pair<ByteArray, HttpParams>

    fun getSavedStringArray(title: String, def: Array<String>?): Array<String>
    fun saveStringArray(title: String, array: Array<String>)
    /**
     * public String getSavedString(String title, String def);
     * public void saveString(String title, String string);
     * public int getSavedInt(String title, int def);
     * public void saveInt(String title, int i); */
    fun removeSaved(str: String)

}

package com.mobile.impraise

import org.mockito.ArgumentCaptor
import java.io.IOException
import java.io.InputStream
import java.util.*

/**
 * Created by aftab on 2017-11-19.
 */
object Utils {

    @JvmStatic
    @Throws(IOException::class)
    private fun openFile(filename: String, classLoader: ClassLoader): InputStream = classLoader.getResourceAsStream(filename)

    @JvmStatic
    @Throws(IOException::class)
    fun convertStreamToString(filename: String, classLoader: ClassLoader): String {
        val scanner = Scanner(openFile(filename, classLoader)).useDelimiter("\\A")
        return if (scanner.hasNext()) scanner.next() else ""
    }

    /**
     * Returns ArgumentCaptor.capture() as nullable type to avoid java.lang.IllegalStateException
     * when null is returned.
     */
    @JvmStatic
    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()


    /**
     * Helper function for creating an argumentCaptor in kotlin.
     */
    @JvmStatic
    inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> =
            ArgumentCaptor.forClass(T::class.java)
}
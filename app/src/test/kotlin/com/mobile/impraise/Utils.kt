package com.mobile.impraise

import org.mockito.ArgumentCaptor
import java.io.IOException
import java.io.InputStream

/**
 * Created by aftab on 2017-11-19.
 */
object Utils {

    @JvmStatic
    @Throws(IOException::class)
    fun openFile(filename: String, classLoader: ClassLoader): InputStream = classLoader.getResourceAsStream(filename)

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
package com.mobile.impraise

import com.google.gson.Gson
import com.mobile.impraise.Utils.argumentCaptor
import com.mobile.impraise.Utils.capture
import com.mobile.impraise.Utils.convertStreamToString
import com.mobile.impraise.models.Feedback
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by aftab on 2017-11-19.
 */
class MainPresenterImplTest {

    @Mock
    private lateinit var view: MainContract.View

    private lateinit var presenter: MainPresenterImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun readData() {
        val stream = convertStreamToString("output.json", javaClass.classLoader)
        val feedback = Gson().fromJson(stream, Feedback::class.java)

        presenter = MainPresenterImpl(view, feedback)
        presenter.attach()

        val captor = argumentCaptor<Feedback>()
        verify(view, times(1)).displayData(capture(captor))

        val users = captor.value.users
        Assert.assertEquals(8, users?.size)
    }
}
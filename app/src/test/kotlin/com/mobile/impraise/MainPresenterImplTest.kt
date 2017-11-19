package com.mobile.impraise

import com.mobile.impraise.Utils.argumentCaptor
import com.mobile.impraise.Utils.capture
import com.mobile.impraise.Utils.openFile
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
        presenter = MainPresenterImpl(view, openFile("output.json", javaClass.classLoader))
    }

    @Test
    fun readData() {
        presenter.attach()

        val captor = argumentCaptor<Feedback>()
        verify(view, times(1)).displayData(capture(captor))

        val users = captor.value.users
        Assert.assertEquals(8, users.size)
    }

    @Test
    fun readEmptyData() {
        presenter = MainPresenterImpl(view, openFile("empty.json", javaClass.classLoader))
        presenter.attach()

        verify(view, times(1)).displayError()
    }
}
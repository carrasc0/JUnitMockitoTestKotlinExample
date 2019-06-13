package com.example.junittestkotlinexample

import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MockitoWhenThenExamples {

    @Mock
    var mockedList: MutableList<String> = mutableListOf()

    //Configure simple return behavior for mock
    @Test
    fun simpleReturnBehavior() {
        `when`(mockedList.add(anyString())).thenReturn(false)
        val added: Boolean = mockedList.add(anyString())
    }
}
package com.example.junittestkotlinexample

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockVerifyExamples {

    @Mock
    val mockedList: MutableList<String> = mutableListOf()

    //Verify simple invocation
    @Test
    fun simpleInvocation() {
        mockedList.size
        verify(mockedList).size
    }

    //Verify number of interactions
    @Test
    fun numberOfInteractions() {
        mockedList.size
        mockedList.size
        mockedList.add("one")
        mockedList.add("one")
        verify(mockedList, times(2)).size
        verify(mockedList, times(2)).add("one")
    }

    //Verify no interaction with the whole mock occurred
    @Test
    fun zeroInteractions() {
        verifyZeroInteractions(mockedList)
    }

    //Verify no interaction with a specific method occurred
    @Test
    fun zeroInteractionsWithMethod() {
        verify(mockedList, times(0)).size
    }

    //Verify there are no unexpected interactions – this should fail:
    @Test
    fun unexpectedInteractions() {
        mockedList.size
        //mockedList.clear()
        verify(mockedList).size
        verifyNoMoreInteractions(mockedList)
    }

    //Verify order of interactions
    @Test
    fun orderOfInteractions() {
        mockedList.size
        mockedList.add("some value")
        mockedList.clear()

        val inOrder: InOrder = inOrder(mockedList)
        inOrder.verify(mockedList).size
        inOrder.verify(mockedList).add("some value")
        inOrder.verify(mockedList).clear()
    }

    //Verify an interaction has not occurred
    @Test
    fun verifyInteractionNeverOcurred() {
        mockedList.size
        verify(mockedList, never()).clear()
    }

    //Verify an interaction has occurred at least certain number of times
    @Test
    fun interactionOccurredCertainNumbersOfTimes() {
        mockedList.size
        mockedList.size
        mockedList.size
        mockedList.size
        verify(mockedList, atLeast(3)).size
        verify(mockedList, atMost(10)).size
    }

    //Verify interaction with exact argument
    @Test
    fun interactionWithExactArgument() {
        mockedList.add("flech")
        verify(mockedList).add(ArgumentMatchers.anyString())
    }
}

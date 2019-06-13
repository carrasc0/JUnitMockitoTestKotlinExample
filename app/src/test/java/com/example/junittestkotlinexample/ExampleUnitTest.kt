package com.example.junittestkotlinexample

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    val mockList: MutableList<String> = mutableListOf()

    @Spy
    val spyList: MutableList<String> = mutableListOf()

    @Mock
    val wordMap: Map<String, String> = mapOf()

    @InjectMocks
    val myDictionary: MyDictionary = MyDictionary()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun rest_isWrong() {
        assertNotEquals(4, 3 + 2)
    }


    @Test
    fun testingList_Mock() {
        mockList.add("one")
        Mockito.verify(mockList).add("one")
        assertEquals(0, mockList.size)

        Mockito.`when`(mockList.size).thenReturn(80)
        assertEquals(80, mockList.size)
    }


    @Test
    fun testingList_Spy() {
        spyList.add("one")
        spyList.add("two")
        Mockito.verify(spyList).add("one")
        Mockito.verify(spyList).add("two")

        assertEquals(2, spyList.size)

        Mockito.doReturn(100).`when`(spyList).size
        Mockito.doReturn("three").`when`(spyList)[2]

        assertEquals(100, spyList.size)
        assertEquals("three", spyList[2])
    }

    @Test
    fun testInjectMocks_thenCorrect() {
        Mockito.`when`(wordMap["aWord"]).thenReturn("aMeaning")
        assertEquals("aMeaning", myDictionary.getMeaning("aWord"))
    }

    inner class MyDictionary {

        var wordMap: Map<String, String> = HashMap()

        fun add(word: String, meaning: String) {
            wordMap.plus(Pair(word, meaning))
        }

        fun getMeaning(word: String): String? {
            return wordMap[word]
        }

    }


}

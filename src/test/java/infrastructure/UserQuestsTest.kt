package infrastructure

import domain.Quest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserQuestsTest {

    private lateinit var userQuests: UserQuests

    @Before
    fun before(){
        userQuests = MemoryUserQuests()
    }

    @Test
    fun add(){
        val user = "fer"
        val quest = Quest("Entrenar", 20, "min", 10)

        userQuests.add(user, quest)

        userQuests.find(user)?.contains(quest)?.let { Assert.assertTrue(it) }
    }
}
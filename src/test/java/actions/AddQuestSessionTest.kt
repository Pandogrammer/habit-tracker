package actions

import domain.Quest
import domain.QuestSession
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AddQuestSessionTest {

    private lateinit var quest: Quest

    @Before
    fun before(){

    }

    @Test
    fun addQuestSession(){
        givenAQuest()

        whenAddSession()

        thenSessionIsAdded()
    }

    private fun givenAQuest() {
        val habit = "Entrenar"
        val sessions = 10
        val unit = "min"
        val amount = 20
        quest = Quest(habit, amount, unit, sessions)
    }

    private fun whenAddSession() {
        val amount = 10
        val session = QuestSession(amount)

        AddQuestSession().execute(quest, session)
    }

    private fun thenSessionIsAdded() {
        assertEquals(1, quest.sessionsDone.size)
    }
}


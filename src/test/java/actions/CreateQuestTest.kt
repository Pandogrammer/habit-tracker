package actions

import domain.Quest
import infrastructure.UserHabits
import infrastructure.UserQuests
import infrastructure.Users
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CreateQuestTest {

    private lateinit var userQuests: UserQuests
    private lateinit var users: Users
    private lateinit var userHabits: UserHabits

    private lateinit var user: String
    private lateinit var habit: String
    private lateinit var quest: Quest

    @Before
    fun before() {
        users = Mockito.mock(Users::class.java)
        userQuests = Mockito.mock(UserQuests::class.java)
        userHabits = Mockito.mock(UserHabits::class.java)
    }

    @Test
    fun questCreation() {
        givenAnExistingUser("fer")
        givenAnExistingHabit("Entrenar")
        givenAQuest()

        CreateQuest(users, userHabits, userQuests).execute(user, quest)

        Mockito.verify(users).find(user)
        Mockito.verify(userHabits).find(user)
        Mockito.verify(userQuests).add(user, quest)
    }

    private fun givenAQuest() {
        val amountPerSession = 20
        val unit = "min"
        val sessions = 10
        quest = Quest(habit, amountPerSession, unit, sessions)

    }


    private fun givenAnExistingUser(username: String) {
        user = username
        Mockito.`when`(users.find(username)).thenReturn(username)
    }

    private fun givenAnExistingHabit(habit: String) {
        this.habit = habit
        Mockito.`when`(userHabits.find(user)).thenReturn(listOf(habit))
    }
}

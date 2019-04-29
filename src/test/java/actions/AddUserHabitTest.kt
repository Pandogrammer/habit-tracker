package actions

import infrastructure.Habits
import infrastructure.UserHabits
import infrastructure.Users
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class AddUserHabitTest {

    private lateinit var users: Users
    private lateinit var habits: Habits
    private lateinit var userHabits: UserHabits

    private lateinit var user: String
    private lateinit var habit: String

    @Before
    fun setUp() {
        users = Mockito.mock(Users::class.java)
        habits = Mockito.mock(Habits::class.java)
        userHabits = Mockito.mock(UserHabits::class.java)
    }

    @Test
    fun addHabitToUser() {
        givenAExistingUser("fer")
        givenAExistingHabit("colgar")

        whenHabitIsAddedToUser()

        thenExistingUserIsChecked()
        thenExistingHabitIsChecked()
        thenHabitIsAddedToUserHabits()
    }


    private fun givenAExistingHabit(habit: String) {
        this.habit = habit
        Mockito.`when`(habits.find(this.habit)).thenReturn(this.habit)
    }

    private fun givenAExistingUser(user: String) {
        this.user = user
        Mockito.`when`(users.find(this.user)).thenReturn(this.user)
    }

    private fun whenHabitIsAddedToUser() {
        val addHabit = AddUserHabit(users, habits, userHabits)

        addHabit.execute(user, habit)
    }

    private fun thenHabitIsAddedToUserHabits() {
        Mockito.verify(userHabits).add(user, habit)
    }

    private fun thenExistingHabitIsChecked() {
        Mockito.verify(habits).find(habit)
    }

    private fun thenExistingUserIsChecked() {
        Mockito.verify(users).find(user)
    }

}


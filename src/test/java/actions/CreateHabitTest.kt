package actions

import actions.CreateHabit
import infrastructure.Habits
import infrastructure.MemoryHabits
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before


class CreateHabitTest {

    private lateinit var habits: Habits

    @Before
    fun setUp(){
        habits = MemoryHabits()
    }

    @Test
    fun habitCreation(){
        val habit = "colgar"
        val createHabit = CreateHabit(habits)

        createHabit.execute(habit)

        assertEquals(habit, habits.find(habit))
    }

}


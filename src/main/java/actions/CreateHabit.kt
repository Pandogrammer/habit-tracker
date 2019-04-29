package actions

import infrastructure.Habits

class CreateHabit(private val habits: Habits) {

    fun execute(habit: String) {
        if(habits.find(habit) == null)
            habits.add(habit)
    }
}
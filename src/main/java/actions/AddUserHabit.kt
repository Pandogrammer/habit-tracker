package actions

import infrastructure.Habits
import infrastructure.UserHabits
import infrastructure.Users

class AddUserHabit(private val users: Users,
                   private val habits: Habits,
                   private val userHabits: UserHabits) {

    fun execute(user: String, habit: String) {
        if (users.find(user) == null || habits.find(habit) == null) return

        userHabits.add(user, habit)
    }
}
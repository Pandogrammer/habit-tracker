package actions

import domain.Quest
import infrastructure.Habits
import infrastructure.UserHabits
import infrastructure.UserQuests
import infrastructure.Users

class CreateQuest(private val users: Users, private val userHabits: UserHabits, private val userQuests: UserQuests) {

    fun execute(user: String, quest: Quest) {
        if(users.find(user) == null) return
        if(userHabits.find(user)?.contains(quest.habit)!!.not()) return

        userQuests.add(user, quest)
    }

}

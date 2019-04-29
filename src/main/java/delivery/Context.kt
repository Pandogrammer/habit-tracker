package delivery

import actions.*
import infrastructure.*

class Context {

    private val users: Users
    private val friends: Friends
    private val habits: Habits
    private val userHabits: UserHabits
    private val userQuests: UserQuests

    val addFriend: AddFriend
    val addQuestSession: AddQuestSession
    val addUserHabit: AddUserHabit
    val createHabit: CreateHabit
    val createQuest: CreateQuest
    val createUser: CreateUser

    init {
        users = users()
        friends = friends()
        habits = habits()
        userHabits = userHabits()
        userQuests = userQuests()

        addFriend = AddFriend(users, friends)
        addQuestSession = AddQuestSession()
        addUserHabit = AddUserHabit(users, habits, userHabits)
        createHabit = CreateHabit(habits)
        createQuest = CreateQuest(users, userHabits, userQuests)
        createUser = CreateUser(users)
    }

    private fun users(): Users {
        return MemoryUsers()
    }

    private fun friends(): Friends {
        return MemoryFriends()
    }

    private fun habits(): Habits {
        return MemoryHabits()
    }

    private fun userHabits(): UserHabits {
        return MemoryUserHabits()
    }

    private fun userQuests(): UserQuests {
        return MemoryUserQuests()
    }
}
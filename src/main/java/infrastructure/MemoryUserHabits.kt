package infrastructure

class MemoryUserHabits: UserHabits {
    private val userHabits = mutableMapOf<String, MutableList<String>>()

    override fun find(user: String): List<String>? {
        return userHabits[user]
    }

    override fun add(user: String, habit: String) {
        if (userHabits[user] == null)
            userHabits[user] = mutableListOf()

        userHabits[user]?.add(habit)
    }

}
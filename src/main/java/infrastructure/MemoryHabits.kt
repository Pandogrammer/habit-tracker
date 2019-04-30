package infrastructure

class MemoryHabits: Habits {

    val habits = mutableListOf<String>()

    override fun find(habit: String): String? {
        if(habits.contains(habit))
            return habit

        return null
    }

    override fun add(habit: String) {
        habits.add(habit)
    }

    override fun all(): List<String> {
        return habits
    }
}
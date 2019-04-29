package infrastructure

interface UserHabits {
    fun add(user: String, habit: String)
    fun find(user: String): List<String>?
}
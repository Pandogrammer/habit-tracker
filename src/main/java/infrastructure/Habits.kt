package infrastructure

interface Habits {
    fun find(habit: String): String?
    fun add(habit: String)
    fun all(): List<String>
}
package infrastructure

interface Users {
    fun find(username: String): String?
    fun add(username: String)
    fun all(): List<String>
}
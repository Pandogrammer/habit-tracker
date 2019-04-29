package infrastructure

interface Friends {
    fun add(username: String, friend: String)
    fun find(username: String): List<String>?
}
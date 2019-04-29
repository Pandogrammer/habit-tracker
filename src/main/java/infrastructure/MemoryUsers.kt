package infrastructure

class MemoryUsers: Users {
    val users = mutableListOf<String>()

    override fun find(username: String): String? {
        if(users.contains(username))
            return username

        return null
    }

    override fun add(username: String) {
        users.add(username)
    }

    override fun all(): List<String> {
        return users
    }

}
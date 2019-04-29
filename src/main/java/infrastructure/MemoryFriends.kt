package infrastructure

class MemoryFriends: Friends {
    override fun find(username: String): List<String>? {
        return friends[username]
    }

    private val friends = mutableMapOf<String, MutableList<String>>()

    override fun add(username: String, friend: String) {
        if(friends[username] == null) friends[username] = mutableListOf()

        friends[username]?.add(friend)
    }

}
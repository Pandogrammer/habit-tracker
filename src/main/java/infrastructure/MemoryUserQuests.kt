package infrastructure

import domain.Quest

class MemoryUserQuests : UserQuests {
    private val userQuests = mutableMapOf<String, MutableList<Quest>>()

    override fun add(user: String, quest: Quest) {
        if(userQuests[user] == null) userQuests[user] = mutableListOf()

        userQuests[user]?.add(quest)
    }

    override fun find(user: String): List<Quest>? {
        return userQuests[user]
    }

}

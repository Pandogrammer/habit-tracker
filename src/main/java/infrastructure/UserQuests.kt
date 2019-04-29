package infrastructure

import domain.Quest

interface UserQuests {
    fun add(user: String, quest: Quest)
    fun find(user: String): List<Quest>?
}

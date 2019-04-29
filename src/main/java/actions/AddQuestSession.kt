package actions

import domain.Quest
import domain.QuestSession

class AddQuestSession {
    fun execute(quest: Quest, session: QuestSession){
        quest.addSession(session)
    }
}
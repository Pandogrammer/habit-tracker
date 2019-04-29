package domain

class Quest(val habit: String,
            val amountPerSession: Int,
            val unit: String,
            val sessionsToComplete: Int) {

    var sessionsDone = mutableListOf<QuestSession>()

    fun addSession(session: QuestSession) {
        sessionsDone.add(session)
    }

}

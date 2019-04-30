package delivery.resources

import actions.AddQuestSession
import actions.CreateQuest
import domain.Quest
import domain.QuestSession
import infrastructure.UserQuests
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user-quests")
class QuestsResource(private val userQuests: UserQuests,
					 private val addQuestSession: AddQuestSession,
					 private val createQuest: CreateQuest){


	@GetMapping("{user}")
	fun getUserQuests(@PathVariable user: String): List<Quest> {
		return userQuests.find(user).orEmpty()
	}

	@PostMapping("{user}")
	fun createQuest(@PathVariable user: String, @RequestBody quest: Quest){
		createQuest.execute(user, quest)
	}

}
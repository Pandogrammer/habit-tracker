package delivery

import actions.AddFriend
import actions.AddQuestSession
import actions.AddUserHabit
import actions.CreateHabit
import actions.CreateQuest
import actions.CreateUser
import infrastructure.Friends
import infrastructure.Habits
import infrastructure.UserHabits
import infrastructure.UserQuests
import infrastructure.Users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OneForAllResource(private val addFriend: AddFriend, private val addQuestSession: AddQuestSession,
						private val addUserHabit: AddUserHabit, private val createHabit: CreateHabit,
						private val createQuest: CreateQuest, private val createUser: CreateUser,
						private val users: Users, private val friends: Friends, private val habits: Habits,
						private val userHabits: UserHabits, private val userQuests: UserQuests) {

	@GetMapping
	fun getUsers(): List<String> {
		return users.all()
	}

	@PostMapping
	fun createUser(@RequestBody username: String) {
		createUser.execute(username)
	}
}

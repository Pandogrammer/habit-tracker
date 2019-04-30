package delivery.resources

import actions.AddUserHabit
import infrastructure.UserHabits
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user-habits")
class UserHabitsResource(private val addUserHabit: AddUserHabit,
						 private val userHabits: UserHabits){


	@GetMapping("{user}")
	fun getUserHabits(@PathVariable user: String): List<String> {
		return userHabits.find(user).orEmpty()
	}

	@PostMapping("{user}")
	fun addUserHabit(@PathVariable user: String, @RequestBody habit: String){
		addUserHabit.execute(user, habit)
	}
}
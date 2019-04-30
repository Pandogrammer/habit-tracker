package delivery.resources

import actions.CreateUser
import infrastructure.Users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UsersResource(private val createUser: CreateUser,
					private val users: Users) {

	@GetMapping
	fun getUsers(): List<String> {
		return users.all()
	}

	@PostMapping
	fun createUser(@RequestBody username: String) {
		createUser.execute(username)
	}
}

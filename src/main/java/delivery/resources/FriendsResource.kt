package delivery.resources

import actions.AddFriend
import infrastructure.Friends
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("friends")
class FriendsResource(private val addFriend: AddFriend,
					  private val friends: Friends) {

	@GetMapping("{user}")
	fun getFriends(@PathVariable user: String): List<String> {
		return friends.find(user).orEmpty()
	}

	@PostMapping("{user}")
	fun addFriend(@PathVariable user: String, @RequestBody friend: String){
		addFriend.execute(user, friend)
	}

}
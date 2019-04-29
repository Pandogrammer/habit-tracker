package actions

import infrastructure.Friends
import infrastructure.Users

class AddFriend(private val users: Users,
                private val friends: Friends) {

    fun execute(username: String, friend: String){
        users.find(friend)?.let {
            friends.find(username)?.contains(friend).let {
                friends.add(username, friend)
            }
        }
    }
}
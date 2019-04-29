package actions

import infrastructure.Users

class CreateUser(private val users: Users) {

    fun execute(username: String) {
        if(users.find(username) == null) {
            users.add(username)
        }
    }
}
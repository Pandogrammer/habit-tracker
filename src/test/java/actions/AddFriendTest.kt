package actions

import infrastructure.Friends
import infrastructure.Users
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class AddFriendTest {

    private lateinit var friends: Friends
    private lateinit var users: Users

    private lateinit var friend: String
    private lateinit var username: String

    @Before
    fun before(){
        friends = Mockito.mock(Friends::class.java)
        users = Mockito.mock(Users::class.java)
    }

    @Test
    fun addExistingUserAsFriend(){
        givenAUser()
        givenAnExistingUser()

        whenAddFriend(username, friend)

        thenUserIsChecked()
        thenFriendIsAdded()
    }


    private fun givenAUser() {
        username = "fer"
    }

    private fun givenAnExistingUser() {
        friend = "fercho"
        Mockito.`when`(users.find(friend)).thenReturn(friend)
    }

    private fun whenAddFriend(username: String, friend: String) {
        AddFriend(users, friends).execute(username, friend)
    }

    private fun thenUserIsChecked() {
        Mockito.verify(users).find(friend)
    }

    private fun thenFriendIsAdded() {
        Mockito.verify(friends).add(username, friend)
    }
}


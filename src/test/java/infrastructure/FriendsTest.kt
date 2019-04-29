package infrastructure

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FriendsTest {

    private lateinit var friends: Friends

    @Before
    fun before(){
        friends = MemoryFriends()
    }

    @Test
    fun add(){
        val user = "fer"
        val friend = "fercho"

        friends.add(user, friend)

        friends.find(user)?.contains(friend)?.let { assertTrue(it) }
    }

}


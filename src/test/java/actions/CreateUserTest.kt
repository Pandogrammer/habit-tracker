package actions

import actions.CreateUser
import infrastructure.MemoryUsers
import infrastructure.Users
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CreateUserTest {

    private lateinit var users: Users

    @Before
    fun setUp(){
        users = MemoryUsers()
    }

    @Test
    fun userCreation(){
        val username = "fer"
        val createUser = CreateUser(users)

        createUser.execute(username)

        assertEquals(username, users.find("fer"))
    }

}



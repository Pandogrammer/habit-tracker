package delivery

import actions.*
import infrastructure.*
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class Context {

	/*
	// Resources
	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	fun oneForAllResource(addFriend: AddFriend,
						  addQuestSession: AddQuestSession,
						  addUserHabit: AddUserHabit,
						  createHabit: CreateHabit,
						  createQuest: CreateQuest,
						  createUser: CreateUser,
						  users: Users,
						  friends: Friends,
						  habits: Habits,
						  userHabits: UserHabits,
						  userQuests: UserQuests

						  ): OneForAllResource {
		return OneForAllResource(addFriend, addQuestSession,
				addUserHabit, createHabit, createQuest, createUser,
				users, friends, habits, userHabits, userQuests)
	}
	*/

	// Actions
	@Bean
	fun addFriend(users: Users, friends: Friends): AddFriend {
		return AddFriend(users, friends)
	}

	@Bean
	fun addQuestSession(): AddQuestSession {
		return AddQuestSession()
	}

	@Bean
	fun addUserHabit(users: Users, habits: Habits, userHabits: UserHabits): AddUserHabit {
		return AddUserHabit(users, habits, userHabits)
	}

	@Bean
	fun createHabit(habits: Habits): CreateHabit {
		return CreateHabit(habits)
	}

	@Bean
	fun createQuest(users: Users, userHabits: UserHabits, userQuests: UserQuests): CreateQuest {
		return CreateQuest(users, userHabits, userQuests)
	}

	@Bean
	fun createUser(users: Users): CreateUser {
		return CreateUser(users)
	}



	// Repositories
	@Bean
	fun users(): Users {
		return MemoryUsers()
	}

	@Bean
	fun friends(): Friends {
		return MemoryFriends()
	}

	@Bean
	fun habits(): Habits {
		return MemoryHabits()
	}

	@Bean
	fun userHabits(): UserHabits {
		return MemoryUserHabits()
	}

	@Bean
	fun userQuests(): UserQuests {
		return MemoryUserQuests()
	}

}
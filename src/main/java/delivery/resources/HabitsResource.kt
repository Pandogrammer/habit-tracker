package delivery.resources

import actions.CreateHabit
import infrastructure.Habits
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("habits")
class HabitsResource(private val createHabit: CreateHabit, private val habits: Habits) {

	@GetMapping
	fun getAll(): List<String> {
		return habits.all()
	}

	@PostMapping
	fun addHabit(@RequestBody habit: String){
		habits.add(habit)
	}

}
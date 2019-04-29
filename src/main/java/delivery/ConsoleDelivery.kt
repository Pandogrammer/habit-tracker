package delivery

class ConsoleDelivery {

    val context = Context()


    fun printMenu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun test() {
        context.createUser.execute("fer")
        context.createUser.execute("lui")

        context.addFriend.execute("fer", "lui")

        context.createHabit.execute("colgar")

        context.addUserHabit.execute("fer", "colgar")

    }

}

fun main(args: Array<String>) {
    var consoleDelivery = ConsoleDelivery()

    consoleDelivery.test()
}
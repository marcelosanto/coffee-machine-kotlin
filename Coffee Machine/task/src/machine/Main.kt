package machine

fun main() {
    val coffeeMachine = mutableListOf(400, 540, 120, 9, 550)

    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readln()) {
            "buy" -> coffeeBuyCups(coffeeMachine)
            "fill" -> fillCoffeeMachine(coffeeMachine)
            "take" -> takeCoffeeMachine(coffeeMachine)
            "remaining" -> printMachineCoffee(coffeeMachine)
            "exit" -> break
        }
    }


}

fun takeCoffeeMachine(coffeeMachine: MutableList<Int>): MutableList<Int> {
    println("I gave you ${coffeeMachine[4]}")
    coffeeMachine[4] = 0
    return coffeeMachine
}

fun printMachineCoffee(coffeeMachine: MutableList<Int>) {
    println("The coffee machine has:")
    println("${coffeeMachine[0]} ml of water")
    println("${coffeeMachine[1]} ml of milk")
    println("${coffeeMachine[2]} g of coffee beans")
    println("${coffeeMachine[3]} disposable cups")
    println("$${coffeeMachine[4]} of money")
    println("")

}

private fun fillCoffeeMachine(coffeeMachine: MutableList<Int>): MutableList<Int> {
    print("Write how many ml of water do you want to add: ")
    val water = readln().toInt()

    print("Write how many ml of milk do you want to add: ")
    val milk = readln().toInt()

    print("Write how many grams of coffee beans do you want to add: ")
    val grams = readln().toInt()

    print("Write how many disposable cups of coffee do you want to add: ")
    val cups = readln().toInt()

    coffeeMachine[0] = coffeeMachine[0] + water
    coffeeMachine[1] = coffeeMachine[1] + milk
    coffeeMachine[2] = coffeeMachine[2] + grams
    coffeeMachine[3] = coffeeMachine[3] + cups

    return coffeeMachine
}

fun coffeeBuyCups(coffeeMachine: MutableList<Int>): MutableList<Int> {
    val cappuccino = mapOf("water" to 200, "milk" to 100, "gramsCoffee" to 12, "cost" to 6)
    val latte = mapOf("water" to 350, "milk" to 75, "gramsCoffee" to 20, "cost" to 7)
    val espresso = mapOf("water" to 250, "gramsCoffee" to 16, "cost" to 4)

    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")

    return when (readln()) {
        "3" -> cupsServing(coffeeMachine, cappuccino)
        "2" -> cupsServing(coffeeMachine, latte)
        "1" -> cupsServing(coffeeMachine, espresso)
        else -> coffeeMachine
    }

}

private fun cupsServing(
    coffeeMachine: MutableList<Int>,
    coffee: Map<String, Int>,
): MutableList<Int> {

    if (coffeeMachine[0] < coffee["water"]!!) {
        println("Sorry, not enough water!")
    } else if (coffee["milk"] != null && coffeeMachine[1] < coffee["milk"]!!) {
        println("Sorry, not enough milk!")
    } else if (coffeeMachine[2] < coffee["gramsCoffee"]!!) {
        println("Sorry, not enough grams coffee!")
    } else if (coffeeMachine[3] <= 0) {
        println("Sorry, not enough cups!")
    } else if (coffeeMachine[4] <= 0) {
        println("Sorry, not enough cost!")
    } else {
        coffeeMachine[0] =
            if (coffeeMachine[0] >= coffee["water"]!!) coffeeMachine[0] - coffee["water"]!! else coffeeMachine[0]

        coffeeMachine[1] =
            if (coffee["milk"] != null && coffeeMachine[1] >= coffee["milk"]!!) coffeeMachine[1] - coffee["milk"]!! else coffeeMachine[1]

        coffeeMachine[2] =
            if (coffeeMachine[2] >= coffee["gramsCoffee"]!!) coffeeMachine[2] - coffee["gramsCoffee"]!! else coffeeMachine[2]

        coffeeMachine[3] = if (coffeeMachine[3] > 0) coffeeMachine[3] - 1 else coffeeMachine[3]

        coffeeMachine[4] = if (coffeeMachine[4] > 0) coffeeMachine[4] + coffee["cost"]!! else coffeeMachine[4]

        println("I have enough resources, making you a coffee!")
    }

    return coffeeMachine

}

package machine

fun main() {

    print("Write how many ml of water the coffee machine has: ")
    val water = readln().toInt()

    print("Write how many ml of milk the coffee machine has: ")
    val milk = readln().toInt()

    print("Write how many grams of coffee beans the coffee machine has: ")
    val grams = readln().toInt()

    print("Write how many cups of coffee you will need: ")
    val cups = readln().toInt()

    val coffeeCups = coffeeCups(water,milk,grams)

    if (cups == coffeeCups) {
        println("Yes, I can make that amount of coffee")
    } else if (coffeeCups > cups) {
        println("Yes, I can make that amount of coffee (and even ${coffeeCups - cups} more than that)")
    } else if (cups > coffeeCups) {
        println("No, I can make only $coffeeCups cups of coffee")
    } else println("No, I can make only 0 cups of coffee")




}

fun coffeeCups(water: Int, milk: Int, grams: Int): Int {
    val cofferMachine = mapOf("water" to 200, "milk" to 50, "gramsCoffee" to 15)

    val water = water / cofferMachine["water"]!!
    //println("water - $water")
    val milk = milk / cofferMachine["milk"]!!
    //println("milk - $milk")
    val gramsCoffee = grams / cofferMachine["gramsCoffee"]!!
    //println("gramsCoffee - $gramsCoffee")

    return if (water <= milk &&  water <= gramsCoffee) {
        water
    } else if (milk < water && milk < gramsCoffee) {
        milk
    }else if (gramsCoffee < water && gramsCoffee < milk) {
        gramsCoffee
    }
    else 0

}

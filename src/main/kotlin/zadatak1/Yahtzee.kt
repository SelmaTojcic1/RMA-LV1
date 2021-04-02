package zadatak1

fun main() {
    val dice = Dice()

    while(dice.numberOfRolls > 0) {
        println("\n0: Roll dice \n1: Check result \n2: End game\n")
        var input = readLine()!!.toInt()

        when(input) {
            0 -> {
                dice.rollAll()
                dice.decreaseNumberOfRolls()
                dice.checkDiceValues()
                println("You have ${dice.numberOfRolls} roll(s) left")

                do {
                    println("\nEnter index of the die you want to select (enter 0 to continue playing)")
                    input = readLine()!!.toInt()

                    if (input in 1..6) {
                        dice.select(input - 1)
                    }

                } while (input != 0)
            }

            1 -> dice.checkResult()

            2 -> dice.numberOfRolls = 0
        }

    }
}
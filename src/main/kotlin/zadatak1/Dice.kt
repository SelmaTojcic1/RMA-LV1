package zadatak1

class Dice {
    var numberOfRolls : Int = 3
    private val dice = mutableListOf<Die>()
    private var diceValues = IntArray(6)

    init {
        for (i in 1..5) {
            dice.add(Die())
        }
    }

    fun rollAll() {
        if (numberOfRolls < 3) {
            for(die in dice) {
                die.roll()
            }
        }
    }

    fun decreaseNumberOfRolls() {
        numberOfRolls--
    }

    fun select(index: Int){
        dice[index].isSelected = true
    }

    fun checkDiceValues() {
        dice.forEachIndexed() {
                index, dice -> println("${index+1}. die: ${dice.value} " ) }
    }

    private fun getDiceValues() : IntArray {
        for(i in 0..4) {
            diceValues[i] = dice[i].value
        }
        return diceValues
    }

    fun checkResult() {
        when {
            checkStraight() -> {
                println("You have Straight!")
            }
            checkPoker() -> {
                println("You have Poker!")
            }
            checkFull() -> {
                println("You have Full House!")
            }
            else -> {
                println("You have nothing..")
            }
        }
    }

    private fun checkStraight() : Boolean {
        diceValues = getDiceValues()
        diceValues.sortDescending()
        val index = 0

        if (diceValues[index] == diceValues[index+1]+1 && diceValues[index] == diceValues[index+2]+2 &&
            diceValues[index] == diceValues[index+3]+3 && diceValues[index] == diceValues[index+4]+4) {
                return true
        }
        return false
    }

    private fun checkFull() : Boolean {
        diceValues = getDiceValues()
        diceValues.sortDescending()

        var threesExist = false
        var threesNumber = 0
        var twosExist = false

        for(index in 0..2 step 2) {
            if(diceValues[index] == diceValues[index+1] && diceValues[index] == diceValues[index+2]) {
                threesExist = true
                threesNumber = diceValues[index]
            }
        }
        for(index in 0..3 step 3) {
            if(diceValues[index] == diceValues[index+1] && diceValues[index] != threesNumber) {
                twosExist = true
            }
        }
        if(threesExist && twosExist)
            return true
        return false
    }

    private fun checkPoker() : Boolean {
        diceValues = getDiceValues()
        diceValues.sortDescending()

        for(index in 0..1) {
            if (diceValues[index] == diceValues[index+1] && diceValues[index] == diceValues[index+2] &&
                diceValues[index] == diceValues[index+3]) {
                return true
            }
        }
        return false
    }
}
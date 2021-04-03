package zadatak2

fun main() {
    val player = Player()
    val dealer = Dealer()
    var input: Int

    player.dealCards()
    println("Your sum is " + player.sum + "\n")
    println("1: Hit \n2: Stand\n")
    do {
        input = readLine()!!.toInt()
        if (input == 1) {
            player.hit()
            println("Your sum is " + player.sum + "\n")
            if (player.sum > 21) {
                println("You lost..")
                continue
            }
        }

        if (input == 2) {
            dealer.dealCards()
            println("Dealers sum is " + dealer.sum + "\n")
            dealer.hit()
            if (dealer.sum > 21 || player.sum > dealer.sum) {
                println("You won!")
            }
            else
                println("You lost..")
        }
    } while(input != 0)

}
package zadatak2

class Dealer: Player() {

    override fun hit() {
        if(sum <= 16) {
            super.hit()
            println("Dealers sum is $sum\n")
        }
    }
}
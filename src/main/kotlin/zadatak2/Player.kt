package zadatak2

open class Player {
    private val hand = Deck()
    var sum: Int = 0

    private fun getCard() : Card {
        return hand.deck.random()
    }

    fun dealCards() {
        var playersCard = getCard()
        playersCard.checkCard()
        sum += playersCard.rankToValue()

        playersCard = getCard()
        playersCard.checkCard()
        sum += playersCard.rankToValue()
    }

    open fun hit() {
        val playersCard = getCard()
        playersCard.checkCard()
        sum += playersCard.rankToValue()
        if(sum > 21 && playersCard.rank == Rank.ACE) {
            sum -= 10
        }
    }
}
package zadatak2

data class Card (
    var rank: Rank,
    var suit: Suit
    )
{
    fun rankToValue() : Int {
        return when(rank) {
            Rank.TWO -> 2
            Rank.THREE -> 3
            Rank.FOUR -> 4
            Rank.FIVE -> 5
            Rank.SIX -> 6
            Rank.SEVEN -> 7
            Rank.EIGHT -> 8
            Rank.NINE -> 9
            Rank.TEN -> 10
            Rank.JACK -> 10
            Rank.QUEEN -> 10
            Rank.KING -> 10
            Rank.ACE -> 11
        }
    }

    fun checkCard() {
        println("$rank of $suit")
    }
}




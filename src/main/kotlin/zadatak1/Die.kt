package zadatak1

data class Die (
    var value : Int = (1..6).random(),
    var isSelected : Boolean = false
) {

    fun roll() {
        if (!isSelected) {
            value = (1..6).random()
        }
    }
}

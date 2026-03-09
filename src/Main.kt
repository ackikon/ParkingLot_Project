fun main() {
   /* println("${readln()} car has parked.")
    println("${readln()} car left the parking lot.")
    println("${readln()} car just parked here.")
    listOf(ParkingLot(), ParkingLot())
    */

    val parkArea: MutableList<ParkingLot> = MutableList(0) { ParkingLot() }

    parking@ while (true) {
        readln().split(" ").run {
            when (this[0]) {
                "create" -> create(parkArea, this[1].toInt())
                "park" ->
                    if (parkArea.isEmpty()) println("Sorry, a parking lot has not been created.")
                    else println(park(parkArea, this[1], this[2].replaceFirstChar { it.uppercase() }))
                "leave" ->
                    if (parkArea.isEmpty()) println("Sorry, a parking lot has not been created.")
                    else if (parkArea[this[1].toInt() - 1].getState()) println("There is no car in spot ${this[1]}")
                    else {
                        parkArea[this[1].toInt() - 1].leave()
                        println("Spot ${this[1]} is free")
                    }
                "status" -> status(parkArea)
                "exit" -> break@parking
                else -> break@parking
            }
        }
    }
}
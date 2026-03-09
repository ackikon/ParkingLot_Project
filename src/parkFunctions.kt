fun park(
    parkingLotList: List<ParkingLot>,
    registrationNumber: String,
    color: String,
): String {
    for (parkingLot in parkingLotList) {
        if (parkingLot.getState()) {
            parkingLot.park(registrationNumber, color)
            return "$color car parked in spot ${parkingLotList.indexOf(parkingLot) + 1}"
        }
    }
    return "Sorry, the parking lot is full."
}

fun create(parkArea: MutableList<ParkingLot>, value: Int = 5) {
    parkArea.removeAll { true }
    parkArea.addAll(MutableList(value) { ParkingLot() })
    println("Created a parking lot with $value spots.")
}

fun status(parkArea: MutableList<ParkingLot>) {
    if (parkArea.filter { !it.getState() } == emptyList<ParkingLot>()) return println("Parking lot is empty.")
    for (parkingLot in parkArea) {
        if (!parkingLot.getState()) println("${parkArea.indexOf(parkingLot) + 1} ${parkingLot.registrationNumber} ${parkingLot.color}")
    }
}
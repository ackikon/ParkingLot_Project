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

fun status(parkArea: MutableList<ParkingLot>): String {
    if (parkArea.filter { !it.getState() }.toList() == emptyList<ParkingLot>()) return "Parking lot is empty."

    val listOfCars: MutableList<String> = emptyList<String>().toMutableList()
    for (parkingLot in parkArea) {
        if (!parkingLot.getState()) listOfCars.add("${parkArea.indexOf(parkingLot) + 1} ${parkingLot.registrationNumber} ${parkingLot.color}")
    }

    return listOfCars.joinToString("\n")
}

fun status(parkArea: MutableList<ParkingLot>,
           action: String,
           value: String,
           ):String {

    when (action) {
        "spot_by_color", "reg_by_color"-> {
            if (parkArea.filter { it.color.equals(value, true) }.toList() == emptyList<ParkingLot>()) {
                return "No cars with color $value were found."
            }
        }
        else -> {
            if (parkArea.filter { it.registrationNumber == value } == emptyList<ParkingLot>()) return "No cars with registration number $value were found."
        }
    }

    val listOfCars = emptyList<Any>().toMutableList()
        for (parkingLot in parkArea) {
            when (action) {
                "spot_by_color" -> if (parkingLot.color.equals(value, ignoreCase = true)) listOfCars.add(parkArea.indexOf(parkingLot) + 1)
                "reg_by_color" -> if (parkingLot.color.equals(value, ignoreCase = true)) listOfCars.add(parkingLot.registrationNumber)
                "spot_by_reg" -> if (parkingLot.registrationNumber.equals(value, ignoreCase = true)) listOfCars.add(parkArea.indexOf(parkingLot) + 1)
            }
        }

    return listOfCars.joinToString(", ")
}
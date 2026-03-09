class ParkingLot(
    private var _free: Boolean = true,
    private var _registrationNumber: String = "none",
    private var _color: String = "none",
) {
    val free: Boolean
        get() = _free

    val registrationNumber: String
        get() = _registrationNumber

    val color: String
        get() = _color

    fun park(registrationNumber: String, color: String) {
        _free = false
        this._registrationNumber = registrationNumber
        this._color = color
    }

    fun leave() {
        _free = true
        this._registrationNumber = "none"
        this._color = "none"
    }

    fun getState() = _free

    fun printInfo() = if (_free) println("Parking lot is free!") else println("Parking lot is occupied!")
}
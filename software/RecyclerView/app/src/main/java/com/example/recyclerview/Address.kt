package com.example.recyclerview

@Suppress("MemberVisibilityCanBePrivate")
data class Address(
    val name: String,
    val streetName: String,
    val streetNumber: Int,
    val postcode: String,
    val town: String,
    val provinceAbbr: String,
) {
    init {
        if (name.isEmpty())
            throw IllegalArgumentException("Must not be empty")
        if (streetName.isEmpty())
            throw IllegalArgumentException("Must not be empty")
        if (town.isEmpty())
            throw IllegalArgumentException("Must not be empty")
        if (streetNumber < 1)
            throw IllegalArgumentException("Must be a positive number")
        if (provinceAbbr.length != 2)
            throw IllegalArgumentException("Must be 2 chars long")
        if (postcode.length != 5)
            throw IllegalArgumentException("Must be 5 digit long")
        for (i in 0..4)
            if (postcode[i] < '0' || postcode[i] > '9')
                throw IllegalArgumentException("Must contain only digits")
    }

    fun getNameLine(): String { return name }
    fun getAddressLine(): String { return "$streetName  $streetNumber" }
    fun getTownLine(): String { return "$postcode $town $provinceAbbr" }

    override fun toString(): String {
        return "${getNameLine()}\n${getAddressLine()}\n${getTownLine()}"
    }
}

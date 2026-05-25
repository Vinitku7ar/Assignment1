package com.example.assignment1

data class Order(
    val orderId: String,
    val vehicleType: String,
    val dateString: String,
    val price: Double,
    val pickupLocation: String,
    val dropLocation: String,
    val status: String // e.g., "CANCELLED", "COMPLETED"
)

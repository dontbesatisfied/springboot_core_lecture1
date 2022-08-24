package com.example.pure_kotlin.order

interface OrderService {
    fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int
    ): Order
}
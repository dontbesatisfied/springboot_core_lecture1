package com.example.pure_kotlin.order

import com.example.pure_kotlin.discount.FixDiscountPolicy
import com.example.pure_kotlin.member.MemoryMemberRepository

class OrderServiceImpl: OrderService {
    private val memberRepository = MemoryMemberRepository()
    private val discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId) ?: throw Error("Not exists member")
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
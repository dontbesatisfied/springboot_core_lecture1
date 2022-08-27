package com.example.pure_kotlin.order

import com.example.pure_kotlin.discount.DiscountPolicy
import com.example.pure_kotlin.discount.FixDiscountPolicy
import com.example.pure_kotlin.discount.RateDiscountPolicy
import com.example.pure_kotlin.member.MemberRepository
import com.example.pure_kotlin.member.MemoryMemberRepository

class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
): OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId) ?: throw Error("Not exists member")
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
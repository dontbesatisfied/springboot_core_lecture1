package com.example.pure_kotlin.discount

import com.example.pure_kotlin.member.Grade
import com.example.pure_kotlin.member.Member

class RateDiscountPolicy: DiscountPolicy {
    private val discountPercent = 10

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            price * discountPercent / 100
        } else {
            0
        }
    }
}
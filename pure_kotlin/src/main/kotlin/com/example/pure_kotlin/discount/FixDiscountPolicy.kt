package com.example.pure_kotlin.discount

import com.example.pure_kotlin.member.Grade
import com.example.pure_kotlin.member.Member

class FixDiscountPolicy: DiscountPolicy {
    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}
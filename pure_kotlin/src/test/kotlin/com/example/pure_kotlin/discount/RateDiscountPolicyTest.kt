package com.example.pure_kotlin.discount

import com.example.pure_kotlin.member.Grade
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import com.example.pure_kotlin.member.Member
import org.junit.jupiter.api.Assertions

internal class RateDiscountPolicyTest {
    private val discountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    fun vip_o() {
        val member = Member(1L, "memeberVIP", Grade.VIP)

        val discount = discountPolicy.discount(member, 10000)

        assertEquals(1000, discount)
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다")
    fun vip_x() {
        val member = Member(2L, "memeberBASIC", Grade.BASIC)

        val discount = discountPolicy.discount(member, 10000)

        assertEquals(0, discount)
    }
}
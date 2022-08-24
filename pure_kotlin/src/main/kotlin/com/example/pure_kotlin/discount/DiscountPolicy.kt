package com.example.pure_kotlin.discount

import com.example.pure_kotlin.member.Member

interface DiscountPolicy {
    fun discount(member: Member, price: Int): Int
}
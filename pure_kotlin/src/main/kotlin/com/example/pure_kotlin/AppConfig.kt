package com.example.pure_kotlin

import com.example.pure_kotlin.discount.DiscountPolicy
import com.example.pure_kotlin.discount.FixDiscountPolicy
import com.example.pure_kotlin.discount.RateDiscountPolicy
import com.example.pure_kotlin.member.MemberRepository
import com.example.pure_kotlin.member.MemberService
import com.example.pure_kotlin.member.MemberServiceImpl
import com.example.pure_kotlin.member.MemoryMemberRepository
import com.example.pure_kotlin.order.OrderService
import com.example.pure_kotlin.order.OrderServiceImpl

class AppConfig {
    private fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    private fun discountPolicy(): DiscountPolicy {
//        return FixDiscountPolicy()
        return RateDiscountPolicy()
    }

    fun memberService(): MemberService {
        return MemberServiceImpl(this.memberRepository())
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(
            this.memberRepository(),
            this.discountPolicy()
        )
    }


}
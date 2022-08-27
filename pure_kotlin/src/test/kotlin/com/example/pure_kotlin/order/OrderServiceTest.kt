package com.example.pure_kotlin.order

import com.example.pure_kotlin.AppConfig
import com.example.pure_kotlin.member.Grade
import com.example.pure_kotlin.member.Member
import com.example.pure_kotlin.member.MemberService
import com.example.pure_kotlin.member.MemberServiceImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

    @Test
    fun createOrder() {
        val member = Member(1L, "memberA", Grade.VIP)
        memberService.join(member)

        val findedMember = memberService.findMember(member.id)

        val order = orderService.createOrder(findedMember!!.id, "itemA", 10000)
        Assertions.assertEquals(order.discountPrice, 1000)
    }
}
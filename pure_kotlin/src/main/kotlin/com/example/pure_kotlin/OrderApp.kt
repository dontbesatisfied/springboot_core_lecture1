package com.example.pure_kotlin

import com.example.pure_kotlin.member.Grade
import com.example.pure_kotlin.member.Member
import com.example.pure_kotlin.member.MemberServiceImpl
import com.example.pure_kotlin.order.OrderServiceImpl

class OrderApp {
}

fun main(args: Array<String>) {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findedMember = memberService.findMember(member.id)

    val order = orderService.createOrder(findedMember!!.id, "itemA", 10000)
    println(order)
    println(order.calculatePrice())
}
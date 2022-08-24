package com.example.pure_kotlin

import com.example.pure_kotlin.member.Grade
import com.example.pure_kotlin.member.Member
import com.example.pure_kotlin.member.MemberServiceImpl

//class MemberApp {
    fun main(args: Array<String>) {
        val memberService = MemberServiceImpl()
        val member = Member(1L, "memberA", Grade.VIP)
        memberService.join(member)

        val findedMember = memberService.findMember(member.id)
        println("new member = ${member.name}")
        println("findedMember = ${findedMember?.name}")
    }
//}
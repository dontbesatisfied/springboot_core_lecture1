package com.example.pure_kotlin.member

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private val memberService = MemberServiceImpl()

    @Test
    fun join() {
        val member = Member(1L, "memberA", Grade.VIP)

        memberService.join(member)
        val member1 = memberService.findMember(1L)

        Assertions.assertEquals(member, member1)
    }
}
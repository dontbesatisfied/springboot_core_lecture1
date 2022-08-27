package com.example.pure_kotlin.member

import com.example.pure_kotlin.AppConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private lateinit var memberService: MemberService

    @BeforeEach
    fun beforeEach() {
        memberService = AppConfig().memberService()
    }

    @Test
    fun join() {
        val member = Member(1L, "memberA", Grade.VIP)

        memberService.join(member)
        val member1 = memberService.findMember(1L)

        Assertions.assertEquals(member, member1)
    }
}
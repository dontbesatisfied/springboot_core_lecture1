package com.example.pure_kotlin.member

interface MemberService {

    fun join(member: Member)
    fun findMember(memberId: Long): Member?
}
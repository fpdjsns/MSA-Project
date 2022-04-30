package com.withhamit.circuit.application.member

interface MemberExternalQueryService {
    fun getMember(no: Int): MemberModel
}

package com.withhamit.starterProject.domain.member

import javax.persistence.*

@Table(name = "member")
data class Member(
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val no: Int
)

package com.example.springstudy.common

import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)

// DB 변경사항 히스토리
@Audited
abstract class Auditing {

    @CreatedDate
    @DateTimeFormat(pattern = DateTimeFormatType.DEFAULT_PATTERN)
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @DateTimeFormat(pattern = DateTimeFormatType.DEFAULT_PATTERN)
    var updatedAt: LocalDateTime? = null
}
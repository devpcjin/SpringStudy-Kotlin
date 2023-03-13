package com.example.springstudy.user.model

import com.example.springstudy.common.Auditing
import org.hibernate.envers.Audited
import javax.persistence.*

@Entity
@Audited
class User : Auditing(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 100)
    var email: String? = null

    @Column(length = 100)
    var password: String? = null

    @Column
    var authority: String? = null


}
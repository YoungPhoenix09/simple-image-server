package com.paynefulapps.simpleimageserver

import org.hibernate.annotations.Type
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(schema = "main")
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val imageName: String,

    @Column
    val created: LocalDate,

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    val imageData: ByteArray
)
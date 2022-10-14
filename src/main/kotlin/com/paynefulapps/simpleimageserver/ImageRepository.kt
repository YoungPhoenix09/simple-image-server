package com.paynefulapps.simpleimageserver

import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, Long>

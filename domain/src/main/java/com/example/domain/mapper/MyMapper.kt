package com.example.domain.mapper

interface MyMapper<Source,Domain> {

    fun mapToDomain(item:Source?):Domain?
    fun mapFromDomain(item: Domain?):Source?
}
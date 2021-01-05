package com.example.cookieclickerapp.datas

data class SingleUpgrade(
    var name: String,
    var cost: Long,
    var count: Int = 0,
    var isOpen: Boolean = false,
    var value: Double
)

package com.polaris04.sleepingcaffeine.presentation.map

sealed class MapSearchType {
    object Initialized :MapSearchType()
    object Starbucks:MapSearchType()
    object Ediya:MapSearchType()
}
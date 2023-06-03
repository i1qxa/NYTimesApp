package com.example.nytimesapp.data

import com.example.nytimesapp.data.local.critics.MapperCriticsDB
import com.example.nytimesapp.data.remote.critics.MapperCriticsRemote
import com.example.nytimesapp.domain.critics.CriticItem
import com.example.nytimesapp.domain.critics.CriticItemShort

class MapperCritic(
    val mapperRemote: MapperCriticsRemote,
    val mapperDB: MapperCriticsDB
) {

    fun mapCriticItemToCriticShort(item: CriticItem) =
        CriticItemShort(id = item.id, name = item.displayName, img = item.criticItemImg)

    fun mapListCriticItemToCriticItemShort(listItem: List<CriticItem>) =
        listItem.map { criticItem -> mapCriticItemToCriticShort(criticItem) }
}
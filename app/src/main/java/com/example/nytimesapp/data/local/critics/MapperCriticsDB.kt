package com.example.nytimesapp.data.local.critics

import com.example.nytimesapp.domain.critics.CriticItem

class MapperCriticsDB {

    fun mapDBtoCriticsItem(dbItem: CriticItemDB) = CriticItem(
        id = 0F,
        displayName = dbItem.displayName,
        sortName = dbItem.sortName,
        status = dbItem.status,
        bio = dbItem.bio,
        seoName = dbItem.seoName,
        criticItemImg = dbItem.imgSrcLocal
    )

    fun mapListDBToListCriticsItem(listDB:List<CriticItemDB>) = listDB.map { criticItemDB ->
        mapDBtoCriticsItem(criticItemDB)
    }

}
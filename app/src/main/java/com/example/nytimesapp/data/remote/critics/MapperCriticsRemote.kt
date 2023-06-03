package com.example.nytimesapp.data.remote.critics

import com.example.nytimesapp.data.local.critics.CriticItemDB

class MapperCriticsRemote {

    fun mapCriticRemoteToDB(criticRemote:CriticItemRemote) = CriticItemDB(
        id = 0F,
        displayName = criticRemote.displayName,
        sortName = criticRemote.sortName,
        status = criticRemote.status,
        bio = criticRemote.bio,
        seoName = criticRemote.seoName,
        imgSrcLocal = criticRemote.multimedia.resource.src
    )

    fun mapListRemoteToDB(listRemote:List<CriticItemRemote>) = listRemote.map { mapCriticRemoteToDB(it) }


}
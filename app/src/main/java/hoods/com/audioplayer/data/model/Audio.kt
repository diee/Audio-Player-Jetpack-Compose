package hoods.com.audioplayer.data.model

import android.net.Uri

data class Audio(
    val uri: Uri,
    val id: Long,
    val duration: Int,
    val title: String
)

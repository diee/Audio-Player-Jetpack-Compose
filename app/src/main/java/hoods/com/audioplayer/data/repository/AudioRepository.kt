package hoods.com.audioplayer.data.repository

import androidx.core.net.toUri
import hoods.com.audioplayer.data.model.Audio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioRepository @Inject constructor() {

    suspend fun getAudioData(): List<Audio> = withContext(Dispatchers.IO) {
        val audioList = mutableListOf<Audio>()
        audioList.add(
            Audio(
                uri = "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0036.mp3".toUri(),
                id = 1,
                duration = 5,
                title = "Test 1"
            )
        )
        audioList.add(
            Audio(
                uri = "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0019.mp3".toUri(),
                id = 2,
                duration = 3,
                title = "Test 2"
            )
        )

        audioList.add(
            Audio(
                uri = "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0020.mp3".toUri(),
                id = 3,
                duration = 3,
                title = "Test 3"
            )
        )

        audioList
    }
}

/*
* "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0036.mp3"
* "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0019.mp3"
* "https://wizard-media-production.s3.sa-east-1.amazonaws.com/uploads/audios/studentbook/0020.mp3"
*
* */
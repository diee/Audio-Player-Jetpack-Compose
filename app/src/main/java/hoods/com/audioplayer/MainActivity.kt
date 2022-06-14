package hoods.com.audioplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import hoods.com.audioplayer.ui.audio.AudioViewModel
import hoods.com.audioplayer.ui.audio.HomeScreen
import hoods.com.audioplayer.ui.theme.AudioPlayerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioPlayerTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val audioViewModel = viewModel(
                        modelClass = AudioViewModel::class.java
                    )
                    val audioList = audioViewModel.audioList
                    HomeScreen(
                        progress = audioViewModel.currentAudioProgress.value,
                        onProgressChange = {
                            audioViewModel.seekTo(it)
                        },
                        isAudioPlaying = audioViewModel.isAudioPlaying,
                        audioList = audioList,
                        currentPlayingAudio = audioViewModel
                            .currentPlayingAudio.value,
                        onStart = {
                            audioViewModel.playAudio(it)
                        },
                        onItemClick = {
                            audioViewModel.playAudio(it)
                        },
                        onNext = {
                            audioViewModel.skipToNext()
                        },
                        onPrevious = {
                            audioViewModel.skipToPrevious()
                        }
                    )
                }
            }
        }
    }
}
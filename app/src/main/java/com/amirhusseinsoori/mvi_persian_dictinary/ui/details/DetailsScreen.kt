package com.amirhusseinsoori.mvi_persian_dictinary.ui.details


import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.Word
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import java.util.*


@Composable
fun Details(word: Word) {
    val ctx = LocalContext.current


    var pronunciation: TextToSpeech? = null
    var audio: AudioManager? = null
    var ttsID: String? = null

    if (pronunciation == null) {
        pronunciation = TextToSpeech(
            ctx
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                pronunciation!!.language = Locale.US
                pronunciation!!.setSpeechRate(0.65f)
                pronunciation!!.setOnUtteranceProgressListener(object :
                    UtteranceProgressListener() {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onStart(utteranceId: String) {
                        if (utteranceId == ttsID) audio!!.requestAudioFocus(
                            AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                                .setAudioAttributes(
                                    AudioAttributes.Builder()
                                        .setUsage(AudioAttributes.USAGE_GAME)
                                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                                        .build()
                                )
                                .setAcceptsDelayedFocusGain(true)
                                .setOnAudioFocusChangeListener {
                                    //Handle Focus Change
                                }.build()
                        )

                    }

                    override fun onDone(utteranceId: String) {
                        if (utteranceId == ttsID) audio!!.abandonAudioFocusRequest(null!!);

                    }

                    override fun onError(utteranceId: String) {}
                })
            } else {
                Toast.makeText(ctx, "Cannot load Text-to-Speech service", Toast.LENGTH_SHORT).show()
            }

        }
    }






    DicTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    audio = ctx.getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
                    val musicVolume = audio!!.getStreamVolume(AudioManager.STREAM_MUSIC)
                    if (musicVolume <= 3) {
                        Toast
                            .makeText(ctx, "Volume is muted", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        //read word aloud if volume is not muted
                        val toSpeak: CharSequence = word.word
                        ttsID = ctx
                            .hashCode()
                            .toString() + ""
                        pronunciation!!.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, ttsID)
                    }

                }, verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DicCard(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xfff2ffff))
                    .padding(top = 70.dp, bottom = 70.dp, start = 15.dp, end = 15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 70.dp), text = word.word, fontFamily = utilFont,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                    Text(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 45.dp),
                        text = word.mean,
                        fontFamily = utilFont,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
    }



}








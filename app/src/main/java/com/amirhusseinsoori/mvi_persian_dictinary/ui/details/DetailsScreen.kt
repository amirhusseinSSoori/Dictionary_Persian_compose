package com.amirhusseinsoori.mvi_persian_dictinary.ui.details


import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.amirhusseinsoori.mvi_persian_dictinary.R
import com.amirhusseinsoori.mvi_persian_dictinary.common.utilFont
import com.amirhusseinsoori.mvi_persian_dictinary.data.db.entity.EnglishWord
import com.amirhusseinsoori.mvi_persian_dictinary.ui.component.DicCard
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.DicTheme
import com.amirhusseinsoori.mvi_persian_dictinary.ui.theme.Neutral2
import java.util.*


@Composable
fun Details(word: EnglishWord) {
    val ctx = LocalContext.current


    var pronunciation: TextToSpeech? = null
    var audio: AudioManager? = null
    var ttsID: String? = null

    if (pronunciation == null) {
        pronunciation = TextToSpeech(
            ctx
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                audio = ctx.getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
                ttsID = ctx.hashCode().toString() + ""
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
                .fillMaxSize().background(Neutral2), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DicCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, bottom = 50.dp, start = 15.dp, end = 15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 70.dp), text = word.englishWord, fontFamily = utilFont,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp
                    )
                    Text(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 45.dp),
                        text = word.englishWord,
                        fontFamily = utilFont,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clickable {
                                    initialSpeech(
                                        ttsID = ttsID!!,
                                        speech = pronunciation!!,
                                        audio = audio!!,
                                        ctx = ctx,
                                        word = word,
                                        Locale.ENGLISH
                                    )
                                },
                            painter = rememberImagePainter(R.drawable.english),
                            contentDescription = "SpeechToText"
                        )
                        Spacer(modifier = Modifier.padding(25.dp))
                        Image(
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clickable {
                                    initialSpeech(
                                        ttsID = ttsID!!,
                                        speech = pronunciation!!,
                                        audio = audio!!,
                                        ctx = ctx,
                                        word = word,
                                        Locale.UK
                                    )
                                },
                            painter = rememberImagePainter(R.drawable.usa),
                            contentDescription = "SpeechToText"
                        )

                    }

                    Image(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp).align(Alignment.End),
                        painter = rememberImagePainter(R.drawable.ic_baseline_star_24),
                        contentDescription = "SpeechToText"
                    )


                }
            }
        }
    }
}

fun initialSpeech(
    ttsID: String,
    speech: TextToSpeech,
    audio: AudioManager,
    ctx: Context,
    word: EnglishWord,
    local: Locale
) {
    speech.language = local
    val musicVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC)
    if (musicVolume <= 3) {
        Toast
            .makeText(ctx, "Volume is muted", Toast.LENGTH_SHORT)
            .show()
    } else {
        //read word aloud if volume is not muted
        val toSpeak: CharSequence = word.englishWord
        speech!!.speak(
            toSpeak,
            TextToSpeech.QUEUE_FLUSH,
            null,
            ttsID
        )
    }
}







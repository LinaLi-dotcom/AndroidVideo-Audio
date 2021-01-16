package com.example.video_audio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.media.AudioManager
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/* lägga till och kontrollera video
        var videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.flowerandbee)

        var mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()

 */
        var audioManager: AudioManager
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        var maxVolumn = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        var currentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        var mediaPlayer = MediaPlayer.create(this, R.raw.birdsound)
        var volumnSeekBar = findViewById<SeekBar>(R.id.anotherSeekBar)

        volumnSeekBar.setMax(maxVolumn)
        volumnSeekBar.setProgress(currentVolumn)

        volumnSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar, i: Int, fromUser: Boolean) {
                Log.i("seekbar changed", Integer.toString(i))
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        var anotherSeekBar = findViewById<SeekBar>(R.id.anotherSeekBar)
        anotherSeekBar.setMax(mediaPlayer.getDuration())

        anotherSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, fromUser: Boolean) {
                Log.i("anotherSeekBar changed", Integer.toString(i))
                mediaPlayer.seekTo(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        var timer = Timer().schedule(object: TimerTask(){
            override fun run() {
                anotherSeekBar.setProgress(mediaPlayer.getCurrentPosition())

            }
        }, 0, 300)


        var playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            mediaPlayer.start()
            //videoView.start()
        }

        var pauseButton = findViewById<Button>(R.id.pauseButton)
        pauseButton.setOnClickListener {
            mediaPlayer.pause()
            //videoView.pause()
        }

    }
}
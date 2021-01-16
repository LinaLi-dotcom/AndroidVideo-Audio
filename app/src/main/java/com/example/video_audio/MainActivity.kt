package com.example.video_audio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.flowerandbee)

        var mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()



        var mediaPlayer = MediaPlayer.create(this, R.raw.birdsound);

        var playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            //mediaPlayer.start()
            videoView.start()
        }

        var pauseButton = findViewById<Button>(R.id.pauseButton)
        pauseButton.setOnClickListener {
            //mediaPlayer.pause()
            videoView.pause()
        }

    }
}
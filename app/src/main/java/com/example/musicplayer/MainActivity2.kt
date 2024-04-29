package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        var seek = findViewById<SeekBar>(R.id.seekBar)
        val i = intent
        var songid = i.getIntExtra("SONGID",0)
        var imageid = i.getIntExtra("imageid",0)
        val songname = i.getStringExtra("songname") ?: "Unknown Song"
        var image2 = findViewById<ImageView>(R.id.imageView)
        var songtitle = findViewById<TextView>(R.id.songName)
        songtitle.text= songname
        image2.setImageResource(imageid)
        mediaPlayer= MediaPlayer.create(this,songid)
        mediaPlayer.start()

    }
    private fun initializeseek(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
    }
}
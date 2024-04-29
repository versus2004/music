package com.example.musicplayer

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val m1 = findViewById<CardView>(R.id.card1)
        val m2 = findViewById<CardView>(R.id.card2)
        val m3 = findViewById<CardView>(R.id.card3)
        val m4 = findViewById<CardView>(R.id.card4)
        val m5 = findViewById<CardView>(R.id.card5)
        val m6 = findViewById<CardView>(R.id.card6)

        m1.setOnClickListener {
            startMusicActivity(R.raw.baarisonmein,R.raw.baarishonmeinimage,"Baarishon Mein")
        }
        m2.setOnClickListener {
            startMusicActivity(R.raw.sanamre,R.raw.sanamreimage,"Sanam Re")
        }
        m3.setOnClickListener {
            startMusicActivity(R.raw.maiagarkahoon,R.raw.maiagarkahoon,"Mai Agar Kahoon")
        }
        m4.setOnClickListener {
            startMusicActivity(R.raw.thenightwemet,R.raw.thenightwemetimage,"The Night We Met")
        }
        m5.setOnClickListener {
            startMusicActivity(R.raw.pehlebhimain,R.raw.pehlebhimainimage,"Pehle Bhi Main")
        }
        m6.setOnClickListener {
            startMusicActivity(R.raw.haledil,R.raw.haledilimage,"Hale Dil")
        }
    }

    private fun startMusicActivity(musicResourceId: Int , imageresourceid:Int ,songname:String) {
        val i = Intent(applicationContext, MainActivity2::class.java)
        i.putExtra("SONGID", musicResourceId)
        i.putExtra("imageid", imageresourceid)
        i.putExtra("songname",songname)
        startActivity(i)
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun musicsetter(id: Int) {
        releaseMediaPlayer()
        mediaPlayer = MediaPlayer.create(this, id)
        mediaPlayer?.setOnCompletionListener { // Handle song completion (optional)
            releaseMediaPlayer()
        }
        mediaPlayer?.start()
    }
}

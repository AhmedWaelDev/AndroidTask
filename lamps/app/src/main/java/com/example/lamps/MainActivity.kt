package com.example.lamps

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var lampOff=true
    var lampCracked=false
    var lamp1Off=true
    var lamp1Cracked=false
    var lamp2Off=true
    var lamp2Cracked=false
    var lamp3Off=true
    var lamp3Cracked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgLamp1 =findViewById<ImageView>(R.id.imageView1)
        val imgLamp2 =findViewById<ImageView>(R.id.imageView2)
        val imgLamp3 =findViewById<ImageView>(R.id.imageView3)
        val imgLamp4 =findViewById<ImageView>(R.id.imageView4)
        val btn = findViewById<Button>(R.id.button)
        imgLamp4.setOnLongClickListener({
            val mp=MediaPlayer.create(this,R.raw.crash)
           if(lampCracked==false){
               if (!lamp1Cracked){
                   mp.start()
                   lamp1Cracked=true
                   imgLamp1.setImageResource(R.drawable.lamp_cr)
               }else if (!lamp2Cracked){
                   mp.start()
                   lamp2Cracked=true
                   imgLamp2.setImageResource(R.drawable.lamp_cr)
               }else if (!lamp3Cracked){
                   mp.start()
                   lamp3Cracked=true
                   imgLamp3.setImageResource(R.drawable.lamp_cr)
                   lampCracked=true
                   imgLamp4.setImageResource(R.drawable.lamp_cr)
                   btn.visibility=View.VISIBLE
               }

           }
            true
        })

    }

    fun onClickLamp (view: View){
        val imgLamp1 =findViewById<ImageView>(R.id.imageView1)
        val imgLamp2 =findViewById<ImageView>(R.id.imageView2)
        val imgLamp3 =findViewById<ImageView>(R.id.imageView3)
        val mediaPlayer=MediaPlayer.create(this,R.raw.click)
        val imageview=view as androidx.appcompat.widget.AppCompatImageView

        if (lampOff && !lampCracked){
            imageview.setImageResource(R.drawable.lamp_on)
            lampOff=false
            mediaPlayer.start()
            if(!lamp1Cracked){
                imgLamp1.setImageResource(R.drawable.lamp_on)
                lamp1Off=false
            }else if(!lamp2Cracked){
                imgLamp2.setImageResource(R.drawable.lamp_on)
                lamp2Off=false
            }else if(!lamp3Cracked){
                imgLamp3.setImageResource(R.drawable.lamp_on)
                lamp3Off=false
            }

        } else if (!lampOff && !lampCracked){
            imageview.setImageResource(R.drawable.lamp_of)
            lampOff=true
            mediaPlayer.start()
            if(!lamp1Cracked){
                imgLamp1.setImageResource(R.drawable.lamp_of)
                lamp1Off=true
            }else if(!lamp2Cracked){
                imgLamp2.setImageResource(R.drawable.lamp_of)
                lamp2Off=true
            }else if(!lamp3Cracked){
                imgLamp3.setImageResource(R.drawable.lamp_of)
                lamp3Off=true
            }
        }

    }
    fun onBtnClick(view: View){
        val imgLamp1 =findViewById<ImageView>(R.id.imageView1)
        val imgLamp2 =findViewById<ImageView>(R.id.imageView2)
        val imgLamp3 =findViewById<ImageView>(R.id.imageView3)
        val imgLamp4 =findViewById<ImageView>(R.id.imageView4)
        if (lampCracked){
            imgLamp1.setImageResource(R.drawable.lamp_of)
            lamp1Off=true
            lamp1Cracked=false
            imgLamp2.setImageResource(R.drawable.lamp_of)
            lamp2Off=true
            lamp2Cracked=false
            imgLamp3.setImageResource(R.drawable.lamp_of)
            lamp3Off=true
            lamp3Cracked=false
            imgLamp4.setImageResource(R.drawable.lamp_of)
            lampOff=true
            lampCracked=false
        }
        (view as Button).visibility=View.INVISIBLE

    }
}
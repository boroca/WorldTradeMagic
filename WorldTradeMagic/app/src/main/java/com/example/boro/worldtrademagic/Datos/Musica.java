package com.example.boro.worldtrademagic.Datos;

import android.content.Context;
import android.media.MediaPlayer;

public class Musica {

    MediaPlayer player;
    private int id;
    int count ;
    Context context;

    public Musica(Context context){
        player = new MediaPlayer();
        count = 0;
        id = 0;
        this.context = context;
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
    }

    public Musica(Context context, int idCancion){
        player = new MediaPlayer();
        count = 0;
        id = idCancion;
        this.context = context;
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
    }

    public Musica(int idCancion){
        player = new MediaPlayer();
        count = 0;
        id = idCancion;
    }

    public void playMusic(){

        player.reset();                               //resets the media player
        player.release();
        player = MediaPlayer.create(context, id);
        player.start();
    }

    public void stopMusic(){

        player.stop();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

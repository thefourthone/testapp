package com.BenjaminLanders.testapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	Button hello, bye;
	MediaPlayer voice;
	boolean sound=false;
	TextView text;
	Thread playerthread;
	int playingmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = (Button) findViewById(R.id.bhello);
        hello.setOnClickListener(this);
        bye = (Button) findViewById(R.id.bbye);
        bye.setOnClickListener(this);
        text = (TextView) findViewById(R.id.tvSaying);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		text.setText("why it no work?");
		switch(v.getId()){
		case R.id.bhello:
			text.setText("hello");
			playingmusic = R.raw.iseeyou;
			break;
		case R.id.bbye:
			text.setText("hey hey hey");
			playingmusic = R.raw.heyheyhey;
			break;
		}
		if(!sound){
		playerthread = new Thread(){ //code to play music
			public void run(){
				voice =  MediaPlayer.create(MainActivity.this, playingmusic);
				voice.start();
				sound = true;
				voice.setLooping(false);
				while(voice.isPlaying()){
				}
				voice.release();	
				sound = false;
			}
		};
		playerthread.start();
		}
	}
    
}

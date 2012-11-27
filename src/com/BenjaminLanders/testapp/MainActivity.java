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
	TextView text;
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
			voice =  MediaPlayer.create(MainActivity.this, R.raw.iseeyou);
			voice.start();
			break;
		case R.id.bbye:
			text.setText("hey hey hey");
			voice =  MediaPlayer.create(MainActivity.this, R.raw.heyheyhey);
			voice.start();
			break;
		}
		voice.setLooping(false);
		while(voice.isPlaying()){
		}
		voice.release();	
	}
    
}

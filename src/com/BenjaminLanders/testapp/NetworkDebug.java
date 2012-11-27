package com.BenjaminLanders.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class NetworkDebug extends Activity implements OnCheckedChangeListener, OnClickListener{
	Button sendMsg, submitCnt;
	TextView msgBox;
	EditText serverip, portnum, msgout;
	RadioGroup serverchoice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_debug);
		sendMsg = (Button) findViewById(R.id.bSubmitMessage);
		sendMsg.setOnClickListener(this);
		submitCnt = (Button) findViewById(R.id.bSubmitConnection);
		submitCnt.setOnClickListener(this);
		serverip = (EditText) findViewById(R.id.etServerIP);
		portnum = (EditText) findViewById(R.id.etPort);
		msgout = (EditText) findViewById(R.id.etMessage);
		serverchoice = (RadioGroup) findViewById(R.id.rbgServerChoice);//setting all the buttons edittexts to their spots
		serverchoice.setOnCheckedChangeListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.rbServer:
			serverip.setVisibility(View.VISIBLE);
			break;
		case R.id.rbClient:
			serverip.setVisibility(View.GONE);
			break;
		
		}
		
	}

}

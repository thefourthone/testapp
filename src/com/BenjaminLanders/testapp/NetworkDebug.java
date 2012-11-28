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

public class NetworkDebug extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	Button sendMsg, submitCnt;
	TextView msgBox;
	EditText serverip, portnum, msgout;
	RadioGroup serverchoice;
	ServerClientHelper helper;
	boolean isclient = true;

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
		serverchoice = (RadioGroup) findViewById(R.id.rbgServerChoice);// setting
																		// all
																		// the
																		// buttons
																		// edittexts
																		// to
																		// their
																		// spots
		serverchoice.setOnCheckedChangeListener(this);
		msgBox = (TextView) findViewById(R.id.tvRecievedMessages);
		helper = new ServerClientHelper();
		helper.setOutput(msgBox);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSubmitConnection:
			if (isclient) {
				// Integer.parseInt(portnum.getText().toString());
				msgBox.append("making client \n");
				helper.connecttoServer(serverip.getText().toString(), 300);// Integer.parseInt(portnum.getText().toString()));
			} else {
				// Integer.parseInt(portnum.getText().toString());
				msgBox.append("making sever \n");
				helper.makeServer(300);// Integer.parseInt(portnum.getText().toString()));
			}
			break;
		case R.id.bSubmitMessage:
			helper.write(msgout.getText().toString());
			break;
		default:
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rbServer:
			isclient = true;
			serverip.setVisibility(View.VISIBLE);
			break;
		case R.id.rbClient:
			isclient = false;
			serverip.setVisibility(View.GONE);
			break;
		default:

		}

	}

}

package com.BenjaminLanders.testapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import android.widget.TextView;

/**
 * Makes the serversockets and sockets for the connection
 * 
 * @author Benjamin Landers
 */
public class ServerClientHelper implements Runnable {
	Socket out;
	ServerSocket in;
	Thread worker;
	TextView output;
	BufferedReader reader;
	OutputStreamWriter writer;
	boolean stopmessage = false, isServer = false;
	String temp;

	public void connecttoServer(String ip, int port) {
		isServer = false;
		try {
			out = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			output.append("Unknown host");
		} catch (IOException e) {
			e.printStackTrace();
			output.append("IO Error");
		}
		// worker = new Thread(this);
		// worker.start();

	}

	public void makeServer(int port) {
		isServer = true;
		try {
			in = new ServerSocket(port);
		} catch (IOException e) {
			output.append("IO Error");
			e.printStackTrace();
		}
		worker = new Thread(this);
		worker.start();

	}

	private void useconnection() {
		try {
			reader = new BufferedReader(new InputStreamReader(
					out.getInputStream()));
			writer = new OutputStreamWriter(out.getOutputStream());
			while ((temp = reader.readLine()) != null && !stopmessage) {
				output.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
			output.append("IO Error");
		}
		stopmessage = false;
		out = null;
		writer = null;
		reader = null;
	}

	public void write(String text) {
		if (writer != null) {
			try {
				writer.write(text);
			} catch (IOException e) {
				output.append("IO Error");
				e.printStackTrace();
			}
		}
	}

	public void run() {
	
		 if(isServer){
		 try {
		 out = in.accept();
		 } catch (IOException e) {
		 output.append("IO Error");
		 e.printStackTrace();
		 }
		 }
		 
		// useconnection();

	}

	public void setOutput(TextView v) {
		output = v;
	}
}

package com.seanisko.smsreader;
import android.content.*;
import android.telephony.*;
import android.speech.tts.*;
import java.util.*;

public class SMSReceiver extends BroadcastReceiver implements TextToSpeech.OnInitListener{

	private TextToSpeech tts;
	private String message;
	private String sender;
	
	public SMSReceiver() {
		super();
	}
	
	@Override
	public void onInit(int p1) {
		tts.speak(message, TextToSpeech.QUEUE_ADD, null);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Object[] pdus = (Object[])intent.getExtras().get("pdus");
		SmsMessage shortMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);
		sender = shortMessage.getOriginatingAddress();
		message = shortMessage.getDisplayMessageBody();
		tts = new TextToSpeech(context.getApplicationContext(), this);
	}
}


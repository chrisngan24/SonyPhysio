package com.example.physio;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.physio.*;

public class ExtensionReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d(SmartExtensionsService.NSD_SERVICE, "onReceive: "+ intent.getAction()); 
		intent.setClass(context, SmartExtensionsService.class); 
		context.startService(intent);
		
	}

}

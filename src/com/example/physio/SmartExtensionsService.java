package com.example.physio;

import com.sonyericsson.extras.liveware.extension.util.ExtensionService;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class SmartExtensionsService extends ExtensionService{
	public static final String EXTENSION_KEY = "com.hellosmartwatch.key";
	public static final String LOG_TAG = "Hello Smart Watch Extension";
	public static final String NSD_SERVICE = "Service";

	public SmartExtensionsService(String extensionKey) {
		super(extensionKey);
		// TODO Auto-generated constructor stub
	}
	
	public SmartExtensionsService(){
		super(EXTENSION_KEY);
	}

	@Override
	protected RegistrationInformation getRegistrationInformation() {
		// TODO Auto-generated method stub
		return new SmartRegistrationInformation(this);
	}

	@Override
	protected boolean keepRunningWhenConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ControlExtension createControlExtension(String hostAppPackageName) {
		// TODO Auto-generated method stub
		return new SmartSensorControl(this, hostAppPackageName);
	}
	

}

package com.example.physio;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.physio.R;
import com.sonyericsson.extras.liveware.aef.sensor.Sensor;

import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensor;
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensorEvent;
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensorEventListener;
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensorException;
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensorManager;

public class SmartSensorControl extends ControlExtension{
	private AccessorySensor mSensor;
    public static final int WIDTH = 128;

    public static final int HEIGHT = 128;
    
    private AccessorySensor sensor = null;
    private Context mContext;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.RGB_565;
    
    private final AccessorySensorEventListener listener = new AccessorySensorEventListener() {
		
		@Override
		public void onSensorEvent(AccessorySensorEvent arg0) {
			updateDisplay(arg0);
			
		}
	}; 
    
	public SmartSensorControl(Context context, String hostAppPackageName) {
		super(context, hostAppPackageName);
		mContext = context;
		AccessorySensorManager manager = new AccessorySensorManager(context, hostAppPackageName);
		// TODO Auto-generated constructor stub		
		sensor = manager.getSensor(Sensor.SENSOR_TYPE_ACCELEROMETER);
		try {
			sensor.registerInterruptListener(listener);
		} catch (AccessorySensorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, BITMAP_CONFIG);
        
		//Set up layout
		LinearLayout root = new LinearLayout(mContext);
        root.setLayoutParams(new LayoutParams(WIDTH, HEIGHT));
		
        
        LinearLayout layout = (LinearLayout)LinearLayout.inflate(mContext, 
        		R.layout.main, root); 
        		((TextView)layout.findViewById(R.id.textHello)) 
        		.setText("Hello");
        		layout.measure(WIDTH, HEIGHT); 
        		layout.layout(0, 0, layout.getMeasuredWidth(), 
        		layout.getMeasuredHeight()); 
//		Set up layout from xml
//		LinearLayout layout = (LinearLayout)LinearLayout.inflate(mContext,
//                R.layout.main, root);
//		layout.measure(WIDTH, HEIGHT);
//        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        
		Canvas canvas = new Canvas(bitmap);
        layout.draw(canvas);

        showBitmap(bitmap);
		
	}
	
	private void updateDisplay(AccessorySensorEvent event){
		Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, BITMAP_CONFIG);
        
		//Set up layout
		LinearLayout root = new LinearLayout(mContext);
        root.setLayoutParams(new LayoutParams(WIDTH, HEIGHT));
		float[] values = event.getSensorValues();
        
        LinearLayout layout = (LinearLayout)LinearLayout.inflate(mContext, 
        		R.layout.main, root); 
        		((TextView)layout.findViewById(R.id.textHello)) 
        		.setText(Float.toString(values[0]));
        		layout.measure(WIDTH, HEIGHT); 
        		layout.layout(0, 0, layout.getMeasuredWidth(), 
        		layout.getMeasuredHeight()); 
//		Set up layout from xml
//		LinearLayout layout = (LinearLayout)LinearLayout.inflate(mContext,
//                R.layout.main, root);
//		layout.measure(WIDTH, HEIGHT);
//        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        
		Canvas canvas = new Canvas(bitmap);
        layout.draw(canvas);

        showBitmap(bitmap);
	}
	
	

}

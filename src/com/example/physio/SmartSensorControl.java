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
import com.sonyericsson.extras.liveware.extension.util.sensor.AccessorySensorManager;

public class SmartSensorControl extends ControlExtension{
	private AccessorySensor mSensor;
    public static final int WIDTH = 128;

    public static final int HEIGHT = 128;
    private Context mContext;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.RGB_565;

	public SmartSensorControl(Context context, String hostAppPackageName) {
		super(context, hostAppPackageName);
		mContext = context;
		// TODO Auto-generated constructor stub		
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
		updateDisplay();
	}
	
	private void updateDisplay(){
		Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, BITMAP_CONFIG);
        
		//Set up layout
		LinearLayout root = new LinearLayout(mContext);
        root.setLayoutParams(new LayoutParams(WIDTH, HEIGHT));
		
        
        LinearLayout layout = (LinearLayout)LinearLayout.inflate(mContext, 
        		R.layout.main, root); 
        		((TextView)layout.findViewById(R.id.textHello)) 
        		.setText("Hello World");
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

package com.example.texteditor;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button red,green,blue,zeng,suo,cu,xie,mo;
	private TextView testText;
	private EditText content;
	private int flag=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		testText=(TextView)findViewById(R.id.testText);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		
		zeng=(Button)findViewById(R.id.zeng);
		suo=(Button)findViewById(R.id.suo);
		
		testText.setTypeface(Typeface.DEFAULT);
		cu=(Button)findViewById(R.id.cu);
		xie=(Button)findViewById(R.id.xie);
		mo=(Button)findViewById(R.id.mo);
		
		content=(EditText)findViewById(R.id.content);
		
		ColorListner myColorListner=new ColorListner();
		red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		
		SizeListener mysizeListner=new SizeListener(testText);
		zeng.setOnClickListener(mysizeListner);
		suo.setOnClickListener(mysizeListner);
		
        cu.setOnClickListener(this);
        xie.setOnClickListener(this);
        mo.setOnClickListener(this);

        content.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				testText.setText(content.getText().toString());
				return false;
			}
		});
	}
	
	private class ColorListner implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);
				break;
			case R.id.green:
				testText.setTextColor(Color.GREEN);
				break;
			case R.id.blue:
				testText.setTextColor(Color.BLUE);
				break;
			default:break;	
			}
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Typeface tf=testText.getTypeface();
		//testText.get
		switch (v.getId()) {
		case R.id.xie:			
			if(flag==2||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
				flag=3;
			}else{
				testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);//–±ÃÂ
				flag=1;
			}			
			break;
		case R.id.cu:
			if(flag==1||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);//¥÷ÃÂ
				flag=3;
			}else{
				testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);//¥÷ÃÂ
				flag=2;
			}						
			break;
		case R.id.mo:
			testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
			flag=0;
			break;
		default:
			break;
		}
	}

}


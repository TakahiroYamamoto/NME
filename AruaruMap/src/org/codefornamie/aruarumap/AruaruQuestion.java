package org.codefornamie.aruarumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class AruaruQuestion extends Activity {
	public static final int RESULT_PASS = -1;
	public static final int RESULT_MARU = 0;
	public static final int RESULT_BATSU = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aruaru_question);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("QUESTION_RESULT", RESULT_PASS);
				setResult(RESULT_OK, intent);
				finish();
			}
        });
        ImageView imgMaru = (ImageView)findViewById(R.id.imageView1);
        imgMaru.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("QUESTION_RESULT", RESULT_MARU);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
        ImageView imgBatsu = (ImageView)findViewById(R.id.imageView2);
        imgBatsu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("QUESTION_RESULT", RESULT_BATSU);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}
}

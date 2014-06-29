package org.codefornamie.aruarumap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class AruaruMapView extends FragmentActivity {
	private static boolean mIsFirstLaunch = true;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);
        Button button = new Button(this);
        button.setText("新しいお題を見る");
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				question();
			}
		});
        this.addContentView(button, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        if(mIsFirstLaunch) {
        	mIsFirstLaunch = false;
        	Intent it = new Intent(getApplicationContext(), FirstQuestion.class);
        	startActivityForResult(it, 0);
        }
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		if(arg2 == null)
			return;
		if(arg2.hasExtra("FIRST_QUESTION")) {
			
		}
		else if(arg2.hasExtra("QUESTION_RESULT")) {
			
		}
	}

	private void question() {
    	Intent intent = new Intent(getApplicationContext(), AruaruQuestion.class);
    	startActivityForResult(intent, 0);
	}
}

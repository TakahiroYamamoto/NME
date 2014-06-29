package org.codefornamie.aruarumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;

public class FirstQuestion extends Activity {
	private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_question);
        Button button = (Button)findViewById(R.id.button1);
        rb1 = (RadioButton)findViewById(R.id.radiobutton1_1);
        rb2 = (RadioButton)findViewById(R.id.radiobutton2_1);
        rb3 = (RadioButton)findViewById(R.id.radiobutton3_1);
        rb4 = (RadioButton)findViewById(R.id.radiobutton4_1);
        rb5 = (RadioButton)findViewById(R.id.radiobutton5_1);
        rb6 = (RadioButton)findViewById(R.id.radiobutton6_1);
        rb7 = (RadioButton)findViewById(R.id.radiobutton7_1);
        button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent res = new Intent();
				boolean a[] = new boolean[7];
				a[0] = rb1.isChecked();
				a[1] = rb2.isChecked();
				a[2] = rb3.isChecked();
				a[3] = rb4.isChecked();
				a[4] = rb5.isChecked();
				a[5] = rb6.isChecked();
				a[6] = rb7.isChecked();
				res.putExtra("FIRST_QUESTION", a);
				setResult(RESULT_OK, res);
				finish();
			}
        });
	}
}

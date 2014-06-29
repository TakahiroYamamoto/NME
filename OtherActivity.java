package jp.example.helloworld;

import jp.example.helloworld.MainActivity.PlaceholderFragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.othre);
	}
	
	public void doAction2(View view){
		Intent intent =  new Intent(this,jp.example.helloworld.MainActivity.class);
		this.startActivity(intent);
	}
}

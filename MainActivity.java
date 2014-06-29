package jp.example.helloworld;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private static final TextView TexiyView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void doAction2(View view){
		/*
		final Activity activity = this;
		EditText edit1 = (EditText)this.findViewById(R.id.editText1);
		Editable str = edit1.getText();
		TextView text1 = (TextView)this.findViewById(R.id.textView1);
		text1.setText("you typed: " + str);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Message");
		builder.setMessage("Change Activity.");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent =  new Intent(activity,jp.example.helloworld.OtherActivity.class);
				activity.startActivity(intent);
			}
		});
		builder.setNegativeButton("Cancel", null);
		builder.show();	
		*/
		
		Intent intent =  new Intent(this,jp.example.helloworld.OtherActivity.class);
		this.startActivity(intent);
	}
	
	public void doAction(View view){
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.jp"));
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}

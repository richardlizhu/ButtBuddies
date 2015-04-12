package name.bagi.levente.pedometer;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams; 

public class activity_three extends Activity implements OnClickListener{
	LinearLayout layoutOfPopup;
	PopupWindow popupMessage;
	private Button popupButton, insidePopupButton;
	private int height;
	private int width;
	private int temp;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);

	}                                            
	
	//public void init() { popupButton = (Button) findViewById(R.id.buttonPrompt); popupText = new TextView(this); insidePopupButton = new Button(this); layoutOfPopup = new LinearLayout(this); insidePopupButton.setText("OK"); popupText.setText("This is Popup Window.press OK to dismiss it."); popupText.setPadding(0, 0, 0, 20); layoutOfPopup.setOrientation(1); layoutOfPopup.addView(popupText); layoutOfPopup.addView(insidePopupButton); }

	//'public void popupInit() { popupButton.setOnClickListener(this); insidePopupButton.setOnClickListener(this); popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT); popupMessage.setContentView(layoutOfPopup); }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.two, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//if (id == R.id.action_settings) {
			//return true;
		//}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}

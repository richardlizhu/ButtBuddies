package name.bagi.levente.pedometer;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

public class login extends Activity{
	private PopupWindow pwindo;

	private void initiatePopupWindow() {
		try {
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) login.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.activity_two,
					(ViewGroup) findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout, 500, 400, true);

			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

			Button btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
			TextView popupText=(TextView) pwindo.getContentView().findViewById(R.id.txtView);
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								
			btnClosePopup.setOnClickListener(cancel_button_click_listener);
          
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();

		}
	};
}

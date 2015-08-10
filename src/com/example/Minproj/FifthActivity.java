package com.example.Minproj;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class FifthActivity extends Activity {

	String s="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth);
		
		TextView absent = (TextView)findViewById(R.id.absentees);
		
		Bundle bundle = this.getIntent().getExtras();
		String[] array=bundle.getStringArray("absent");
		int count=getIntent().getIntExtra("count", -1);
		
		
		
for(int i=0;i<count;i++)
{
	s=s+"\n"+array[i];
}
absent.setText(s);
		
		
		//String val = bundle.getString("rollno");
		//absent.setText(val);
	
	 Button startBtn = (Button) findViewById(R.id.email);
     startBtn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        sendEmail();
     }
  });
     Button startBtn1 = (Button) findViewById(R.id.sms);
     startBtn1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        sendSMS();
     }
  });

}
	protected void sendSMS() {
	    
	      Intent smsIntent = new Intent(Intent.ACTION_VIEW);
	      smsIntent.setData(Uri.parse("smsto:"));
	      smsIntent.setType("vnd.android-dir/mms-sms");

	      smsIntent.putExtra("address"  , new String ("9700874241"));
	      smsIntent.putExtra("sms_body"  , s);
	      try {
	         startActivity(smsIntent);
	         finish();
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(this, 
	         "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
	      }
	   }
	
	protected void sendEmail() {
	     

	      String[] TO = {"amrood.admin@gmail.com"};
	      String[] CC = {"mcmohd@gmail.com"};
	      Intent emailIntent = new Intent(Intent.ACTION_SEND);
	      emailIntent.setData(Uri.parse("mailto:"));
	      emailIntent.setType("text/plain");
	      
	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	      emailIntent.putExtra(Intent.EXTRA_CC, CC);
	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, " Attendance report ");
	      emailIntent.putExtra(Intent.EXTRA_TEXT,s);

	      try {
	         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	         finish();
	         
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(this, 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
	      }
	   }
	
}

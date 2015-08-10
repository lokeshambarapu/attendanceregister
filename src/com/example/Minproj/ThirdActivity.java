package com.example.Minproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends ActionBarActivity {

	Button enter;
	CommentsDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirdactivity);
		
		datasource = new CommentsDataSource(this);
	    datasource.open();
		
	    final EditText value = (EditText) findViewById(R.id.editText1);
	    //String toBeInserted = value.getText().toString();
	    
		enter = (Button) findViewById(R.id.enter);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Database Stuff
				String comment = value.getText().toString();
			      datasource.createComment(comment);
			      value.setText("");
			}
		});
	}

	public void onClick(View view){
		startActivity(new Intent(ThirdActivity.this,TestDatabaseActivity.class));	
		}


}

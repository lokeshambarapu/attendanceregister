package com.example.Minproj;
 
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity {
 Spinner spinnerDropDown,spinnerDropDown1,spinnerDropDown2;
 String[] year = {
 "1st year",
 "2nd year",
 "3rd year",
 "4th year"
  };
 String[] branch = {
 "CSE",
 "IT",
 "ECE",
 "EEE",
 "MECH",
 "PROD",
 "BIOTECH"
 };
 String[] section = {
		 "1",
		 "2",
		 "3",
		 };
		 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.secondactivity);
 
 // Get reference of SpinnerView from layout/main_activity.xml
 spinnerDropDown =(Spinner)findViewById(R.id.spinner1);
 spinnerDropDown1 =(Spinner)findViewById(R.id.spinner2);
 spinnerDropDown2 =(Spinner)findViewById(R.id.spinner3);
 
 
 ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.
 R.layout.simple_spinner_dropdown_item ,year);
 
 ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.
 R.layout.simple_spinner_dropdown_item ,branch);
 
 ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,android.
 R.layout.simple_spinner_dropdown_item ,section);
		 	 
 
 spinnerDropDown.setAdapter(adapter);
 
 spinnerDropDown1.setAdapter(adapter1);
 
 spinnerDropDown2.setAdapter(adapter2);


 spinnerDropDown.setOnItemSelectedListener(new OnItemSelectedListener() {
 @Override
 public void onItemSelected(AdapterView<?> parent, View view,
 int position, long id) {
 // Get select item
 int sid=spinnerDropDown.getSelectedItemPosition();
 Toast.makeText(getBaseContext(), "You have selected year : " + year[sid],
 Toast.LENGTH_SHORT).show(); 
 }
 
 @Override
 public void onNothingSelected(AdapterView<?> parent) {
 // TODO Auto-generated method stub 
}
 });
 }
 public void onClick(View view){
	 startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
	 }

 
}
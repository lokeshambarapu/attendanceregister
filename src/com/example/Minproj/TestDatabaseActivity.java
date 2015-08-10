package com.example.Minproj;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
  
public class TestDatabaseActivity extends Activity {  
    
  protected static final AdapterView<ListAdapter> Listview = null;
protected static final String CustomerDBAdapter = null;
private ListView mainListView ;  
  private ArrayAdapter<Comment> listAdapter ;  
  private CommentsDataSource datasource;
  public int c=0;
  int count=0;
  
  String[] absentees;
  Button add,del,sub;
    
  /** Called when the activity is first created. */  
  @Override  
  public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.main);  
    
    add = (Button) findViewById(R.id.add);
    del = (Button) findViewById(R.id.del);
    sub = (Button) findViewById(R.id.sub);
    
    absentees=new String[30];
    
    datasource = new CommentsDataSource(this);
    datasource.open();

    List<Comment> values = datasource.getAllComments();
    // Find the ListView resource.   
    mainListView = (ListView) findViewById( R.id.mainListView );  
    
    // Create ArrayAdapter using the result list.  
    listAdapter = new ArrayAdapter<Comment>(this, R.layout.simplerow, values);  
            
    // Set the ArrayAdapter as the ListView's adapter.  
    mainListView.setAdapter( listAdapter );
    
    add.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent back = new Intent(TestDatabaseActivity.this,ThirdActivity.class);
			startActivity(back);
		}
	});
    
    del.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Comment comment;
			if (mainListView.getAdapter().getCount() > 0) {
		        comment = (Comment) mainListView.getAdapter().getItem(0);
		        datasource.deleteComment(comment);
		         listAdapter.remove(comment);
		      }
			
			
		}
		
	});
   
    sub.setOnClickListener(new OnClickListener() {
		 @Override
			public void onClick(View v) {
			
			// TODO Auto-generated method stub

			 Bundle b=new Bundle();
			 b.putStringArray("absent", absentees);
			 
Intent forward = new Intent(TestDatabaseActivity.this,FifthActivity.class);
forward.putExtras(b);
forward.putExtra("count", count);
			startActivity(forward);

			}
		});	
   final Intent next = new Intent(TestDatabaseActivity.this,FifthActivity.class);

    mainListView.setOnItemClickListener(new OnItemClickListener() {
    	  

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
		
			
				((TextView)view).setBackgroundColor(Color.RED);
			Toast.makeText(getApplicationContext(),"Clicked Something",Toast.LENGTH_LONG).show();
			String roll = ((TextView)view).getText().toString();
			
			next.putExtra("rollno", roll);
			absentees[count] = roll;
			count++;
			 	//startActivity(next);		
			    
		}
	});
  }  
}
 
package com.example.newtodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class AddTask extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText editTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        editTask=(EditText) findViewById(R.id.editTask);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference().child("Tasks");
    }

    public void addButtonClicked(View view){
        final String name=editTask.getText().toString().trim();
        long date=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String datestring=sdf.format(date);
        DatabaseReference newTask=myRef.push();
        newTask.child("name").setValue(name);
        newTask.child("date").setValue(datestring);
        Intent intent=new Intent(AddTask.this,MainActivity.class);
        startActivity(intent);
    }

}

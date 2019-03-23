package com.example.newtodoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SingleTask extends AppCompatActivity {

    private String task_key=null;
    private TextView singleTask;
    private TextView singleTime;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        task_key=getIntent().getExtras().getString("TaskId");
        singleTask = (TextView) findViewById(R.id.singleTask);
        singleTime = (TextView) findViewById(R.id.singleTime);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Tasks");

        mDatabase.child(task_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String task_title = (String) dataSnapshot.child("name").getValue();
                String task_time = (String) dataSnapshot.child("date").getValue();

                singleTask.setText(task_title);
                singleTime.setText(task_time);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void deleteButtonClicked(View view){
        mDatabase.child(task_key).removeValue();
        Intent intent=new Intent(SingleTask.this,MainActivity.class);
        startActivity(intent);
    }
}

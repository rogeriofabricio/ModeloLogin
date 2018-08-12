package br.com.rnsolucoesweb.modelologin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class StartActivity extends AppCompatActivity {

    private ListView lv;
    private FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        lv = (ListView)findViewById(R.id.listView);
        Query query = FirebaseDatabase.getInstance().getReference().child("student").child("str0098");
        FirebaseListOptions<Student> options = new FirebaseListOptions.Builder<Student>()
                .setLayout(R.layout.activity_student)
                .setLifecycleOwner(StartActivity.this)
                .setQuery(query, Student.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView stdID = v.findViewById(R.id.studentID);
                TextView course = v.findViewById(R.id.course);
                TextView program = v.findViewById(R.id.program);
                TextView pin = v.findViewById(R.id.PIN);

                Student std = (Student) model;
                stdID.setText(std.getStudentID().toString());
                course.setText(std.getCourse().toString());
                program.setText(std.getLevel().toString());
                pin.setText(std.getPin().toString());
            }
        };

        lv.setAdapter(adapter);

        //TODO Logout e manter logado quando retorna ao app
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

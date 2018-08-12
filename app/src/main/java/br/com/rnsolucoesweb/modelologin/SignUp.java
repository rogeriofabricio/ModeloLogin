package br.com.rnsolucoesweb.modelologin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import br.com.rnsolucoesweb.modelologin.Student;

public class SignUp extends AppCompatActivity {

//    private FirebaseAuth auth;
    EditText stdID;
    EditText pin;
    EditText courseName;
    EditText level;
    private Student student;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        auth = FirebaseAuth.getInstance();
//
        stdID = (EditText)findViewById(R.id.studentID);
        pin = (EditText)findViewById(R.id.pin);
        courseName = (EditText)findViewById(R.id.courseName);
        level = (EditText)findViewById(R.id.levelProgram);

        student = new Student();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Student");
    }

    public void btnRegistre_click(View view) {

        student.setStudentID(stdID.getText().toString());
        student.setCourse(courseName.getText().toString());
        student.setPin(pin.getText().toString());
        student.setLevel(level.getText().toString());

//        ref.child("studentID").setValue(stdID.getText().toString());
//        ref.child("course").setValue(courseName.getText().toString());
//        ref.child("pin").setValue(pin.getText().toString());
//        ref.child("level").setValue(level.getText().toString());

        ref.child(student.getStudentID()).setValue(student);




//        auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(SignUp.this, "Conta Criada Com Sucesso.", Toast.LENGTH_LONG).show();
//                    finish();
//                } else {
//                    Toast.makeText(SignUp.this, "Falha ao Criar Conta.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}

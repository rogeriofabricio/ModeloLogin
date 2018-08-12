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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText studentID;
    private EditText pin;
    private DatabaseReference ref;
    private String strID;
    private String PIN;

    //private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentID = (EditText)findViewById(R.id.studentID);
        pin = (EditText)findViewById(R.id.pin);

        ref = FirebaseDatabase.getInstance().getReference().child("Student");
        //auth = FirebaseAuth.getInstance();
    }

    public void btnLogin_click(View view) {

        //Recebe os dados do email e senha para autenticação
        strID = studentID.getText().toString();
        PIN = pin.getText().toString();

        try {

            ref.child(strID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Student student = dataSnapshot.getValue(Student.class);
                    if (PIN.equals(student.getPin())) {
                        Toast.makeText(MainActivity.this, "Logado com Sucesso...", Toast.LENGTH_LONG).show();
                        Intent startActivity = new Intent(MainActivity.this, StartActivity.class);
                        startActivity(startActivity);
                    } else {
                        Toast.makeText(MainActivity.this, "Falha ao logar...", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } catch(Exception ex) {
            Toast.makeText(MainActivity.this, "Estudante não existe...", Toast.LENGTH_LONG).show();

            ex.printStackTrace();
        }


//        auth.signInWithEmailAndPassword(mEmail, mePassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                if (task.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Logado com Sucesso...", Toast.LENGTH_LONG).show();
//                    //Segue para activity Principal
//                    Intent startActivity = new Intent(MainActivity.this, StartActivity.class);
//                    startActivity(startActivity);
//                } else {
//                    Toast.makeText(MainActivity.this, "Login Falhou...", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    public void btnRegister_click(View view) {

        //Segue para activity de registro de nova conta
        Intent register = new Intent(MainActivity.this, SignUp.class);
        startActivity(register);
    }
}

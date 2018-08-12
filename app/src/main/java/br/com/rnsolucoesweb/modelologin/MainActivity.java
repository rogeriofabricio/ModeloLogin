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

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
    }

    public void btnLogin_click(View view) {

        //Recebe os dados do email e senha para autenticação
        String mEmail = email.getText().toString();
        String mePassword = password.getText().toString();
        auth.signInWithEmailAndPassword(mEmail, mePassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Logado com Sucesso...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Falhou...", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void btnRegister_click(View view) {

        //Segue para activity de registro de nova conta
        Intent register = new Intent(MainActivity.this, SignUp.class);
        startActivity(register);
    }
}

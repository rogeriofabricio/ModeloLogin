package br.com.rnsolucoesweb.modelologin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        
    }
    public void onClick(View v) {
        if (v.getId() == R.id.button_sign_out) {
            FirebaseAuth fAuth = FirebaseAuth.getInstance();
            fAuth.signOut();
            finish();
        }
    }
}

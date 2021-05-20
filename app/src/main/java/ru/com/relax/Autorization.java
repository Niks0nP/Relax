package ru.com.relax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Autorization extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    EditText password, email;
    Button login_button, registration_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login);
        login_button.setOnClickListener(this);
        registration_button = findViewById(R.id.registration);
        registration_button.setOnClickListener(this);



    }
    public void onClick(View view){
        if(view.getId() == R.id.login){
            signing(email.getText().toString(), password.getText().toString());
        }
        else if(view.getId() == R.id.registration){
            registration(email.getText().toString(), password.getText().toString());
        }

    }

    public void signing(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Авторизация успешна", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Авторизация провалена", Toast.LENGTH_LONG).show();
                }
            }


        });
    }

    public void registration(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Autorization.this, "Регистрация успешна", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Autorization.this, "Регистрация провалена", Toast.LENGTH_LONG).show();

            }
        });
    }


}
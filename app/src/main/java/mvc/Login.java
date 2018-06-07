package mvc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import classes.Entidades.Usuarios;
import fragments.Sorteios;
import startprogramy.studio.com.startprogramy.MainActivity;
import startprogramy.studio.com.startprogramy.R;
import startprogramy.studio.com.startprogramy.Start;

public class Login extends AppCompatActivity {



    Button btnCadastrar;
    private EditText emailLogin;
    private EditText senhaLogin;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;




    RelativeLayout activity_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailLogin = (EditText) findViewById(R.id.emailLogin);
        senhaLogin = (EditText) findViewById(R.id.senhaLogin);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            usuarios = new Usuarios();
            usuarios.setEmail(emailLogin.getText().toString());
            usuarios.setSenha(senhaLogin.getText().toString());
            validarCadastro();
            }
        });

    }


    private void validarCadastro(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),usuarios.getSenha()).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"Cadastrado com sucesso!",Toast.LENGTH_LONG).show();

                    abrirSorteios();

            }

            }
        });

        }

        public void abrirSorteios(){
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);

        }

    }



package usuario.movil.notas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity implements View.OnClickListener {
    private EditText Name;
    private EditText Password;

    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.TXTUser);
        Password = (EditText)findViewById(R.id.TXTPass);

        Login = (Button)findViewById(R.id.BTNIniciarSesion);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("12345"))){
            Intent intent = new Intent(login.this, principal.class);
            startActivity(intent);
        }else{
            Toast.makeText(login.this, "Verifica los datos ingresados",Toast.LENGTH_SHORT).show();;

        }


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onClick(View view) {

    }
}

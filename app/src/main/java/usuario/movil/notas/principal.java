package usuario.movil.notas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class principal extends Activity {

    Button registrar, mostrar, salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        registrar= (Button)findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                Intent registro = new Intent(principal.this, registro.class);
                startActivity(registro);

            }
        });
        mostrar= (Button)findViewById(R.id.mostrar);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(principal.this, resultado.class);
                startActivity(mostrar);

            }
        });

        salir= (Button)findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(principal.this, login.class);
                startActivity(salir);

            }
        });


    }
    @Override
    public void onBackPressed (){
        moveTaskToBack(true);
    }

}
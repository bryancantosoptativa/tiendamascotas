package usuario.movil.notas;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends Activity {

    EditText tipo, concepto,valor, mascota,  fechacita, fechacancelar;
     TextView valo;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mascota = (EditText)findViewById(R.id.mascota);
        tipo = (EditText)findViewById(R.id.tipo);
        concepto = (EditText)findViewById(R.id.concepto);
        valo = (TextView)findViewById(R.id.valor);
        fechacita = (EditText)findViewById(R.id.fechacita);
        fechacancelar = (EditText)findViewById(R.id.fechacancelar);
        guardar = (Button)findViewById(R.id.guardar);



        final HelperDB helperbd = new HelperDB(getApplicationContext());




        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mascota.getText().toString();
                if (TextUtils.isEmpty(name)){
                    mascota.setError("Complete el campo");
                    mascota.requestFocus();
                    return;
                }

                String name2 = tipo.getText().toString();
                if (TextUtils.isEmpty(name2)){
                    tipo.setError("Complete el campo");
                    tipo.requestFocus();
                    return ;
                }
                String name4 = concepto.getText().toString();
                if (TextUtils.isEmpty(name4)){
                    concepto.setError("Complete el campo");
                    concepto.requestFocus();
                    return ;

                }


                String name1 = fechacita.getText().toString();
                if (TextUtils.isEmpty(name1)){
                    fechacita.setError("Complete el campo");
                    fechacita.requestFocus();
                    return;
                }

                String name3 = fechacancelar.getText().toString();
                if (TextUtils.isEmpty(name3)){
                    fechacancelar.setError("Complete el campo");
                    fechacancelar.requestFocus();
                    return ;
                }



                Integer dat = 10;
                    SQLiteDatabase db = helperbd.getWritableDatabase();
                    ContentValues valores = new ContentValues();
                    valores.put("institucion",mascota.getText().toString());
                    valores.put("cedula",tipo.getText().toString());
                    valores.put("nombre", concepto.getText().toString());
                    valores.put("materia", dat);
                    valores.put("nota1", fechacita.getText().toString());
                    valores.put("nota2", fechacancelar.getText().toString());



                    Long IdGuardado = db.insert("parametros", "mascota",  valores);
                    Toast.makeText(getApplicationContext(),
                            "Registro guardado: ",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registro.this, principal.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


            }
        });
    }
}

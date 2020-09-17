package usuario.movil.notas;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultado extends Activity {
EditText txtborrar;
Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        final HelperDB helperbd = new HelperDB(getApplicationContext());

        final TextView tvdatos = (TextView) findViewById(R.id.TV_DatosMostrar);
        tvdatos.setText(helperbd.LeerTodo());


    }
}

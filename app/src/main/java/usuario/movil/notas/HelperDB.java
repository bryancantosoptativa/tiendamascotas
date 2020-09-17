package usuario.movil.notas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HelperDB extends SQLiteOpenHelper {


    private static final String TABLE_CONTROL_DATOS =
            "CREATE TABLE  parametros (institucion text, cedula text, nombre text, materia text, nota1 text,  nota2 text, promedio text, dato text)";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MiBasedeDatos.db";


    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CONTROL_DATOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS parametros");
        onCreate(db);

    }


    public String LeerTodo() {

        String consulta = "";
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM parametros", null);
        if (cursor.moveToFirst()){
            do{

                String nombre = cursor.getString(cursor.getColumnIndex("institucion"));
                String tipo = cursor.getString(cursor.getColumnIndex("cedula"));
                String concepto = cursor.getString(cursor.getColumnIndex("nombre"));
                String valor = cursor.getString(cursor.getColumnIndex("materia"));
                String fecha1 = cursor.getString(cursor.getColumnIndex("nota1"));
                String fecha2 = cursor.getString(cursor.getColumnIndex("nota2"));



                consulta +=  "Nombre mascota : " + nombre + "\n" + "Tipo de mascota : " + tipo + "\n" + "Concepto : " + concepto + "\n" + "Valor a pagar : " + valor + "\n" + "Fecha de cita : " + fecha1 + "\n"  + "Fecha de cancelar : " + fecha2 +  "\n"   +  "\n" +  "\n";
            }while (cursor.moveToNext());
        }
        return consulta;
    }
}

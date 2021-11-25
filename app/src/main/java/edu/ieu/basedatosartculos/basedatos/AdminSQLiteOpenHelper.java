package edu.ieu.basedatosartculos.basedatos;

import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String CODIGO = "codigo";
    public static final String DESCRIPCION = "descripcion";
    public static final String PRECIO = "precio";
    public static final String TABLA = "articulos";
    public static final String BASE_DATOS = "administracion";
    //CONSTANTE SQL
    private static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLA+"(" +
            CODIGO + "int primary key," +
            DESCRIPCION+ "text,"+
            PRECIO+"real);";

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name){
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

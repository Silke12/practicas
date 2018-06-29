package com.example.sonia.uf1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BBDDcustom extends SQLiteOpenHelper {

    //creamos dos variables estaticas para enumerar la base de datos y darle nombre
    public static final String DATABASE_NAME = "MIBASEDEDATOS.db";
    public int DATABASE_VERSION = 1;

    Context ctx;
    public MyBBDD(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx=context;
    }


    //definimos una tabla con columnas en la base de datos
    public static final String TABLE_NAME = "TablaPalabras";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE = "nombre";
    public static final String COLUMNA_SPECIALITY = "speciality";
    //creamos la tabla y especificamos su contenido

    private static final String SQL_CREAR = "create table "
            + TABLE_NAME + "(" + COLUMNA_ID
            + " integer primary key autoincrement, " + COLUMNA_NOMBRE
            + " text not null" + COLUMNA_SPECIALITY + "text not null" );

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        //teniendo sql crear solo nos falta usarlo
        sqLiteDatabase.execSQL(SQL_CREAR);

        ContentValues values = new ContentValues();
        values.put(PalabrasContract.PalabrasEntry.NAME, "DINOSAURIO ");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "OVIPERO PREHISTORICO");
        values.put(PalabrasContract.PalabrasEntry.NAME, "MACACO ");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "MAMIFERO CONTEMPORANEO ");
        values.put(PalabrasContract.PalabrasEntry.NAME, "BALLENA");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "MAMIFERO CONTEMPORANEO");
        values.put(PalabrasContract.PalabrasEntry.NAME, "AGUILA ");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "OVIPERO CONTEMPORANEO");
        values.put(PalabrasContract.PalabrasEntry.NAME, "MAMUT");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "MAMIFERO PREHISTORICO");
        values.put(PalabrasContract.PalabrasEntry.NAME, "SARCOSUCHUS");
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, "OVIPERO PREHISTORICO ");
        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    public long savePalabras(Palabras palabras) {
        SQLiteDatabase sqLiteDatabasesave = getWritableDatabase();

        return sqLiteDatabasesave.insert(
                PalabrasContract.PalabrasEntry.TABLE_NAME,
                null
                palabras.toContentValues());

    }



    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists DATABASE_NAME");
        onCreate(db);
    }



    BBDDcustom MyBBDD;
    SQLiteDatabase db;

    public void abrir(){
    MyBBDD =new BBDDcustom(ctx);
    db=MyBBDD.getWritableDatabase();
    }
    public void cerrada(){
        db.close();
    }

}



package com.example.sonia.uf1;

import android.content.ContentValues;

import java.util.UUID;

public class Palabras  {

    private String id;
    private String name;
    private String specialty;

    public Palabras(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PalabrasContract.PalabrasEntry.ID, id);
        values.put(PalabrasContract.PalabrasEntry.NAME, name);
        values.put(PalabrasContract.PalabrasEntry.SPECIALTY, specialty);


        return values;
    }
}

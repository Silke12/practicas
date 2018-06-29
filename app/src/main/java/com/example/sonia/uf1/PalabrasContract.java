package com.example.sonia.uf1;

import android.provider.BaseColumns;

public class PalabrasContract {
    public static abstract class PalabrasEntry implements BaseColumns {
        public static final String TABLE_NAME ="palabra";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SPECIALTY = "specialty";
    }
}

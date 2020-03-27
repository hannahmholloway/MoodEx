package com.example.myfirstapp.database;

import android.provider.BaseColumns;




public class DatabaseContract {

    /** DatabaseContract stores the following information related to the database:
     *  tables names
     *  columns names
     *  */

    private DatabaseContract(){
    }

    public static class Database implements BaseColumns {

        //TABLE NAMES (there are 2 tables).
        public static final String DAYS_TABLE_NAME = "days_table";
        public static final String STATES_TABLE_NAME = "states_table";

        //SHARED COLUMNS, name of COLUMNS
        public static final String STATE_ID = "state_id";

        //DAYS TABLE, name of COLUMNS
        public static final String DAY_ID = "day_id";
        public static final String DAY = "day";
        public static String COMMENT = "comment";

        //STATE TABLE, name of COLUMNS
        public static final String STATE = "state";

    }
}


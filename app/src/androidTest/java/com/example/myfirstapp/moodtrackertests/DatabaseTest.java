package com.example.myfirstapp.moodtrackertests;

import android.database.Cursor;
import android.support.test.rule.ActivityTestRule;

import android.database.Cursor;
import android.support.test.rule.ActivityTestRule;

import com.example.myfirstapp.activitiesmoodstate.MainActivity;
import com.example.myfirstapp.database.DatabaseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DatabaseTest {

    /** This RULE specifies that this activity is launched */
    //Always make this public
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    DatabaseHelper dbH;
    Cursor mCursor;

    @Before
    public void setUp() throws Exception {

        /** With this, we get the context! */
        mActivity = mainActivityActivityTestRule.getActivity();

        dbH = new DatabaseHelper(mActivity);
        mCursor = dbH.getAllDataFromDaysTable();

    }

    @Test
    public void testDatabaseTest() {

        dbH.updateDataDays(3,"",1);
        dbH.updateDataDays(4,"Position 2",2);
        dbH.updateDataDays(3,"",3);
        dbH.updateDataDays(5,"",4);
        dbH.updateDataDays(2,"",5);
        dbH.updateDataDays(1,"Position 6",6);
        dbH.updateDataDays(2,"",7);
        dbH.updateDataDays(3,"",8);
        dbH.updateDataDays(4,"",9);
        dbH.updateDataDays(2,"",10);
        dbH.updateDataDays(1,"",11);
        dbH.updateDataDays(2,"Position 12",12);
        dbH.updateDataDays(5,"",13);
        dbH.updateDataDays(4,"",14);
        dbH.updateDataDays(3,"",15);
        dbH.updateDataDays(5,"",16);

    }

    @After
    public void tearDown() throws Exception {

        dbH = null;
        mCursor = null;

        /** With this, we nullify the activity (that was launched) */
        mActivity = null;



    }
}

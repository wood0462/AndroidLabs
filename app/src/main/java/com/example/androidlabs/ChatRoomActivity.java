package com.example.androidlabs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.androidlabs.MyOpener.VERSION_NUM;

public class ChatRoomActivity extends AppCompatActivity {

    private List<Messages> sms;
    private ChatListAdapter chatListAdapter;
    private ListView chatList;
    private EditText messageEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        MyOpener opener = new MyOpener(this);
        SQLiteDatabase db = opener.getWritableDatabase();

        chatListAdapter = new ChatListAdapter(this);
        sms = new ArrayList<>();

        chatListAdapter.setChatList(sms);
        Cursor results = db.query(false, opener.TABLE_NAME, new String[]{opener.COL_ID, opener.COL_SENT, opener.COL_TEXT}, null, null, null, null, null, null);

        printCursor(results);

        results.moveToFirst();
        while (!results.isAfterLast()) {
            String sText = results.getString(results.getColumnIndex(opener.COL_TEXT));
            String sSent = results.getString(results.getColumnIndex(opener.COL_SENT));
            String sId = results.getString(results.getColumnIndex(opener.COL_ID));
            results.moveToNext();

            int iId = Integer.parseInt(sId);
            int iSent = Integer.parseInt(sSent);
            boolean bSent = makeBoolean(iSent);

            Messages messages = new Messages(sText, bSent, iId);

            sms.add(messages);

        }



        chatList = findViewById(R.id.mylist);
        chatList.setAdapter(chatListAdapter);

        messageEditText = findViewById(R.id.mess);

        findViewById(R.id.send).setOnClickListener(b -> {
            ContentValues cValue = new ContentValues();


            final String text = messageEditText.getText().toString();
            final Messages message = new Messages(text, true, 0);


            cValue.put(opener.COL_TEXT, text);
            cValue.put(opener.COL_SENT, true);

            db.insert(MyOpener.TABLE_NAME, "null", cValue);

            sms.add(message);
            messageEditText.setText("");


        });

        findViewById(R.id.receive).setOnClickListener(b -> {
            ContentValues cValue = new ContentValues();

            final String text = messageEditText.getText().toString();
            final Messages message = new Messages(text, false, 0);


            cValue.put(opener.COL_TEXT, text);
            cValue.put(opener.COL_SENT, false);

            db.insert(MyOpener.TABLE_NAME, "null", cValue);

            sms.add(message);
            messageEditText.setText("");


        });

    }

    public boolean makeBoolean(int isSent){

        if(isSent != 0) {

           return true;

        }else{

            return false;
        }
    }

    public void printCursor(Cursor c){




        Log.i("Database Version", "Database Version: " + MyOpener.VERSION_NUM);
        Log.i("Number of Columns", "Cursor Columns: " + c.getColumnCount());



        for(int i = 0; i < c.getColumnIndex(MyOpener.COL_TEXT) + 1;i++) {
            Log.i("Name of Columns", "Column Names: " + c.getColumnName(i));
        }//this is just a test


            Log.i("Results in cursor", "Cursor Results: " + c.getCount());


        c.moveToFirst();
       while (!c.isAfterLast()) {
            String sText = c.getString(c.getColumnIndex(MyOpener.COL_TEXT));
            String sSent = c.getString(c.getColumnIndex(MyOpener.COL_SENT));
            String sId = c.getString(c.getColumnIndex(MyOpener.COL_ID));
            c.moveToNext();

            int iId = Integer.parseInt(sId);
            int iSent = Integer.parseInt(sSent);
            boolean bSent = makeBoolean(iSent);

            Log.i("Each Row of Results", "Cursor Row Results: " + "\n" + sId + "\n" + "Sent: " + bSent + "\n" + sText + "\n" );
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

package com.example.androidlabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomActivity extends AppCompatActivity {

    private List<Messages> sms;
    private ChatListAdapter chatListAdapter;

    private ListView chatList;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        chatListAdapter = new ChatListAdapter(this);
        sms = new ArrayList<>();
        chatListAdapter.setChatList(sms);

        chatList = findViewById(R.id.mylist);
        chatList.setAdapter(chatListAdapter);

        messageEditText = findViewById(R.id.mess);

        findViewById(R.id.send).setOnClickListener(b -> {
            final String text = messageEditText.getText().toString();
            final Messages message = new Messages(text, true);

            sms.add(message);
            messageEditText.setText("");
        });

        findViewById(R.id.receive).setOnClickListener(b -> {
            final String text = messageEditText.getText().toString();
            final Messages message = new Messages(text, false);

            sms.add(message);
            messageEditText.setText("");

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

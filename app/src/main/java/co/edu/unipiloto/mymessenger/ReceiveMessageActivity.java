package co.edu.unipiloto.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        updateMessageHistory();
    }

    public void onSendMessage(View view) {
        EditText editText = (EditText)findViewById(R.id.message2);
        String messageText = editText.getText().toString();
        MessageStorage.messages.add("PLANEADOR :   " + messageText);
        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
        updateMessageHistory();
    }

    private void updateMessageHistory() {
        TextView messageHistoryView = (TextView)findViewById(R.id.messageHistory);
        StringBuilder messagesText = new StringBuilder();
        for(String message : MessageStorage.messages) {

            messagesText.append(message).append("\n");

        }
        messageHistoryView.setText(messagesText.toString());
    }
}

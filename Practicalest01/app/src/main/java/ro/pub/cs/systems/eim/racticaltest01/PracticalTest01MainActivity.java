package ro.pub.cs.systems.eim.racticaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        Button pressMeButton = (Button) findViewById(R.id.left_button);
        Button pressMeTooButton = (Button) findViewById(R.id.right_button);

        pressMeButton.setOnClickListener(buttonClickListener);
        pressMeTooButton.setOnClickListener(buttonClickListener);
    }
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Button pressMeButton = (Button) findViewById(R.id.left_button);
            Button pressMeTooButton = (Button) findViewById(R.id.right_button);
            EditText leftEditText = (EditText) findViewById(R.id.left_edit_text);
            EditText rightEditText = (EditText) findViewById(R.id.right_edit_text);

            int leftTextNumber = Integer.valueOf(leftEditText.getText().toString());
            int rightTextNumber = Integer.valueOf(rightEditText.getText().toString());
            if (pressMeButton.isPressed()) {
                leftTextNumber++;
                leftEditText.setText(String.valueOf(leftTextNumber));
            } else if (pressMeTooButton.isPressed()) {
                rightTextNumber++;
                rightEditText.setText(String.valueOf(rightTextNumber));
            }
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText leftEditText = (EditText) findViewById(R.id.left_edit_text);
        EditText rightEditText = (EditText) findViewById(R.id.right_edit_text);
        savedInstanceState.putString(Constants.LEFT_COUNT, leftEditText.getText().toString());
        savedInstanceState.putString(Constants.RIGHT_COUNT, rightEditText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
            EditText leftEditText = (EditText) findViewById(R.id.left_edit_text);
            leftEditText.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
        }
        if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
            EditText rightEditText = (EditText) findViewById(R.id.right_edit_text);
            rightEditText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
        }
    }

}

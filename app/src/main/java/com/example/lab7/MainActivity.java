package com.example.lab7;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameEditText = findViewById(R.id.name);
        Button submitButton = findViewById(R.id.submit_button);
        TextView messageTextView = findViewById(R.id.message_text_view);

        submitButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString();
            if (name.length() > 10) {
                messageTextView.setText("Length is too long");
            } else {
                messageTextView.setText("Accepted");
            }
        });
    }

}

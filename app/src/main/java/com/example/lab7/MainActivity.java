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
    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText;
    private TextView messageTextView;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        messageTextView = findViewById(R.id.message_text_view);
        submitButton = findViewById(R.id.submit_button);
        messageTextView = findViewById(R.id.message_text_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        submitButton.setOnClickListener(view -> {
            String FirstName = firstNameEditText.getText().toString();
            String LastName = lastNameEditText.getText().toString();

            if (FirstName.length() > 10 || LastName.length() > 10) {
                messageTextView.setText("Length is too long");
            } else {
                messageTextView.setText("Accepted");
            }
        });
    }

}

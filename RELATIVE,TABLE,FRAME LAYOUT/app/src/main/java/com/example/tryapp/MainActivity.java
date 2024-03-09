import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private TableLayout tableLayout;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        tableLayout = findViewById(R.id.tableLayout);
        frameLayout = findViewById(R.id.frameLayout);

        // Example: Add a TextView to FrameLayout
        // You can customize this part based on your requirements
        TextView textViewInFrameLayout = new TextView(this);
        textViewInFrameLayout.setText("This is inside FrameLayout");
        frameLayout.addView(textViewInFrameLayout);

        // Add more code here as needed
    }
}

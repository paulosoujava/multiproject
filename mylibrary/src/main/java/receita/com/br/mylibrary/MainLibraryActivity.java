package receita.com.br.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainLibraryActivity extends AppCompatActivity {

    private TextView joker;
    public static  final String KEY_FOR_JOKE = "com.udacity.gradle.builditbigger.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        joker = findViewById(R.id.myjoke);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                joker.setText(extras.getString( KEY_FOR_JOKE)  );
            }
        }

    }
}

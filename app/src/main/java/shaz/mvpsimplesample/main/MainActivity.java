package shaz.mvpsimplesample.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import shaz.mvpsimplesample.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_EXTRA_USER_NAME = "tag:/userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }

        if (getIntent().hasExtra(TAG_EXTRA_USER_NAME)) {
            ((AppCompatTextView) findViewById(R.id.userName)).setText("Welcome " + getIntent().getStringExtra(TAG_EXTRA_USER_NAME));
        }
    }
}

package com.example.serializable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class NextActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        toolbar = findViewById(R.id.toolbar_next);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);

        Objects.requireNonNull(
                getSupportActionBar()
        ).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> finish());

        if (getIntent().hasExtra("Address")) {

            Address address = (Address) getIntent().
                    getSerializableExtra("Address");

            TextView textView = findViewById(R.id.textView_next);
            if (address != null) {
                textView.setText(address.toString());
            }
        }
    }
}
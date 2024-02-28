package com.example.serializable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);

        Objects.requireNonNull(
                getSupportActionBar()
        ).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> finish());

        Address[] addresses = new Address[] {
                new Address(
                        "Claudio Verdi",
                        "via Roma",
                        35,
                        "81055",
                        "Santa Maria Capua Vetere",
                        "CE"
                ),
                new Address(
                        "Claudio Rossi",
                        "via Roma",
                        35,
                        "81055",
                        "Santa Maria Capua Vetere",
                        "CE"
                ),
                new Address(
                        "Giorgio Verdi",
                        "via Roma",
                        35,
                        "81055",
                        "Santa Maria Capua Vetere",
                        "CE"
                )
        };

        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(addresses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
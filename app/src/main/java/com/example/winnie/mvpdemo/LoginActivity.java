package com.example.winnie.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.winnie.mvvm.DataBindActivity;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View {

    private EditText saveView;
    private TextView saveButton;
    private TextView loadButton;
    private TextView loadView;

    private LoginInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveView = findViewById(R.id.edit_data);
        saveButton = findViewById(R.id.save_button);
        loadButton = findViewById(R.id.load_button);
        loadView = findViewById(R.id.load_data);

        presenter = new LoginPresenter(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateData(saveView.getText().toString());
                saveView.setText("");
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadData();
            }
        });

        findViewById(R.id.mvvm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DataBindActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(String data) {
        loadView.setText(data);
    }
}

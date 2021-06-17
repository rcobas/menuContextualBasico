package com.example.menucontextualbasico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTexto;
    LinearLayout layoutInterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTexto = (TextView) findViewById(R.id.tvTexto);
        layoutInterno = (LinearLayout) findViewById(R.id.layoutinterno);

        registerForContextMenu(tvTexto);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Elige un color de fondo: ");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.colorRojo:

                layoutInterno.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.colorAzul:
                layoutInterno.setBackgroundColor(Color.rgb(0,0, 255));
                break;
            case R.id.colorVerde:
                layoutInterno.setBackgroundColor(Color.rgb(0,255,0));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
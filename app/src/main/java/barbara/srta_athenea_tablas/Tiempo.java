package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class Tiempo extends Activity {

    private Button guardar;
    private Spinner lista;
    private long tiempo;
    private Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        guardar = (Button) findViewById(R.id.guardarTiempo);
        lista = (Spinner) findViewById(R.id.spinner);
        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        guardar.setTypeface(TF);
        ArrayList<String> listado = new ArrayList<>();
        listado.add("2 minutos");
        listado.add("3 minutos");
        listado.add("4 minutos");
        listado.add("5 minutos");
        adaptador = (new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado));
        lista.setAdapter((SpinnerAdapter) adaptador);
        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        long t = preferences.getLong("tiempo", 120000);
        if (t == 120000) {
            lista.setSelection(0);
        }
        if (t == 180000) {
            lista.setSelection(1);
        }
        if (t == 240000) {
            lista.setSelection(2);
        }
        if (t == 300000) {
            lista.setSelection(3);
        }


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = lista.getSelectedItem().toString();
                if (posicion.equals("2 minutos")) {
                    tiempo = 120000;
                }
                if (posicion.equals("3 minutos")) {
                    tiempo = 180000;
                }
                if (posicion.equals("4 minutos")) {
                    tiempo = 240000;
                }
                if (posicion.equals("5 minutos")) {
                    tiempo = 300000;
                }

                SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putLong("tiempo", tiempo);
                editor.commit();
                finish();
            }
        });
    }

}

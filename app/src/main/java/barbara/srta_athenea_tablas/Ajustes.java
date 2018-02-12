package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ajustes extends Activity {
    private TextView intrucciones;
    private Button nombre;
    private Button tiempo;
    private Intent n, t, anun;
    private Button quitarAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        intrucciones = (TextView) findViewById(R.id.txtInstrucciones);
        nombre = (Button) findViewById(R.id.modificaNombre);
        tiempo = (Button) findViewById(R.id.modificaContra);
        quitarAnuncios =(Button) findViewById(R.id.quitar_anun);

        n = new Intent(this, Nombre.class);
        t = new Intent(this, Tiempo.class);
        anun =new Intent(this, Anuncios.class);

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        intrucciones.setTypeface(TF);
        nombre.setTypeface(TF);
        tiempo.setTypeface(TF);
        quitarAnuncios.setTypeface(TF);

        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(n);
            }
        });

        tiempo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(t);

            }
        });
        quitarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(anun);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(this, Menu.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }



}

package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Portada extends Activity {

    private Intent menu;
    private String nombre;
    private TextView textoHola;
    private Button entrar, btnNombre;
    private RelativeLayout fondoPantalla;
    private EditText txtNombre;
    private boolean canExitApp = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        menu = new Intent(this, Menu.class);
        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);
        textoHola = (TextView) findViewById(R.id.texto);
        entrar = (Button) findViewById(R.id.botonEntrar);
        fondoPantalla = (RelativeLayout) findViewById(R.id.fondo);
        txtNombre = (EditText) findViewById(R.id.introdNombre);
        btnNombre = (Button) findViewById(R.id.botonNombre);

        txtNombre.setTypeface(TF);
        textoHola.setTypeface(TF);
        entrar.setTypeface(TF);
        btnNombre.setTypeface(TF);


        //recupero si es la primera vez que se utiliza
        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        nombre = preferences.getString("nombre", null);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(menu);
            }
        });
        //si es la primera vez presentacion
        if (nombre == null) {
            textoHola.setText(getResources().getString(R.string.presentacion));
            Handler h = new Handler();

            h.postDelayed(new Runnable() {
                public void run() {

                    textoHola.setText(getResources().getString(R.string.presentacion2));
                    btnNombre.setVisibility(View.VISIBLE);
                    txtNombre.setVisibility(View.VISIBLE);
                    btnNombre.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //cierro teclado virtual
                            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                            inputMethodManager.hideSoftInputFromWindow(txtNombre.getWindowToken(), 0);

                            if (txtNombre.getText().toString().length() >= 1) {
                                nombre = txtNombre.getText().toString();
                                fondoPantalla.setBackground(getResources().getDrawable(R.drawable.primera_pantalla));
                                textoHola.setText(getResources().getString(R.string.presentacion3) + " " + nombre);
                                entrar.setVisibility(View.VISIBLE);
                                btnNombre.setVisibility(View.INVISIBLE);
                                txtNombre.setVisibility(View.INVISIBLE);
                                SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString("nombre", nombre);
                                editor.commit();
                            }

                        }
                    });
                }

            }, 5000);


        }

        //sino es la primera vez bienvenida
        else {

            textoHola.setText(getResources().getString(R.string.hola) + " " + nombre);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                public void run() {
                    fondoPantalla.setBackground(getResources().getDrawable(R.drawable.primera_pantalla));
                    textoHola.setText(getResources().getString(R.string.empezar));
                    entrar.setVisibility(View.VISIBLE);
                }

            }, 3000);


        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (!canExitApp) {
            canExitApp = true;
            Toast.makeText(this, getString(R.string.salirDos), Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    canExitApp = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();

        }
    }
}

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
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {

    private Button btn_examenVoz, btn_examen, btn_practicar, reloj, todas_tablas, ajustes;
    private Intent menu2, ajus;
    private int contar;
    private String inDesafio ,inContra;
    private boolean canExitApp = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_examen = (Button) findViewById(R.id.examen);
        btn_examenVoz = (Button) findViewById(R.id.examenVoz);
        btn_practicar = (Button) findViewById(R.id.practica);
        reloj = (Button) findViewById(R.id.contraReloj);
        todas_tablas = (Button) findViewById(R.id.todo);
        ajustes = (Button) findViewById(R.id.ajustes);
        menu2 = new Intent(this, Menu2.class);
        ajus = new Intent(this, Ajustes.class);
        inContra = getResources().getString(R.string.informaContra);
        inDesafio = getResources().getString(R.string.informaDesafio);


        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        btn_examen.setTypeface(TF);
        btn_examenVoz.setTypeface(TF);
        btn_practicar.setTypeface(TF);
        reloj.setTypeface(TF);
        todas_tablas.setTypeface(TF);
        ajustes.setTypeface(TF);

        // se recupera si se superado mas de una tabla para activar los botones 3 y 4

        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        contar = 0;
        boolean tabla1 = preferences.getBoolean("tabla1", false);
        boolean tabla2 = preferences.getBoolean("tabla2", false);
        boolean tabla3 = preferences.getBoolean("tabla3", false);
        boolean tabla4 = preferences.getBoolean("tabla4", false);
        boolean tabla5 = preferences.getBoolean("tabla5", false);
        boolean tabla6 = preferences.getBoolean("tabla6", false);
        boolean tabla7 = preferences.getBoolean("tabla7", false);
        boolean tabla8 = preferences.getBoolean("tabla8", false);
        boolean tabla9 = preferences.getBoolean("tabla9", false);
        boolean tabla10 = preferences.getBoolean("tabla10", false);

        if (tabla1 == true) {
            contar = contar + 1;
        }
        if (tabla2 == true) {
            contar = contar + 1;
        }
        if (tabla3 == true) {
            contar = contar + 1;
        }
        if (tabla4 == true) {
            contar = contar + 1;
        }
        if (tabla5 == true) {
            contar = contar + 1;
        }
        if (tabla6 == true) {
            contar = contar + 1;
        }
        if (tabla7 == true) {
            contar = contar + 1;
        }
        if (tabla8 == true) {
            contar = contar + 1;
        }
        if (tabla9 == true) {
            contar = contar + 1;
        }
        if (tabla10 == true) {
            contar = contar + 1;
        }
        if (contar < 2) {
            reloj.setTextColor(getResources().getColor(R.color.desabilitado));

        }
        if (contar != 10) {
            todas_tablas.setTextColor(getResources().getColor(R.color.desabilitado));
        }

        //funcionalidad botones
        reloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(contar>=2) {
                    reloj.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                    siguiente(3);
                }
                else {

                    mensaje(inContra);
                }

            }
        });

            todas_tablas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(contar==10) {
                        todas_tablas.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                        siguiente(4);
                    }
                    else {

                        mensaje(inDesafio);
                    }
                }
            });


        btn_practicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_practicar.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                siguiente(1);

            }
        });
        btn_examen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_examen.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                siguiente(2);
            }
        });
        btn_examenVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_examenVoz.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                siguiente(5);
            }
        });
        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajustes.setTextColor(getResources().getColor(R.color.tizaAmarilla));
                startActivity(ajus);
                finish();
            }
        });
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
    public void siguiente(int tipo) {
        // tipo =1 practicar
        //tipo =2 examen
        //tipo = 3 contrareloj Se activa cuando se ha superado mas de una tabla en el examen
        //tipo = 4 todas las tablas. Se activa cuando se ha superado mas de una tabla en el examen
        //tipo = 5 examen reconocimiento de voz
        //tipo =6 Ajustes
        menu2.putExtra("tipo", tipo);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {

                startActivity(menu2);
                finish();
            }

        }, 40);


    }



public void mensaje(String mensaje){
    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
}}
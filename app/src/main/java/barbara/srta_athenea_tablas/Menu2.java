package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Menu2 extends Activity {

    private Intent panExamen, panPractica, pantallaSele;
    private ToggleButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10;
    private ImageButton comenzar;
    private boolean t1 = false, t2 = false, t3 = false, t4 = false, t5 = false, t6 = false, t7 = false, t8 = false, t9 = false, t10 = false;
    private ArrayList<Boolean> lista;
    private int panta;
    private Context contexto;
    private int contar;
    private Button instrucciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        //recupero datos****************************************************************
        Bundle bundle2 = getIntent().getExtras();
        panta = bundle2.getInt("tipo");


        //declaro****************************************************************
        lista = new ArrayList<>();
        comenzar = (ImageButton) findViewById(R.id.empezar);
        bt1 = (ToggleButton) findViewById(R.id.b1);
        bt2 = (ToggleButton) findViewById(R.id.b2);
        bt3 = (ToggleButton) findViewById(R.id.b3);
        bt4 = (ToggleButton) findViewById(R.id.b4);
        bt5 = (ToggleButton) findViewById(R.id.b5);
        bt6 = (ToggleButton) findViewById(R.id.b6);
        bt7 = (ToggleButton) findViewById(R.id.b7);
        bt8 = (ToggleButton) findViewById(R.id.b8);
        bt9 = (ToggleButton) findViewById(R.id.b9);
        bt10 = (ToggleButton) findViewById(R.id.b10);
        instrucciones = (Button)findViewById(R.id.insReloj);
        preferencias();

        if (panta == 1) {
            pantallaSele = new Intent(this, Practica.class);
        }
        if (panta == 2) {
            pantallaSele = new Intent(this, Pregunta.class);
        }
        if (panta == 3) {
            pantallaSele = new Intent(this, Pregunta.class);
            instrucciones.setVisibility(View.VISIBLE);
        }
        if (panta == 5) {
            pantallaSele = new Intent(this, PreguntaVoz.class);
        }
        if (panta == 4) {
            pantallaSele = new Intent(this, Pregunta.class);
            bt1.setChecked(true);
            t1 = true;
            bt1.setActivated(false);
            bt1.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt2.setChecked(true);
            t2 = true;
            bt2.setActivated(false);
            bt2.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt3.setChecked(true);
            t3 = true;
            bt3.setActivated(false);
            bt3.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt4.setChecked(true);
            t4 = true;
            bt4.setActivated(false);
            bt4.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt5.setChecked(true);
            t5 = true;
            bt5.setActivated(false);
            bt5.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt6.setChecked(true);
            t6 = true;
            bt6.setActivated(false);
            bt6.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt7.setChecked(true);
            t7 = true;
            bt7.setActivated(false);
            bt7.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt8.setChecked(true);
            t8 = true;
            bt8.setActivated(false);
            bt8.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt9.setChecked(true);
            t9 = true;
            bt9.setActivated(false);
            bt9.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            bt10.setChecked(true);
            t10 = true;
            bt10.setActivated(false);
            bt10.setTextColor(getResources().getColor(R.color.tizaAmarilla));
            siguiente();
        }


        bt1.setTypeface(TF);
        bt2.setTypeface(TF);
        bt3.setTypeface(TF);
        bt4.setTypeface(TF);
        bt5.setTypeface(TF);
        bt6.setTypeface(TF);
        bt7.setTypeface(TF);
        bt8.setTypeface(TF);
        bt9.setTypeface(TF);
        bt10.setTypeface(TF);
        instrucciones.setTypeface(TF);


        //funcionalidad****************************************************************



        instrucciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instrucciones.setVisibility(View.INVISIBLE);
            }
        });
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt1.isChecked() == true) {
                    compPractica(bt1);
                    bt1.setTextColor(getResources().getColor(R.color.tizaRja));
                    comenzar.setVisibility(View.VISIBLE);
                    t1 = true;


                }
                if (bt1.isChecked() == false) {
                    bt1.setTextColor(Color.WHITE);
                    t1 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt2.isChecked() == true) {
                    compPractica(bt2);
                    bt2.setTextColor(getResources().getColor(R.color.tizaRja));
                    t2 = true;
                    comenzar.setVisibility(View.VISIBLE);

                }
                if (bt2.isChecked() == false) {
                    bt2.setTextColor(Color.WHITE);
                    t2 = false;
                }

                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt3.isChecked() == true) {
                    compPractica(bt3);
                    bt3.setTextColor(getResources().getColor(R.color.tizaRja));
                    t3 = true;

                }
                if (bt3.isChecked() == false) {
                    bt3.setTextColor(Color.WHITE);
                    t3 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt4.isChecked() == true) {
                    compPractica(bt4);
                    bt4.setTextColor(getResources().getColor(R.color.tizaRja));
                    t4 = true;

                }
                if (bt4.isChecked() == false) {
                    bt4.setTextColor(Color.WHITE);
                    t4 = false;

                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt5.isChecked() == true) {
                    compPractica(bt5);
                    bt5.setTextColor(getResources().getColor(R.color.tizaRja));
                    t5 = true;

                }
                if (bt5.isChecked() == false) {
                    bt5.setTextColor(Color.WHITE);
                    t5 = false;
                }

                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt6.isChecked() == true) {
                    compPractica(bt6);
                    bt6.setTextColor(getResources().getColor(R.color.tizaRja));
                    t6 = true;

                }
                if (bt6.isChecked() == false) {
                    bt6.setTextColor(Color.WHITE);
                    t6 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt7.isChecked() == true) {
                    compPractica(bt7);
                    bt7.setTextColor(getResources().getColor(R.color.tizaRja));
                    t7 = true;

                }
                if (bt7.isChecked() == false) {
                    bt7.setTextColor(Color.WHITE);
                    t7 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt8.isChecked() == true) {
                    compPractica(bt8);
                    bt8.setTextColor(getResources().getColor(R.color.tizaRja));
                    t8 = true;

                }
                if (bt8.isChecked() == false) {
                    bt8.setTextColor(Color.WHITE);
                    t8 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt9.isChecked() == true) {
                    compPractica(bt9);
                    bt9.setTextColor(getResources().getColor(R.color.tizaRja));
                    t9 = true;

                }
                if (bt9.isChecked() == false) {
                    bt9.setTextColor(Color.WHITE);
                    t9 = false;

                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt10.isChecked() == true) {
                    compPractica(bt10);
                    bt10.setTextColor(getResources().getColor(R.color.tizaRja));
                    t10 = true;

                }
                if (bt10.isChecked() == false) {
                    bt10.setTextColor(Color.WHITE);
                    t10 = false;
                }
                if (comprobar() == true) {
                    comenzar.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void siguiente() {

        pantallaSele.putExtra("tabla1", t1);
        pantallaSele.putExtra("tabla2", t2);
        pantallaSele.putExtra("tabla3", t3);
        pantallaSele.putExtra("tabla4", t4);
        pantallaSele.putExtra("tabla5", t5);
        pantallaSele.putExtra("tabla6", t6);
        pantallaSele.putExtra("tabla7", t7);
        pantallaSele.putExtra("tabla8", t8);
        pantallaSele.putExtra("tabla9", t9);
        pantallaSele.putExtra("tabla10", t10);
        pantallaSele.putExtra("pantalla", panta);

        if (comprobar() == true) {
            startActivity(pantallaSele);
            finish();
        }


    }

    public boolean comprobar() {
        //se comprueba que se ha seleccionado una tabla
        int contar = 0;
        boolean haySele = false;
        lista.add(t1);
        lista.add(t2);
        lista.add(t3);
        lista.add(t4);
        lista.add(t5);
        lista.add(t6);
        lista.add(t7);
        lista.add(t8);
        lista.add(t9);
        lista.add(t10);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == true) {
                contar = contar + 1;
            }
        }
        lista.clear();
        if (contar >= 1) {
            haySele = true;
        }
        return haySele;
    }

    public void compPractica(ToggleButton b) {
        if (panta < 3 | panta == 5) {
            bt1.setChecked(false);
            bt2.setChecked(false);
            bt3.setChecked(false);
            bt4.setChecked(false);
            bt5.setChecked(false);
            bt6.setChecked(false);
            bt7.setChecked(false);
            bt8.setChecked(false);
            bt9.setChecked(false);
            bt10.setChecked(false);
            bt1.setTextColor(Color.WHITE);
            bt2.setTextColor(Color.WHITE);
            bt3.setTextColor(Color.WHITE);
            bt4.setTextColor(Color.WHITE);
            bt5.setTextColor(Color.WHITE);
            bt6.setTextColor(Color.WHITE);
            bt7.setTextColor(Color.WHITE);
            bt8.setTextColor(Color.WHITE);
            bt9.setTextColor(Color.WHITE);
            bt10.setTextColor(Color.WHITE);
            t1 = false;
            t2 = false;
            t3 = false;
            t4 = false;
            t5 = false;
            t6 = false;
            t7 = false;
            t8 = false;
            t9 = false;
            t10 = false;
            b.setChecked(true);
            b.setTextColor(getResources().getColor(R.color.tizaRja));

        }
    }

    public void preferencias() {


        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
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
        if (panta == 2) {
            if (tabla1 == true) {
                bt1.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla2 == true) {
                bt2.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla3 == true) {
                bt3.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla4 == true) {
                bt4.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla5 == true) {
                bt5.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla6 == true) {
                bt6.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla7 == true) {
                bt7.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla8 == true) {
                bt8.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla9 == true) {
                bt9.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
            if (tabla10 == true) {
                bt10.setBackgroundDrawable(getResources().getDrawable(R.drawable.estrella));
            }
        }
        if (panta == 3) {
            if (tabla1 == false) {
                bt1.setVisibility(View.INVISIBLE);
            }
            if (tabla2 == false) {
                bt2.setVisibility(View.INVISIBLE);
            }
            if (tabla3 == false) {
                bt3.setVisibility(View.INVISIBLE);
            }
            if (tabla4 == false) {
                bt4.setVisibility(View.INVISIBLE);
            }
            if (tabla5 == false) {
                bt5.setVisibility(View.INVISIBLE);
            }
            if (tabla6 == false) {
                bt6.setVisibility(View.INVISIBLE);
            }
            if (tabla7 == false) {
                bt7.setVisibility(View.INVISIBLE);
            }
            if (tabla8 == false) {
                bt8.setVisibility(View.INVISIBLE);
            }
            if (tabla9 == false) {
                bt9.setVisibility(View.INVISIBLE);
            }
            if (tabla10 == false) {
                bt10.setVisibility(View.INVISIBLE);
            }

        }
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

package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Practica extends Activity {
    private int tab;
    private static final String TAG = "MyTag";
    private TextView reT0;
    private TextView reT1;
    private TextView reT2;
    private TextView reT3;
    private TextView reT4;
    private TextView reT5;
    private TextView reT6;
    private TextView reT7;
    private TextView reT8;
    private TextView reT9;

    private float reT0x;
    private float reT1x;
    private float reT2x;
    private float reT3x;
    private float reT4x;
    private float reT5x;
    private float reT6x;
    private float reT7x;
    private float reT8x;
    private float reT9x;
    private float reT10x;

    private float reT0y;
    private float reT1y;
    private float reT2y;
    private float reT3y;
    private float reT4y;
    private float reT5y;
    private float reT6y;
    private float reT7y;
    private float reT8y;
    private float reT9y;
    private float reT10y;

    private TextView error;
    private TextView reT10;
    private TextView tabT0;
    private TextView tabT1;
    private TextView tabT2;
    private TextView tabT3;
    private TextView tabT4;
    private TextView tabT5;
    private TextView tabT6;
    private TextView tabT7;
    private TextView tabT8;
    private TextView tabT9;
    private TextView tabT10;
    private TextView cuaT0;
    private TextView cuaT1;
    private TextView cuaT2;
    private TextView cuaT3;
    private TextView cuaT4;
    private TextView cuaT5;
    private TextView cuaT6;
    private TextView cuaT7;
    private TextView cuaT8;
    private TextView cuaT9;
    private TextView cuaT10;
    private View cuaTV0;
    private View cuaTV1;
    private View cuaTV2;
    private View cuaTV3;
    private View cuaTV4;
    private View cuaTV5;
    private View cuaTV6;
    private View cuaTV7;
    private View cuaTV8;
    private View cuaTV9;
    private View cuaTV10;
    private ArrayList<Multiplicacion> tabla;
    private int contar = 0;

    private int modificarX = 50;
    private int modificarY = 50;
    ArrayList<Respuesta> listadoR;
    private PointF DownPT = new PointF();
    private PointF StartPT = new PointF();
    private boolean correcto = false;
    private Button b;
    private boolean tab1;
    private boolean tab2;
    private boolean tab3;
    private boolean tab4;
    private boolean tab5;
    private boolean tab6;
    private boolean tab7;
    private boolean tab8;
    private boolean tab9;
    private boolean tab10;
    private Intent terminar, i;
    private boolean canExitApp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);
        i = new Intent(this,Menu.class);
        Bundle bundle4 = getIntent().getExtras();
        tab1 = bundle4.getBoolean("tabla1");
        tab2 = bundle4.getBoolean("tabla2");
        tab3 = bundle4.getBoolean("tabla3");
        tab4 = bundle4.getBoolean("tabla4");
        tab5 = bundle4.getBoolean("tabla5");
        tab6 = bundle4.getBoolean("tabla6");
        tab7 = bundle4.getBoolean("tabla7");
        tab8 = bundle4.getBoolean("tabla8");
        tab9 = bundle4.getBoolean("tabla9");
        tab10 = bundle4.getBoolean("tabla10");
        tabla = new ArrayList<>();
        ArrayList<Integer> lista = new ArrayList<>();

        if (tab1 == true) {
            lista.add(1);
        }
        if (tab2 == true) {
            lista.add(2);
        }
        if (tab3 == true) {
            lista.add(3);
        }
        if (tab4 == true) {
            lista.add(4);
        }
        if (tab5 == true) {
            lista.add(5);
        }
        if (tab6 == true) {
            lista.add(6);
        }
        if (tab7 == true) {
            lista.add(7);
        }
        if (tab8 == true) {
            lista.add(8);
        }
        if (tab9 == true) {
            lista.add(9);
        }
        if (tab10 == true) {
            lista.add(10);
        }

        tabla = metodos.crear(lista);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empezar();


                //Una vez que se pincha en las instrucciones se da funcionalidad de arrastre

                reT0.setOnTouchListener(handlerMover);
                reT1.setOnTouchListener(handlerMover);
                reT2.setOnTouchListener(handlerMover);
                reT3.setOnTouchListener(handlerMover);
                reT4.setOnTouchListener(handlerMover);
                reT5.setOnTouchListener(handlerMover);
                reT6.setOnTouchListener(handlerMover);
                reT7.setOnTouchListener(handlerMover);
                reT8.setOnTouchListener(handlerMover);
                reT9.setOnTouchListener(handlerMover);
                reT10.setOnTouchListener(handlerMover);
            }
        });

        //muestra la pregunta
        tabT0 = (TextView) findViewById(R.id.text0);
        tabT1 = (TextView) findViewById(R.id.text1);
        tabT2 = (TextView) findViewById(R.id.text2);
        tabT3 = (TextView) findViewById(R.id.text3);
        tabT4 = (TextView) findViewById(R.id.text4);
        tabT5 = (TextView) findViewById(R.id.text5);
        tabT6 = (TextView) findViewById(R.id.text6);
        tabT7 = (TextView) findViewById(R.id.text7);
        tabT8 = (TextView) findViewById(R.id.text8);
        tabT9 = (TextView) findViewById(R.id.text9);
        tabT10 = (TextView) findViewById(R.id.text10);
        //muestra respuesta oculta
        cuaT0 = (TextView) findViewById(R.id.cu0);
        cuaT1 = (TextView) findViewById(R.id.cu1);
        cuaT2 = (TextView) findViewById(R.id.cu2);
        cuaT3 = (TextView) findViewById(R.id.cu3);
        cuaT4 = (TextView) findViewById(R.id.cu4);
        cuaT5 = (TextView) findViewById(R.id.cu5);
        cuaT6 = (TextView) findViewById(R.id.cu6);
        cuaT7 = (TextView) findViewById(R.id.cu7);
        cuaT8 = (TextView) findViewById(R.id.cu8);
        cuaT9 = (TextView) findViewById(R.id.cu9);
        cuaT10 = (TextView) findViewById(R.id.cu10);

        cuaTV0 = (TextView) findViewById(R.id.cu0);
        cuaTV1 = (TextView) findViewById(R.id.cu1);
        cuaTV2 = (TextView) findViewById(R.id.cu2);
        cuaTV3 = (TextView) findViewById(R.id.cu3);
        cuaTV4 = (TextView) findViewById(R.id.cu4);
        cuaTV5 = (TextView) findViewById(R.id.cu5);
        cuaTV6 = (TextView) findViewById(R.id.cu6);
        cuaTV7 = (TextView) findViewById(R.id.cu7);
        cuaTV8 = (TextView) findViewById(R.id.cu8);
        cuaTV9 = (TextView) findViewById(R.id.cu9);
        cuaTV10 = (TextView) findViewById(R.id.cu10);
        terminar = new Intent(this, Resultados.class);

        //respuestas movimiento

        reT0 = (TextView) findViewById(R.id.res0);
        reT1 = (TextView) findViewById(R.id.res1);
        reT2 = (TextView) findViewById(R.id.res2);
        reT3 = (TextView) findViewById(R.id.res3);
        reT4 = (TextView) findViewById(R.id.res4);
        reT5 = (TextView) findViewById(R.id.res5);
        reT6 = (TextView) findViewById(R.id.res6);
        reT7 = (TextView) findViewById(R.id.res7);
        reT8 = (TextView) findViewById(R.id.res8);
        reT9 = (TextView) findViewById(R.id.res9);
        reT10 = (TextView) findViewById(R.id.res10);


        //introduzco datos

        //pregunta
        tabT0.setText(tabla.get(0).toString());

        tabT1.setText(tabla.get(1).toString());
        tabT2.setText(tabla.get(2).toString());
        tabT3.setText(tabla.get(3).toString());
        tabT4.setText(tabla.get(4).toString());
        tabT5.setText(tabla.get(5).toString());
        tabT6.setText(tabla.get(6).toString());
        tabT7.setText(tabla.get(7).toString());
        tabT8.setText(tabla.get(8).toString());
        tabT9.setText(tabla.get(9).toString());
        tabT10.setText(tabla.get(10).toString());

        //respuesta oculta
        cuaT0.setText(String.valueOf(tabla.get(0).getResultado()));
        cuaT1.setText(String.valueOf(tabla.get(1).getResultado()));
        cuaT2.setText(String.valueOf(tabla.get(2).getResultado()));
        cuaT3.setText(String.valueOf(tabla.get(3).getResultado()));
        cuaT4.setText(String.valueOf(tabla.get(4).getResultado()));
        cuaT5.setText(String.valueOf(tabla.get(5).getResultado()));
        cuaT6.setText(String.valueOf(tabla.get(6).getResultado()));
        cuaT7.setText(String.valueOf(tabla.get(7).getResultado()));
        cuaT8.setText(String.valueOf(tabla.get(8).getResultado()));
        cuaT9.setText(String.valueOf(tabla.get(9).getResultado()));
        cuaT10.setText(String.valueOf(tabla.get(10).getResultado()));

        cuaT0.setBackgroundColor(Color.TRANSPARENT);
        cuaT1.setBackgroundColor(Color.TRANSPARENT);
        cuaT2.setBackgroundColor(Color.TRANSPARENT);
        cuaT3.setBackgroundColor(Color.TRANSPARENT);
        cuaT4.setBackgroundColor(Color.TRANSPARENT);
        cuaT5.setBackgroundColor(Color.TRANSPARENT);
        cuaT6.setBackgroundColor(Color.TRANSPARENT);
        cuaT7.setBackgroundColor(Color.TRANSPARENT);
        cuaT8.setBackgroundColor(Color.TRANSPARENT);
        cuaT9.setBackgroundColor(Color.TRANSPARENT);
        cuaT10.setBackgroundColor(Color.TRANSPARENT);

        // desordeno el array e introduzco los datos en los textos moviles
        Collections.shuffle(tabla);
        reT0.setText(String.valueOf(tabla.get(0).getResultado()));
        reT1.setText(String.valueOf(tabla.get(1).getResultado()));
        reT2.setText(String.valueOf(tabla.get(2).getResultado()));
        reT3.setText(String.valueOf(tabla.get(3).getResultado()));
        reT4.setText(String.valueOf(tabla.get(4).getResultado()));
        reT5.setText(String.valueOf(tabla.get(5).getResultado()));
        reT6.setText(String.valueOf(tabla.get(6).getResultado()));
        reT7.setText(String.valueOf(tabla.get(7).getResultado()));
        reT8.setText(String.valueOf(tabla.get(8).getResultado()));
        reT9.setText(String.valueOf(tabla.get(9).getResultado()));
        reT10.setText(String.valueOf(tabla.get(10).getResultado()));

        //tipo de letra
        reT0.setTypeface(TF);
        reT1.setTypeface(TF);
        reT2.setTypeface(TF);
        reT3.setTypeface(TF);
        reT4.setTypeface(TF);
        reT5.setTypeface(TF);
        reT6.setTypeface(TF);
        reT7.setTypeface(TF);
        reT8.setTypeface(TF);
        reT9.setTypeface(TF);
        reT10.setTypeface(TF);
        tabT0.setTypeface(TF);
        tabT1.setTypeface(TF);
        tabT2.setTypeface(TF);
        tabT3.setTypeface(TF);
        tabT4.setTypeface(TF);
        tabT5.setTypeface(TF);
        tabT6.setTypeface(TF);
        tabT7.setTypeface(TF);
        tabT8.setTypeface(TF);
        tabT9.setTypeface(TF);
        tabT10.setTypeface(TF);
        cuaT0.setTypeface(TF);
        cuaT1.setTypeface(TF);
        cuaT2.setTypeface(TF);
        cuaT3.setTypeface(TF);
        cuaT4.setTypeface(TF);
        cuaT5.setTypeface(TF);
        cuaT6.setTypeface(TF);
        cuaT7.setTypeface(TF);
        cuaT8.setTypeface(TF);
        cuaT9.setTypeface(TF);
        cuaT10.setTypeface(TF);
        b.setTypeface(TF);


    }


    View.OnTouchListener handlerMover = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            DownPT = new PointF();
            StartPT = new PointF();
            int eid = event.getAction();


            switch (eid) {
                case MotionEvent.ACTION_MOVE:
                    // Obtenemos la posicion actual del elemento
                    StartPT = new PointF(v.getX(), v.getY());

                    // Calculamos el desplazamiento
                    PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);

                    // Asignamos al elemento la posicion actual menos un valor que se define para
                    // que el elemento quede centrado con respecto a nuestro dedo.
                    v.setX((StartPT.x + mv.x) - modificarX);
                    v.setY((StartPT.y + mv.y) - modificarY);


                    break;
                case MotionEvent.ACTION_DOWN:
                    // Guardamos la posici??n inicial
                    DownPT.x = event.getX();
                    DownPT.y = event.getY();


                    break;
                case MotionEvent.ACTION_UP:
                    if (comprobar(v) == 11) {
                        finish();
                        terminar.putExtra("practica", true);
                        startActivity(terminar);
                    } else {
                        if (correcto == false) {
                            cancelar(v);
                        }
                    }

                    break;
                default:
                    break;
            }
            return true;
        }
    };


    public int comprobar(View vista) {
        float posicion = vista.getY();
        TextView pos = (TextView) vista;

        int numero = Integer.parseInt(pos.getText().toString());


        for (int i = 0; i < listadoR.size(); i++) {
            if ((listadoR.get(i).getPosicion() - 50 < posicion) & (listadoR.get(i).getPosicion() + 50 > posicion) &
                    (listadoR.get(i).getResultado() == numero)) {
                pos.setText(null);
                pos.setVisibility(View.INVISIBLE);

                listadoR.get(i).getCuadro().setTextColor(getResources().getColor(R.color.tizaRja));
                listadoR.get(i).getCuadro().setBackgroundColor(getResources().getColor(R.color.transparente));
                listadoR.get(i).getPregunta().setTextColor(getResources().getColor(R.color.tizaRja));
                Log.i(TAG, "" + listadoR.get(i).getPregunta().getText());
                correcto = true;
                contar = contar + 1;
                break;
            } else {
                correcto = false;
            }
        }


        return contar;


    }

    public void cancelar(View vista) {
        int id = vista.getId();

        if (id == reT0.getId()) {

            vista.setX(reT0x);
            vista.setY(reT0y);
        }
        if (id == reT1.getId()) {

            vista.setX(reT1x);
            vista.setY(reT1y);
        }
        if (id == reT2.getId()) {

            vista.setX(reT2x);
            vista.setY(reT2y);
        }
        if (id == reT3.getId()) {

            vista.setX(reT3x);
            vista.setY(reT3y);
        }
        if (id == reT4.getId()) {

            vista.setX(reT4x);
            vista.setY(reT4y);
        }
        if (id == reT5.getId()) {

            vista.setX(reT5x);
            vista.setY(reT5y);
        }
        if (id == reT6.getId()) {

            vista.setX(reT6x);
            vista.setY(reT6y);
        }
        if (id == reT7.getId()) {

            vista.setX(reT7x);
            vista.setY(reT7y);
        }
        if (id == reT8.getId()) {

            vista.setX(reT8x);
            vista.setY(reT8y);
        }
        if (id == reT9.getId()) {

            vista.setX(reT9x);
            vista.setY(reT9y);
        }
        if (id == reT10.getId()) {

            vista.setX(reT10x);
            vista.setY(reT10y);
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
            startActivity(i);
        }
    }

    public void empezar() {
        b.setVisibility(View.INVISIBLE);
        //posicion original
        listadoR = new ArrayList<>();
        Respuesta r0 = new Respuesta(cuaTV0.getY(), Integer.parseInt(cuaT0.getText().toString()), cuaT0, tabT0);
        Respuesta r1 = new Respuesta(cuaTV1.getY(), Integer.parseInt(cuaT1.getText().toString()), cuaT1, tabT1);
        Respuesta r2 = new Respuesta(cuaTV2.getY(), Integer.parseInt(cuaT2.getText().toString()), cuaT2, tabT2);
        Respuesta r3 = new Respuesta(cuaTV3.getY(), Integer.parseInt(cuaT3.getText().toString()), cuaT3, tabT3);
        Respuesta r4 = new Respuesta(cuaTV4.getY(), Integer.parseInt(cuaT4.getText().toString()), cuaT4, tabT4);
        Respuesta r5 = new Respuesta(cuaTV5.getY(), Integer.parseInt(cuaT5.getText().toString()), cuaT5, tabT5);
        Respuesta r6 = new Respuesta(cuaTV6.getY(), Integer.parseInt(cuaT6.getText().toString()), cuaT6, tabT6);
        Respuesta r7 = new Respuesta(cuaTV7.getY(), Integer.parseInt(cuaT7.getText().toString()), cuaT7, tabT7);
        Respuesta r8 = new Respuesta(cuaTV8.getY(), Integer.parseInt(cuaT8.getText().toString()), cuaT8, tabT8);
        Respuesta r9 = new Respuesta(cuaTV9.getY(), Integer.parseInt(cuaT9.getText().toString()), cuaT9, tabT9);
        Respuesta r10 = new Respuesta(cuaTV10.getY(), Integer.parseInt(cuaT10.getText().toString()), cuaT10, tabT10);
        Log.i(TAG, tabT10.getText().toString());
        //Log.i(TAG,r10.getPregunta().getText().toString());
        listadoR.add(r0);
        listadoR.add(r1);
        listadoR.add(r2);
        listadoR.add(r3);
        listadoR.add(r4);
        listadoR.add(r5);
        listadoR.add(r6);
        listadoR.add(r7);
        listadoR.add(r8);
        listadoR.add(r9);
        listadoR.add(r10);
        reT0x = reT0.getX();
        reT1x = reT1.getX();
        reT2x = reT2.getX();
        reT3x = reT3.getX();
        reT4x = reT4.getX();
        reT5x = reT5.getX();
        reT6x = reT6.getX();
        reT7x = reT7.getX();
        reT8x = reT8.getX();
        reT9x = reT9.getX();
        reT10x = reT10.getX();

        reT0y = reT0.getY();
        reT1y = reT1.getY();
        reT2y = reT2.getY();
        reT3y = reT3.getY();
        reT4y = reT4.getY();
        reT5y = reT5.getY();
        reT6y = reT6.getY();
        reT7y = reT7.getY();
        reT8y = reT8.getY();
        reT9y = reT9.getY();
        reT10y = reT10.getY();


    }
}

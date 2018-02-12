package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureLibrary;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Pregunta extends Activity implements View.OnClickListener {
    private static final String TAG = "MyTag";
    private ImageView borra;
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
    private ArrayList<Integer> lista;
    private TextView primer;
    private TextView result;
    private int numeroAleatorio1;
    private int numeroAleatorio2;
    private int total;
    private GestureLibrary libreria;
    private int contarCorrecto = 0;
    private int contarIncorrecto = 0;
    private int contar;
    private int incorrecto = 0;
    private ArrayList<Multiplicacion> listaTablas;
    ArrayList<Integer> numerosAleatorios;
    private int posicion = 0;
    private Intent resultados;
    private Multiplicacion actual;
    private Button t0;
    private Button t1;
    private Button t2;
    private Button t3;
    private Button t4;
    private Button t5;
    private Button t6;
    private Button t7;
    private Button t8;
    private Button t9;
    private ImageView check;
    private Button instrucciones;
    private Intent pregunta;
    private int tabla;
    private int modificarX = 50;
    private int modificarY = 50;
    private PointF DownPT = new PointF();
    private PointF StartPT = new PointF();
    private long firstClickTime;
    private int panta;
    private TextView crono;
    private Button btn_insturcciones;
    private int preguntas;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1;
    private String tiempo;
    private Intent i;
    private long tiempoCuenta;
    private boolean canExitApp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        pregunta = new Intent(this, Instrucciones.class);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        i = new Intent(this,Menu.class);
        // libreria = GestureLibraries.fromRawResource(this,R.raw.gestures);
        // if(!libreria.load()){
        //  finish();
        // }
        //  GestureOverlayView gesturesView =(GestureOverlayView)findViewById(R.id.gestures);
        //  gesturesView.addOnGesturePerformedListener(this);

        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        tiempoCuenta = preferences.getLong("tiempo", 120000);


        Bundle bundle3 = getIntent().getExtras();
        tab1 = bundle3.getBoolean("tabla1");
        tab2 = bundle3.getBoolean("tabla2");
        tab3 = bundle3.getBoolean("tabla3");
        tab4 = bundle3.getBoolean("tabla4");
        tab5 = bundle3.getBoolean("tabla5");
        tab6 = bundle3.getBoolean("tabla6");
        tab7 = bundle3.getBoolean("tabla7");
        tab8 = bundle3.getBoolean("tabla8");
        tab9 = bundle3.getBoolean("tabla9");
        tab10 = bundle3.getBoolean("tabla10");
        panta = bundle3.getInt("pantalla");

        //declaro****************************************************************

        primer = (TextView) findViewById(R.id.primero);
        crono = (TextView) findViewById(R.id.cronome);
        result = (TextView) findViewById(R.id.resultado);
        resultados = new Intent(this, Resultados.class);
        t0 = (Button) findViewById(R.id.tec0);
        t1 = (Button) findViewById(R.id.tec1);
        t2 = (Button) findViewById(R.id.tec2);
        t3 = (Button) findViewById(R.id.tec3);
        t4 = (Button) findViewById(R.id.tec4);
        t5 = (Button) findViewById(R.id.tec5);
        t6 = (Button) findViewById(R.id.tec6);
        t7 = (Button) findViewById(R.id.tec7);
        t8 = (Button) findViewById(R.id.tec8);
        t9 = (Button) findViewById(R.id.tec9);

        borra = (ImageView) findViewById(R.id.borrador);
        check = (ImageView) findViewById(R.id.imageCheck);
        btn_insturcciones = (Button) findViewById(R.id.btn);
        primer.setTypeface(TF);
        result.setTypeface(TF);
        t0.setTypeface(TF);
        t1.setTypeface(TF);
        t2.setTypeface(TF);
        t3.setTypeface(TF);
        t4.setTypeface(TF);
        t5.setTypeface(TF);
        t6.setTypeface(TF);
        t7.setTypeface(TF);
        t8.setTypeface(TF);
        t9.setTypeface(TF);
        crono.setTypeface(TF);
        btn_insturcciones.setTypeface(TF);


        lista = new ArrayList<>();
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
        tabla = lista.get(0);
        tablas();
        aleatorio();


        if (panta == 3) {

                if (tiempoCuenta == 120000) {
                    btn_insturcciones.setText(getResources().getString(R.string.informa_crono2));
                }
                if (tiempoCuenta == 180000) {
                    btn_insturcciones.setText(getResources().getString(R.string.informa_crono3));
                }
                if (tiempoCuenta == 240000) {
                    btn_insturcciones.setText(getResources().getString(R.string.informa_crono4));
                }
                if (tiempoCuenta == 300000) {
                    btn_insturcciones.setText(getResources().getString(R.string.informa_crono5));
                }

            btn_insturcciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //cuando se pincha el boton comienza la cuenta atras

                    new CountDownTimer(tiempoCuenta, 1000) {

                        public void onTick(long milisegundoActual) {
                            int tie = (int) milisegundoActual / 1000;
                            int minutos = tie / 60;
                            int segundos = tie % 60;


                            String miS = String.valueOf(minutos);
                            String seS = String.valueOf(segundos);


                            if (minutos < 10) {
                                miS = "0" + minutos;
                            }
                            if (segundos < 10) {
                                seS = "0" + segundos;
                            }

                            crono.setText(miS + ":" + seS);
                        }

                        public void onFinish() {

                            int faltan = preguntas - (contarCorrecto + incorrecto);

                            if (faltan != 0) {
                                incorrecto = incorrecto + faltan;

                            }

                            resultados.putExtra("incorrecto", incorrecto);
                            resultados.putExtra("preguntas", preguntas);
                            resultados.putExtra("practica", false);
                            startActivity(resultados);
                            finish();
                        }
                    }.start();
                    btn_insturcciones.setVisibility(View.INVISIBLE);
                }
            });


        }


        if (panta == 2) {
            crono.setVisibility(View.INVISIBLE);
            btn_insturcciones.setVisibility(View.INVISIBLE);
            startActivity(pregunta);
        }
        if (panta == 4) {
            crono.setVisibility(View.VISIBLE);
            btn_insturcciones.setVisibility(View.VISIBLE);
            btn_insturcciones.setText(getResources().getString(R.string.informa_desafio));
            btn_insturcciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new CountDownTimer(120000, 1000) {

                        public void onTick(long milisegundoActual) {
                            int tie = (int) milisegundoActual / 1000;
                            int minutos = tie / 60;
                            int segundos = tie % 60;


                            String miS = String.valueOf(minutos);
                            String seS = String.valueOf(segundos);


                            if (minutos < 10) {
                                miS = "0" + minutos;
                            }
                            if (segundos < 10) {
                                seS = "0" + segundos;
                            }

                            crono.setText(miS + ":" + seS);
                        }

                        public void onFinish() {
                            preguntas = listaTablas.size();
                            int faltan = preguntas - (contarCorrecto + incorrecto);

                            if (faltan != 0) {
                                incorrecto = incorrecto + faltan;

                            }

                            resultados.putExtra("incorrecto", incorrecto);
                            resultados.putExtra("preguntas", preguntas);
                            resultados.putExtra("practica", false);
                            resultados.putExtra("desafio", true);
                            startActivity(resultados);
                            finish();
                        }
                    }.start();
                    btn_insturcciones.setVisibility(View.INVISIBLE);
                }
            });


        }


        borra.setOnTouchListener(handlerMover);
       /* borra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

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




    View.OnTouchListener handlerMover = new View.OnTouchListener() {

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
                    if (280 < (StartPT.x + mv.x) & (StartPT.x + mv.x) < 400 & 175 < (StartPT.y + mv.y) & 300 > (StartPT.y + mv.y)) {
                        result.setText(null);
                    }


                    break;
                case MotionEvent.ACTION_DOWN:
                    // Guardamos la posici??n inicial
                    DownPT.x = event.getX();
                    DownPT.y = event.getY();


                    break;
                case MotionEvent.ACTION_UP:

                    //volver posicion original
                    borra.setY(57);
                    borra.setX(24);

                    break;
                default:
                    break;
            }
            return true;
        }
    };


    //crea un array con todas las tablas que ha de preguntar, genera un array con las posiciones en las que ha de preguntar si se pregunta mas de
    //1 tabla se limita a 20 el numero de preguntas;
    public void tablas() {
        listaTablas = metodos.crear(lista);
        Collections.shuffle(listaTablas);
        if (listaTablas.size() >= 20) {
            int tama = listaTablas.size() - 1;
            for (int i = tama; i > 19; i--) {
                listaTablas.remove(i);
            }
        }
        // Log.i(TAG, "numero preguntas " + listaTablas.size());
    }

    public void aleatorio() {

        if (posicion <= listaTablas.size() - 1) {
            actual = listaTablas.get(posicion);
            primer.setText(actual.toString());

            posicion = posicion + 1;
            //Log.i(TAG, "posicion" + posicion);

        } else {
            preguntas = listaTablas.size();
            resultados.putExtra("preguntas", preguntas);
            resultados.putExtra("incorrecto", incorrecto);
            resultados.putExtra("tabla", tabla);
            resultados.putExtra("practica", false);
            if (panta == 4) {
                resultados.putExtra("desafio", true);
            } else {
                resultados.putExtra("desafio", false);
            }

            startActivity(resultados);

            finish();
        }

    }

    public void comprobar() {
        total = actual.getResultado();
        //compruebo si hay texto
        if (result.getText().length() > 0) {
             String t =result.getText().toString();
             boolean esNumero=true;
             //si el texto es un numero
            for(int i=0;i<t.length();i++) {

                if(Character.isDigit(t.charAt(i))==false){
                    esNumero=false;
                    break;
            }
            }
            int res = Integer.parseInt(result.getText().toString());
            //si es un numero se continua
            if(esNumero==true){
            if (total == res) {


                contarCorrecto = contarCorrecto + 1;

                check.setVisibility(View.VISIBLE);

                Log.i(TAG, " correcto" + contarCorrecto);

                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    public void run() {
                        aleatorio();
                        check.setVisibility(View.INVISIBLE);
                        result.setText(null);


                    }

                }, 1000);

            } else {
                result.setText(null);
                contarIncorrecto = contarIncorrecto + 1;

                result.setText(String.valueOf(total));
                result.setTextColor(getResources().getColor(R.color.tizaRja));

                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    public void run() {
                        incorrecto = incorrecto + 1;
                        result.setTextColor(getResources().getColor(R.color.blanco));
                        result.setText(null);
                        aleatorio();

                    }

                }, 2000);


            }}


        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tec0:
                insertar("0");
                break;
            case R.id.tec1:
                insertar("1");
                break;
            case R.id.tec2:
                insertar("2");
                break;
            case R.id.tec3:
                insertar("3");
                break;
            case R.id.tec4:
                insertar("4");
                break;
            case R.id.tec5:
                insertar("5");
                break;
            case R.id.tec6:
                insertar("6");
                break;
            case R.id.tec7:
                insertar("7");
                break;
            case R.id.tec8:
                insertar("8");
                break;
            case R.id.tec9:
                insertar("9");
                break;
            case R.id.ok:
                comprobar();
                break;


        }
    }

    public void insertar(String numero) {
        if (result.getText().toString().length() > 0) {

            result.setText(result.getText().toString() + numero);

        } else {
            result.setText(numero);
        }
    }

}


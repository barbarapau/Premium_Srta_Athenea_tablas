package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.GestureLibrary;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class PreguntaVoz extends Activity {
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

    private ImageView check;
    private Intent pregunta;
    private int tabla;
    private int modificarX = 50;
    private int modificarY = 50;
    private PointF DownPT = new PointF();
    private PointF StartPT = new PointF();
    private int panta;
    private ImageView botonMicrofono, ok;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1;
    private String tiempo;
    private Intent i;
    private boolean canExitApp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_voz);
        pregunta = new Intent(this, Instrucciones.class);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        i = new Intent(this, Menu.class);
        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);


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
        ok = (ImageButton) findViewById(R.id.ok_voz);
        primer = (TextView) findViewById(R.id.primero_voz);
        result = (TextView) findViewById(R.id.resultado_voz);
        resultados = new Intent(this, Resultados.class);
        pregunta = new Intent(this, Instrucciones2.class);

        borra = (ImageView) findViewById(R.id.borrador_voz);
        check = (ImageView) findViewById(R.id.imageCheck_voz);
        botonMicrofono = (ImageView) findViewById(R.id.btnMicro);
        primer.setTypeface(TF);
        result.setTypeface(TF);


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
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });


        //muestro instrucciones

        botonMicrofono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Lanzamos el reconoimiento de voz
                reconocimientoVoz();

            }
        });


        borra.setOnTouchListener(handlerMover);

        startActivity(pregunta);
    }

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
                    if (208 < (StartPT.x + mv.x) & (StartPT.x + mv.x) < 271 & 198 < (StartPT.y + mv.y) & 222 > (StartPT.y + mv.y)) {
                        result.setText(null);
                    }
                    Log.i(TAG, "posicion X" + (StartPT.x + mv.x));
                    Log.i(TAG, "posicion y" + (StartPT.y + mv.y));


                    break;
                case MotionEvent.ACTION_DOWN:
                    // Guardamos la posici??n inicial
                    DownPT.x = event.getX();
                    DownPT.y = event.getY();


                    break;
                case MotionEvent.ACTION_UP:

                    //volver posicion original
                    borra.setY(20);
                    borra.setX(20);

                    break;
                default:
                    break;
            }
            return true;
        }
    };


    //crea un array con todas las tablas que ha de preguntar, genera un array con las posiciones en las que ha de preguntar
    public void tablas() {
        listaTablas = metodos.crear(lista);
        Collections.shuffle(listaTablas);


    }

    public void aleatorio() {

        if (posicion <= listaTablas.size() - 1) {
            actual = listaTablas.get(posicion);
            primer.setText(actual.toString());

            posicion = posicion + 1;
            Log.i(TAG, "posicion" + posicion);

        } else {

            resultados.putExtra("incorrecto", incorrecto);
            resultados.putExtra("tabla", tabla);
            resultados.putExtra("practica", false);
            startActivity(resultados);

            finish();
        }

    }

    public void comprobar() {
        total = actual.getResultado();
        if (result.getText().length() > 0) {
            int res = Integer.parseInt(result.getText().toString());
            if (total == res) {


                contarCorrecto = contarCorrecto + 1;
                aleatorio();
                check.setVisibility(View.VISIBLE);

                // Log.i(TAG," correcto"+contarCorrecto);
                result.setText(null);
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    public void run() {

                        check.setVisibility(View.INVISIBLE);
                        result.setText(null);


                    }

                }, 1000);

            } else {
                result.setText(null);
                contarIncorrecto = contarIncorrecto + 1;
                if (contarIncorrecto == 2) {
                    result.setText(String.valueOf(total));
                    contarIncorrecto = 0;

                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        public void run() {
                            incorrecto = incorrecto + 1;

                            result.setText(null);
                            aleatorio();

                        }

                    }, 2000);

                }
            }


        }

    }


    private void reconocimientoVoz() {

        // Definición del intent para realizar en análisis del mensaje
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Indicamos el modelo de lenguaje para el intent
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Definimos el mensaje que aparecerá
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Diga, Resultado ...");
        // Lanzamos la actividad esperando resultados
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    //Recogemos los resultados del reconocimiento de voz
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Si el reconocimiento a sido bueno
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            //El intent nos envia un ArrayList aunque en este caso solo
            //utilizaremos la pos.0
            ArrayList<String> matches = data.getStringArrayListExtra
                    (RecognizerIntent.EXTRA_RESULTS);
            //Separo el texto en palabras.
            String[] palabras = matches.get(0).toString().split(" ");

            //Si la primera palabra es resultado
            //if (palabras[0].equals("resultado")) {
            String numero = palabras[0];
            if (numero.equals("cuatro")) {
                numero = "4";
            }
            //controlo que solo entienda numeros
            for (int i = 0; i <= 100; i++) {
                if (numero.equals(String.valueOf(i))) {
                    result.setText(numero.toString());
                    break;
                }
            }


        }
    }

}


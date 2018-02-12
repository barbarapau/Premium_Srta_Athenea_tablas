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
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Resultados extends Activity {

    private InterstitialAd mInterstitialAd;
    private TextView txtIncorrecto;
    private RelativeLayout fond;
    private Button sigui;
    private int fallos;
    private Context contexto;
    private int porcentajeError;
    private Intent i;
    private boolean desafio;
    private TextView nombre, diplo, texDiplo;
    private static final String TAG = "MyTag";
    private String texto1;
    private String texto2;
    private String texto3;
    private String texto4;
    private String texto5;
    private String textoSele=null, nom;
    private boolean anuncios;
    private boolean muestra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        //cargo anuncio

        // Initialize the Mobile Ads SDK.

        MobileAds.initialize(this, "ca-app-pub-3132149477087366~6965320736");

        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        //anuncio prueba
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId("ca-app-pub-3132149477087366/4726754335");



        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(i);
            }
        });

        startGame();
        //tipo de letra *******************************

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        String font_path2 = "font/angelina_fuente.ttf";
        Typeface TF2 = Typeface.createFromAsset(getAssets(), font_path2);

        txtIncorrecto = (TextView) findViewById(R.id.errores);
        sigui = (Button) findViewById(R.id.siguienteResultados);
        fond = (RelativeLayout) findViewById(R.id.fondo);
        nombre = (TextView) findViewById(R.id.nombreNino);
        Bundle b5 = getIntent().getExtras();
        boolean practica = b5.getBoolean("practica");
        fallos = b5.getInt("incorrecto");
        desafio = b5.getBoolean("desafio");
        int tabla = b5.getInt("tabla");
        int preguntas = b5.getInt("preguntas");
        String texto = null;
        txtIncorrecto.setTypeface(TF);
        nombre.setTypeface(TF2);
        sigui.setTypeface(TF);
        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        anuncios = preferences.getBoolean("codigoAnuncios",false);
        nom = preferences.getString("nombre", "alumno");

        i = new Intent(this, Menu.class);

        //si no hay fallos
        if (practica == true) {
            fond.setBackground(getResources().getDrawable(R.drawable.final_con_ninos));
            txtIncorrecto.setText(getResources().getString(R.string.buenTrabajo));
        } else {
            if (fallos == 0) {
                if (desafio == true) {


                    fond.setBackground(getResources().getDrawable(R.drawable.diploma));
                    nombre.setText(nom);
                }

                fond.setBackground(getResources().getDrawable(R.drawable.terminarcorrecto));

                SharedPreferences.Editor editor = preferences.edit();
                switch (tabla) {
                    case 1:
                        editor.putBoolean("tabla1", true);
                        break;
                    case 2:
                        editor.putBoolean("tabla2", true);
                        break;
                    case 3:
                        editor.putBoolean("tabla3", true);
                        break;
                    case 4:
                        editor.putBoolean("tabla4", true);
                        break;
                    case 5:
                        editor.putBoolean("tabla5", true);
                        break;
                    case 6:
                        editor.putBoolean("tabla6", true);
                        break;
                    case 7:
                        editor.putBoolean("tabla7", true);
                        break;
                    case 8:
                        editor.putBoolean("tabla8", true);
                        break;
                    case 9:
                        editor.putBoolean("tabla9", true);
                        break;
                    case 10:
                        editor.putBoolean("tabla10", true);
                        break;
                }
                editor.commit();
            } else {
                fond.setBackground(getResources().getDrawable(R.drawable.final_con_ninos));
                if (desafio == true) {
                    texto = getResources().getString(R.string.texto_desafio) + " " + fallos + " " + getResources().getString(R.string.error);
                }
                if (preguntas == 20) {
                    porcentajeError = fallos / 2;
                }


                if (porcentajeError >= 5) {
                    texto = getResources().getString(R.string.erroresMas5) + " " + fallos + " " + getResources().getString(R.string.error);
                }
                if (porcentajeError < 5 & porcentajeError > 3) {
                    texto = getResources().getString(R.string.erroresMenos5) + " " + fallos + " " + getResources().getString(R.string.error);
                }
                if (porcentajeError <= 3 & fallos > 1) {
                    texto = getResources().getString(R.string.erroresMenos3) + " " + fallos + " " + getResources().getString(R.string.error);
                }
                if (fallos == 1) {
                    texto = getResources().getString(R.string.erroresMenos1) + " " + fallos + " " + getResources().getString(R.string.error);
                }

                txtIncorrecto.setText(texto);
            }
        }
            texto1= getResources().getString(R.string.tx1);
            texto2= getResources().getString(R.string.tx2);
            texto3= getResources().getString(R.string.tx3);
            texto4= getResources().getString(R.string.tx4);
            texto5 =getResources().getString(R.string.tx5);

            textoSele=null;
            ArrayList<String> l =new ArrayList<String>();
            l.add(texto1);
            l.add(texto2);
            l.add(texto3);
            l.add(texto4);
            l.add(texto5);
            int numAleatorio=(int)Math.floor(Math.random()*4+0);
            textoSele=l.get(numAleatorio);

            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                public void run() {

                    fond.setBackground(getResources().getDrawable(R.drawable.inicio_segunda));
                    txtIncorrecto.setText(nom+" "+textoSele);

                    sigui.setVisibility(View.VISIBLE);




                }

            },2500);

        sigui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    showInterstitial();



            }
        });
        startGame();

    }

    private void showInterstitial() {
        if(anuncios ==false) {

                // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            //startGame();
            finish();
            startActivity(i);
        }

    }


        else {
            finish();
            startActivity(i);
        }
    }

    private void startGame() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);

        }



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(getResources().getString(R.string.cerrar))
                    .setMessage(getResources().getString(R.string.textoCerrar))
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(i);
                        }
                    })
                    .show();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

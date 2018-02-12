package barbara.srta_athenea_tablas;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Anuncios extends Activity {
    private EditText codigo;
    private Button guardar;
    private final String  cod ="182900Z452W6a";
    private String correcto, error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        codigo = (EditText)findViewById(R.id.editCodigo);
        guardar =(Button) findViewById(R.id.guardarCodigo);

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);
        codigo.setTypeface(TF);
        guardar.setTypeface(TF);

        error = getResources().getString(R.string.codigoError);
        correcto = getResources().getString(R.string.codigoCorrecto);
        //codigo quitar anuncios 182900Z452W6a


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(codigo.getWindowToken(), 0);
                comprobar();


            }
        });


    }

    public void comprobar(){
        //cierro teclado virtual


        String insertado =codigo.getText().toString();
        if(insertado.equals(cod)){
            SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("codigoAnuncios",true);
            editor.commit();
            //muestro mensaje
            Toast.makeText(this, correcto, Toast.LENGTH_LONG).show();
            finish();

        }
        else{
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
            codigo.setText(null);
        }
    }

}

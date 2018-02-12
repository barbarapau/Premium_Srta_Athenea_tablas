package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Nombre extends Activity {

    private Button guar;
    private EditText nomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        guar = (Button) findViewById(R.id.guardarNombre);
        nomb = (EditText) findViewById(R.id.editNombre);

        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        guar.setTypeface(TF);
        nomb.setTypeface(TF);

        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String nom = preferences.getString("nombre", "alumno");
        if (nom.equals("alumno")) {

        } else {
            nomb.setText(nom);
        }

        guar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomb.getText().length() > 0) {
                    SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("nombre", nomb.getText().toString());
                    editor.commit();
                    finish();
                }
            }
        });
    }

}

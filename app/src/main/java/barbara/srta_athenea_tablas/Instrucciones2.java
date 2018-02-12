package barbara.srta_athenea_tablas;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrucciones2 extends Activity {
    private Button pregun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        pregun = (Button) findViewById(R.id.texto);
        pregun.setText(getResources().getString(R.string.instruccionesVoz));
        String font_path = "font/crayon_crumble.ttf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);
        pregun.setTypeface(TF);
        pregun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

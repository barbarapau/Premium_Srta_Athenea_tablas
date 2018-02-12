package barbara.srta_athenea_tablas;

import android.widget.TextView;

/**
 * Created by Yo on 13/01/2017.
 */
public class Respuesta {
    private float posicion;
    private int resultado;
    private TextView cuadro;
    private TextView pregunta;

    public Respuesta(float posicion, int resultado, TextView cuadro, TextView pregunta) {
        this.posicion = posicion;
        this.resultado = resultado;
        this.cuadro = cuadro;
        this.pregunta = pregunta;
    }

    public float getPosicion() {
        return posicion;
    }

    public TextView getPregunta() {
        return pregunta;
    }

    public void setPregunta(TextView pregunta) {
        this.pregunta = pregunta;
    }

    public void setPosicion(float posicion) {
        this.posicion = posicion;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public TextView getCuadro() {
        return cuadro;
    }

    public void setCuadro(TextView cuadro) {
        this.cuadro = cuadro;
    }
}


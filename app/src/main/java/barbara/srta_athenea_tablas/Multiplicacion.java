package barbara.srta_athenea_tablas;

/**
 * Created by Yo on 12/01/2017.
 */
public class Multiplicacion {
    private int multiplicando;
    private int multiplicador;
    private int resultado;

    public Multiplicacion(int multiplicando, int multiplicador, int resultado) {
        this.multiplicando = multiplicando;
        this.multiplicador = multiplicador;
        this.resultado = resultado;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getMultiplicando() {
        return multiplicando;
    }

    public void setMultiplicando(int multiplicando) {
        this.multiplicando = multiplicando;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        String t = null;

        if (multiplicando == 10) {
            if (multiplicador == 10) {
                t = multiplicando + "X " + multiplicador + "=";
            }
        }
        if (multiplicando == 10) {
            if (multiplicador != 10) {
                t = multiplicando + "X " + multiplicador + " =";
            }
        }

        if (multiplicador == 10) {
            if (getMultiplicando() != 10) {
                t = multiplicando + " X " + multiplicador + "=";
            }
        }
        if (multiplicador != 10) {
            if (getMultiplicando() != 10) {
                t = multiplicando + " X " + multiplicador + " =";
            }
        }
        return t;
    }
}


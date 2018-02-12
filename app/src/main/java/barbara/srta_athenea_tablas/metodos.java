package barbara.srta_athenea_tablas;

import java.util.ArrayList;

/**
 * Created by Yo on 12/01/2017.
 */
public class metodos {

    public static ArrayList<Multiplicacion> crear(ArrayList<Integer> listaTablas) {
        ArrayList<Multiplicacion> tablas = new ArrayList<>();
        boolean existe = false;
        int contar = 0;

        for (int z = 0; z < listaTablas.size(); z++) {
            for (int i = 0; i <= 10; i++) {
                int re = listaTablas.get(z) * i;
                tablas.add(new Multiplicacion(listaTablas.get(z), i, re));
            }

        }


        return tablas;

    }
}

import Objeto.Arma;
import Objeto.Armadura;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    int tipoSala;
    String texto;
    List<Enemigo> enemigos = new ArrayList<>();
    Arma arma;
    Armadura armadura;


    public Sala(int tipoSala) {
        this.tipoSala = tipoSala;

        switch (tipoSala) {
            case 1:
                texto = "El silencio solo interrumpido por el correr de un riachuelo te hace sentir la desaparición de tus heridas";

                break;
            case 2:
                texto = "Un enemigo se alza atemorizante frente a la salida de la habitación";
                Enemigo en = new Enemigo();
                enemigos.add(en);
                break;
            case 3:
                for (int i = 0; i < (int) (Math.random() * 3 + 2); i++) {
                    Enemigo ens = new Enemigo();
                    enemigos.add(ens);
                }
                texto = "Un grupo de " + enemigos.size() + " enemigos aparecen delante de ti, listos para atacar";
                break;
            case 4:
                texto = "Una humilde tienda se encuentra enfrente con oferta por un arma y armadura";
                armadura = new Armadura();
                arma = new Arma();
                break;
            default:
                break;
        }
    }

}















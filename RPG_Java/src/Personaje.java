import Objeto.Arma;
import Objeto.Armadura;

public class Personaje {
    int vida;
    int vidaMax;
    int atk;
    int def;
    float velMax;
    float vel;
    int dinero;
    Arma arma;
    Armadura armadura;


    public Personaje() {
        vidaMax = (int) (Math.random() * 25 + 25);
        vida = vidaMax;
        atk = (int) (Math.random() * 10 + 1);
        def = (int) (Math.random() * 10 + 1);
        vel = (int) (Math.random() * 10 + 3);
        velMax = vel;
        this.arma = new Arma();
        this.armadura = new Armadura();
        this.dinero = 50;
    }

    public int damage(Enemigo enemigo) {
        int damage = this.atk - enemigo.def + 5 + this.arma.getAtk();
        if (damage < 5) {
            damage = 5;
        }
        return damage;

    }
}

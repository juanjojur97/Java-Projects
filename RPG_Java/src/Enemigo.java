public class Enemigo {
    int vida;
    int atk;
    int def;
    float vel;

    public Enemigo() {
        vida = (int) (Math.random() * 25 + 1);
        atk = (int) (Math.random() * 5 + 1);
        def = (int) (Math.random() * 5 + 1);
        vel = (int) (Math.random() * 5 + 1);
    }

    public int damage(Personaje prota) {
        int damage = this.atk - prota.def + 5 - prota.armadura.getDef();
        if (damage < 5) {
            damage = 5;
        }
        return damage;
    }
}

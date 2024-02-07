package Objeto;

public class Arma extends Objeto {
    int atk;

    public Arma() {
        super(); //Método constructor
        this.atk = (int) (Math.random() * 5 + 1);
    }

    public int getAtk() { //Getter devuelve un atributo
        return atk;
    }

    public void setAtk(int atk) { //Setter le da un nuevo valor al atributo
        this.atk = atk;
    }

    public void desgaste() {
        if (this.getDuracion() != 0) {
            this.setDuracion(this.getDuracion() - 1);
        }
        if (this.duracion <= 0) {
            this.atk = 0;
        }
    }
}

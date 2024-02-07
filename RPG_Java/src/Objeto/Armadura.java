package Objeto;

public class Armadura extends Objeto {


    int def;

    public Armadura() {
        super();
        this.def = (int) (Math.random() * 5 + 1);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
    public void desgaste(){
        if (this.getDuracion() != 0) {
            this.setDuracion(this.getDuracion()-1);
        }

        if(this.duracion <= 0){
            this.def = 0;
        }
    }
}

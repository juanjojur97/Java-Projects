package Objeto;

public class Objeto {
    int valor;
    int peso;
    int duracion;
    public Objeto(){
        this.peso = (int)(Math.random()*1 + 0.1);
        this.valor = (int)(Math.random()*50+1);
        this.duracion = (int)(Math.random()*10+1);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void desgaste(){
        if (this.duracion <= 0){

        }
    }
}

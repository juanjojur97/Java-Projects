import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Personaje prota = new Personaje();

        System.out.println("Vida: " + prota.vida);
        System.out.println("Ataque: " + prota.atk);
        System.out.println("Defensa: " + prota.def);
        System.out.println("Velocidad: " + (int) prota.vel);
        System.out.println("Atk arma: " + (int) prota.arma.getAtk());
        System.out.println("Def armadura: " + (int) prota.armadura.getDef());

        sc.nextLine();
        int salasSuperadas = 0;

        while (prota.vida > 0) {
            System.out.println("");
            Sala sala = nuevaSala();
            System.out.println(sala.texto);
            switch (sala.tipoSala) {
                case 1:
                    salasSuperadas++;
                    prota.vida = prota.vidaMax;
                    System.out.println("Tu vida ha sido recuperada. " + prota.vida);
                    sc.nextLine();
                    System.out.println("Continúas a la siguiente habitación.");

                    sc.nextLine();
                    break;
                case 2:
                    unEnemigo(sc, prota, sala.enemigos.get(0));
                    if (prota.vida > 0) {
                        salasSuperadas++;
                        System.out.println("Has derrotado al enemigo");
                        System.out.println("Continúas a la siguiente habitación.");
                    } else {
                        System.out.println("Has sido derrotado");
                        break;
                    }
                    break;
                case 3:
                    while (sala.enemigos.size() > 0) {
                        unEnemigo(sc, prota, sala.enemigos.get(0));
                        sala.enemigos.remove(0);
                        if (prota.vida <= 0) {
                            System.out.println("Tu personaje ha sido derrotado");
                            break;
                        }
                        if (sala.enemigos.size() > 0) {
                            System.out.println("Enemigo derrotado. Preparate para el siguiente combate");
                        } else {
                            salasSuperadas++;
                            System.out.println("Conseguiste vencer. Avanzas al siguiente cuarto");

                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    salasSuperadas++;
                    compra(sc,sala,prota);
                    System.out.println("Continuas a la siguiente habitación");

                    break;
                default:
                    break;
            }
        }
        System.out.println("Has superado " + salasSuperadas + " habitaciones");
        sc.close();

    }

    public static Sala nuevaSala() {
        int tipoSala = (int) (Math.random() * 4 + 1);// Se puede acceder a sala 1, 2, 3, 4
        Sala sala = new Sala(tipoSala);
        return sala;
    }

    public static void unEnemigo(Scanner sc, Personaje prota, Enemigo enemigo) {
        while (enemigo.vida > 0 && prota.vida > 0) {
            double velAccion;
            if(prota.vel - prota.arma.getPeso() - prota.armadura.getPeso() <= 0){
                velAccion = 0.1;
            }else{
                velAccion = prota.vel - prota.arma.getPeso() - prota.armadura.getPeso();
            }
            if (velAccion > enemigo.vel) {
                enemigo.vida = enemigo.vida - prota.damage(enemigo);
                System.out.println("El enemigo recibe " + prota.damage(enemigo) + " puntos de daño.");
                prota.arma.desgaste();
                System.out.println("Duracion del arma: " + prota.arma.getDuracion());
                sc.nextLine();
                System.out.println("Vida restante del enemigo " + enemigo.vida);
                sc.nextLine();
                prota.vel = prota.vel / 2;
            } else {
                prota.vida = prota.vida - enemigo.damage(prota);
                System.out.println("Recibes " + enemigo.damage(prota) + " puntos de daño.");
                prota.armadura.desgaste();
                System.out.println("Duración de la armadura: " + prota.armadura.getDuracion());
                sc.nextLine();
                System.out.println("Vida restante del protagonista " + prota.vida);
                sc.nextLine();
                enemigo.vel = enemigo.vel / 2;
            }
        }
        prota.vel = prota.velMax;
    }

    public static void compra(Scanner sc, Sala sala, Personaje prota){
        System.out.println("Arma: ");
        System.out.println("   Atk     " + sala.arma.getAtk());
        System.out.println("   Precio " + sala.arma.getValor());
        System.out.println("");
        System.out.println("Armadura: ");
        System.out.println("   Def " + sala.armadura.getDef());
        System.out.println("   Precio " + sala.armadura.getValor());
        System.out.println("");
        System.out.println("Poción (Cura 20 de vida): ");
        System.out.println("Precio: 25");
        System.out.println("Tu dinero: " + prota.dinero);
        System.out.println("¿Que desea comprar?");
        String respuesta = sc.nextLine();

        if (respuesta.toUpperCase().contains("ARMADURA") && sala.armadura.getValor() <= prota.dinero){
            System.out.println("Has comprado la armadura");
            prota.armadura = sala.armadura;
            prota.dinero = prota.dinero - sala.armadura.getValor();
        }else if(respuesta.toUpperCase().contains("ARMA") && sala.arma.getValor() <= prota.dinero){
            System.out.println("Has comprado el arma");
            prota.arma = sala.arma;
            prota.dinero = prota.dinero - sala.arma.getValor();
        }else if (respuesta.toUpperCase().contains("POCION") && 25 <= prota.dinero){
            prota.dinero = prota.dinero - 25;
            prota.vida = prota.vida + 20;
            if (prota.vida > prota.vidaMax){
                prota.vida = prota.vidaMax;
            }
        }

    }
}


















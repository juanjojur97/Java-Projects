public class Pregunta {
    String texto;
    String respuesta;
    boolean acertada = false;
    public Pregunta(){
        String [] preguntas = {"¿Cuanto es 5 + 3?",
        "¿Cual es la capital de Francia?",
        "¿En que año gano la selección el mundial?",
        "¿Cual es el pais mas poblado del mundo?",
        "¿Cual es la montaña mas alta del mundo?",
        "¿Cuantas casillas tiene un tablero de ajedrez?"};
        String [] respuestas = {"8","Paris","2010","China","Everest","64"};
        int alAzar = (int)(Math.random()* preguntas.length);
        texto = preguntas[alAzar];
        respuesta = respuestas[alAzar];
    }
}

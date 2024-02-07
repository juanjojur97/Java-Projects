import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Test> tests = new ArrayList<>();

        for(int i = 0; i < 5 ; i++) {
            tests.add(new Test());
            for (int j = 0; j < 3; j++) {
                tests.get(i).preguntas.add(new Pregunta());
            }
        }
        System.out.println("");
    }
}

import java.util.Random;
import java.io.*;
import java.util.*;

public class Laberinto {

    private int ancho, alto;
    private char[][] laberinto; //creamos el lab con coordenadas x e y

    public Laberinto() {
        ancho = 10; //predeterminamos un tamaño de laberinto de 10x10
        alto = 10;
        this.laberinto = new char[ancho][alto];
        generar(ancho, alto);
    }

    public Laberinto(int x, int y) {
        this.ancho = x; // elegimos el tamaño del laberinto
        this.alto = y;
        this.laberinto = new char[ancho][alto];
        generar(ancho, alto);
    }

    //getters
    public char[][] getLaberinto() {
        return laberinto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    // METODOS USADOS POR LOS AGENTES
    public boolean Salida(int x, int y) {
        return laberinto[x][y] == 'S';
    }// verifica si una posición que se le pasa por parámetro es la salida

    public void Visitado(int x, int y) {
        if (laberinto[x][y] != 'S' && laberinto[x][y] != 'E') {
            laberinto[x][y] = '.';
        } // marca con puntos las posiciones que han sido visitadas
    }

    public void generar(int x, int y) { // podríamos pasarle por párametros en el main el alto y ancho
        this.ancho = x;                 // del laberinto que queremos generar
        this.alto = y;
        this.laberinto = new char[alto][ancho];
        Random rand = new Random();

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (i == 0 || i == alto - 1 || j == 0 || j == ancho - 1) {
                    laberinto[i][j] = '#';
                } else {
                    if (rand.nextBoolean()) { //genera un booleano con 50% de ser verdadero y 50% falso
                        laberinto[i][j] = ' '; // rellenamos el interior con espacios o #
                    } else {
                        laberinto[i][j] = '#';
                    }
                }
            }
        }
        laberinto[1][1] = 'E'; // Escribimos la entrada en el lugar correspondiente
        laberinto[alto - 2][ancho - 2] = 'S'; //A la salida le restamos 2 porque empezamos en 0 y le quitamos la pared
    }

    public void cargar(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            List<String> lineas = br.lines().toList(); // Leo todas las lineas

            if (lineas.isEmpty()) {
                throw new IOException("El archivo está vacío.");
            }

            this.alto = lineas.size();
            this.ancho = lineas.get(0).length(); // Mira la cantidad de carácteres de la primera fila
            this.laberinto = new char[alto][ancho];

            for (int i = 0; i < alto; i++) {
                laberinto[i] = lineas.get(i).toCharArray();// convierte cada fila en un array de caracteres
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el laberinto: " + e.getMessage(), e);
        }
    }


    public void Pintar() { //dibujamos el laberinto
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print(laberinto[i][j]);
            }
            System.out.println();
        }
    }
}
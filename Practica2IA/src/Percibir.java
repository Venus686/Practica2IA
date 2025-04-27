public class Percibir {
    private char[][] laberinto;
    private int fila;
    private int columna;

    public Percibir(char[][] laberinto, int x, int y) {
        this.laberinto = laberinto;
        this.fila = x;
        this.columna = y;
    }

    public int[] movimiento() { // la clase percibir devuelve un array de 5 posiciones, corresponden a las direcciones arriba, abajo, izquierda, derecha,
        // y si no sse pudiese ninguno de los anteriores. Devuelve el valor 0 si si no es posible el movimiento, 1 si es posible
        // y devuelve un 2 si es la salida. La posicion 5 está a 0 si hay movimientos y a 1 si no es posible ninguno.
        int[] movimiento = new int[5];
        if (this.fila > 0 && this.laberinto[this.fila - 1][this.columna] != '#') { // miramos que no sea pared y que no es la primera fila
            if (this.laberinto[this.fila - 1][this.columna] == 'S') {
                movimiento[0] = 2;
            } else {
                movimiento[0] = 1;
            }
        } else {
            movimiento[0] = 0;
        }

        if (this.fila < this.laberinto.length - 1 && this.laberinto[this.fila + 1][this.columna] != '#') { // miramos que no sea pared ni la ultima fila
            if (this.laberinto[this.fila + 1][this.columna] == 'S') {
                movimiento[1] = 2;
            } else {
                movimiento[1] = 1;
            }
        } else {
            movimiento[1] = 0;
        }

        if (this.columna > 0 && this.laberinto[this.fila][this.columna - 1] != '#') {
            if (this.laberinto[this.fila][this.columna - 1] == 'S') {
                movimiento[2] = 2;
            } else {
                movimiento[2] = 1;
            }
        } else {
            movimiento[2] = 0;
        }

        if (this.columna < this.laberinto[0].length - 1 && this.laberinto[this.fila][this.columna + 1] != '#') {
            if (this.laberinto[this.fila][this.columna + 1] == 'S') {
                movimiento[3] = 2;
            } else {
                movimiento[3] = 1;
            }
        } else {
            movimiento[3] = 0;
        }

        if (movimiento[0] == 0 && movimiento[1] == 0 && movimiento[2] == 0 && movimiento[3] == 0) {
            movimiento[4] = 1;
        } else {
            movimiento[4] = 0;
        }

        return movimiento;
    }
}




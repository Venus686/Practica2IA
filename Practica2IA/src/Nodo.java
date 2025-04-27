import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Nodo {
    private int fila;
    private int columna;
    private Nodo padre;
    private int costo;
    private int heuristica;
    private int profundidad;
    private int costoTotal;

    public Nodo(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.padre = null;
        this.costo = 0;
        this.heuristica = 0;
        this.profundidad = 0;
        this.costoTotal = 0;
    }

    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public Nodo getPadre() {
        return padre;
    }
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getHeuristica() {
        return heuristica;
    }
    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }
    public int getCostoTotal() {
        return costo + heuristica;
    }
    public List<Nodo> Hijos(Laberinto lab){
        List<Nodo> hijos = new ArrayList<Nodo>();
        Percibir p= new Percibir(lab.getLaberinto(), fila, columna);
        int []movimientos=p.movimiento();
        if (movimientos[0]!=0){
            Nodo hijo = new Nodo(fila - 1, columna);
            hijo.padre = this;
            hijo.costo = this.costo + 1;
            hijo.profundidad = this.profundidad + 1;
            hijos.add(hijo);
        }
        if (movimientos[1]!=0){
            Nodo hijo = new Nodo(fila + 1, columna);
            hijo.padre = this;
            hijo.costo = this.costo + 1;
            hijo.profundidad = this.profundidad + 1;
            hijos.add(hijo);
        }
        if (movimientos[2]!=0){
            Nodo hijo = new Nodo(fila, columna - 1);
            hijo.padre = this;
            hijo.costo = this.costo + 1;
            hijo.profundidad = this.profundidad + 1;
            hijos.add(hijo);
        }
        if (movimientos[3]!=0){
            Nodo hijo = new Nodo(fila, columna + 1);
            hijo.padre = this;
            hijo.costo = this.costo + 1;
            hijo.profundidad = this.profundidad + 1;
            hijos.add(hijo);
        }
        return hijos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return fila == nodo.fila && columna == nodo.columna;
    }
    public boolean esSalida(Laberinto laberinto) {
        return laberinto.Salida(fila, columna);
    }

    @Override
    public int hashCode() { // si dos nodos son iguales tienen el mismo hashcode
        return Objects.hash(fila, columna);
    }
}

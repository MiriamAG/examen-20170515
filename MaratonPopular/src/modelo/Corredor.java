package modelo;

/**
 *
 * @author widemos
 */
public class Corredor {

    private long id;
    private String nombre;
    private int dorsal;
    private int categoria;  // 0, Masculina - 1, Femenina - 2, Niños

    public Corredor() {
    }

    public Corredor(String nombre, int dorsal, int categoria) {
        this.id = -1;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.categoria = categoria;
    }

    public Corredor(long id, String nombre, int dorsal, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dorsal
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * @param dorsal the dorsal to set
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Corredor{" + "id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", categoria=" + categoria + '}';
    }

}

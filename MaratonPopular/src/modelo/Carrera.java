package modelo;

/**
 *
 * @author widemos
 */
public class Carrera {

    private long id;
    private String nombre;
    private double distancia;

    public Carrera() {
    }

    public Carrera(String nombre, double distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public Carrera(long id, String nombre, double distancia) {
        this.id = id;
        this.nombre = nombre;
        this.distancia = distancia;
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
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}

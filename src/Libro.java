public class Libro {
    private String nombre;
    private String autor;

    private String id;

    private static int ids = 0;

    public Libro(String nombre, String autor){
        this.nombre = nombre;
        this.autor = autor;
        this.id = ids + "";
        ids++;
    }

    public String getAutor() {
        return autor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.example.boro.worldtrademagic.Datos;

public class Articulo {

    final String ESTADO_PESIMO = "Pesimo";
    final String ESTADO_DANYADO = "Dañado";
    final String ESTADO_MALO = "Malo";
    final String ESTADO_USADO = "Usado";
    final String ESTADO_BUENO = "Bueno";
    final String ESTADO_EXCELENTE = "Excelente";
    final String ESTADO_IMEJORABLE = "Inmejorable";


    private int id, x, y, idimagen;
    private String email, descripcion, estado;
    private double precio;

    public Articulo(int id, int x, int y, int idimagen, String email, String descripcion, String estado, double precio) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.idimagen = idimagen;
        this.email = email;
        this.descripcion = descripcion;
        this.estado = estado;
        this.precio = precio;
    }

    public Articulo( int x, int y, int idimagen, String email, String descripcion, String estado, double precio) {
        this.x = x;
        this.y = y;
        this.idimagen = idimagen;
        this.email = email;
        this.descripcion = descripcion;
        this.estado = estado;
        this.precio = precio;
    }

    public Articulo(){
        this.id = 0;
        this.x = 0;
        this.y = 0;
        this.idimagen = 0;
        this.email = "";
        this.descripcion = "";
        this.estado = "";
        this.precio = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(int idimagen) {
        this.idimagen = idimagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}


package com.example.boro.worldtrademagic.Datos;

public class Usuario {

    private int id, x, y;
    private String email, password, telefono;

    public Usuario(){
        this.id = 0;
        this.x = 0;
        this.y = 0;
        this.email = "";
        this.password = "";
        this.telefono = "";
    }

    public Usuario(String password, String email, String telefono, int x, int y) {
        this.x = x;
        this.y = y;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public Usuario(int id, String password, String email, String telefono, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

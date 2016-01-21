package com.example.boro.worldtrademagic.WebService;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ArticuloService  extends AsyncTask<String, Integer, String> {

    URL url;
    String cadena;
    String devuelve;
    ProgressDialog progressDialog;
    Context context;

    public  ArticuloService(Context c){
        context = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(
                context);
        progressDialog.setMessage("Downloading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        progressDialog.cancel();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected String doInBackground(String... params) {
        String operacionARealizar = params[1];
        cadena = params[0];
        url = null;
        devuelve = params[1] + "";

        switch (operacionARealizar){
            case "1":  //Consulta de todos los usuarios
                try {
                    url = new URL(cadena); //malformedURLException
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //abrir la conexión IOException
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0" + "(Linux; Android 1.5; es-ES) Ejemplo HTTP"); //user-agent para obtener acceso a la web
                    int respuesta = 0;
                    respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {     //si va bien
                        InputStream in = new BufferedInputStream(connection.getInputStream()); //preparar la cadena
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in)); //volcar la cadena
                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);  //Pasar toda la entrada al StringBuilder
                        }

                        //----------------------------------------------------------------------------------
                        JSONObject respuestaJSON = new JSONObject(result.toString());  //add jSONException
                        String resultJSON = respuestaJSON.getString("estado");
                        if ("1".equals(resultJSON)){
                            JSONArray usuariosJSON = respuestaJSON.getJSONArray("articulos");
                            for (int i = 0; i<usuariosJSON.length();i++){
                                devuelve = devuelve+"::"
                                        + usuariosJSON.getJSONObject(i).getInt("idcarta")+";;"
                                        + usuariosJSON.getJSONObject(i).getString("correousuario") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("estado") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("idimage") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("descripcion") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("xusuario") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("yusuario")+ ";;"
                                        + usuariosJSON.getJSONObject(i).getString("precio");
                            }
                        }
                        else if ("2".equals(resultJSON)){
                            devuelve = "No existe o no hay datos en el servidor";
                        }
                        return devuelve;
                        //----------------------------------------------------------------------------------
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException io) {
                    io.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            case "2"://devolver articulos por correo de usuario
                try {
                    url = new URL(cadena); //malformedURLException
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //abrir la conexión IOException
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0" + "(Linux; Android 1.5; es-ES) Ejemplo HTTP"); //user-agent para obtener acceso a la web
                    int respuesta = 0;
                    respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {     //si va bien
                        InputStream in = new BufferedInputStream(connection.getInputStream()); //preparar la cadena
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in)); //volcar la cadena
                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);  //Pasar toda la entrada al StringBuilder
                        }

                        //----------------------------------------------------------------------------------
                        JSONObject respuestaJSON = new JSONObject(result.toString());  //add jSONException
                        String resultJSON = respuestaJSON.getString("estado");
                        if ("1".equals(resultJSON)){
                            JSONArray usuariosJSON = respuestaJSON.getJSONArray("datos");
                            int a = usuariosJSON.length();
                            for (int i = 0; i<usuariosJSON.length();i++){
                                devuelve = devuelve+"::"
                                        + usuariosJSON.getJSONObject(i).getInt("idcarta")+";;"
                                        + usuariosJSON.getJSONObject(i).getString("correousuario") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("estado") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("idimage") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("descripcion") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("xusuario") + ";;"
                                        + usuariosJSON.getJSONObject(i).getString("yusuario");
                            }
                        }
                        else if ("2".equals(resultJSON)){
                            devuelve = "No existe o no hay datos en el servidor";
                        }
                        return devuelve;
                        //----------------------------------------------------------------------------------
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException io) {
                    io.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }

                return devuelve;

            default:
                return devuelve;
        }

    }
}


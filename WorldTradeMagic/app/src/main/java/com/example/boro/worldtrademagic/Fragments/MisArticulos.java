package com.example.boro.worldtrademagic.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.boro.worldtrademagic.Datos.Articulo;
import com.example.boro.worldtrademagic.R;
import com.example.boro.worldtrademagic.WebService.ArticuloService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MisArticulos extends android.app.Fragment {

    private final String ruta = "http://borodam.esy.es";
    private final String getAll = "/obtener_articulos.php";
    private final String getArticulosByUser ="/obtener_articulo_por_correousuario.php?correousuario=pedro@gmail.com";

    Button editar0,editar1,editar2,editar3,editar4,editar5,editar6,editar7,editar8,editar9;
    List<Button> botonesEditar;
    Button add0,add1,add2,add3,add4,add5,add6,add7,add8,add9;
    List<Button> botonesAdd;
    Button borrar0,borrar1,borrar2,borrar3,borrar4,borrar5,borrar6,borrar7,borrar8,borrar9;
    List<Button> botonesBorrar;
    TextView email0, email1, email2, email3, email4,nombre5,nombre6,nombre7,nombre8,nombre9;
    List<TextView> tvEmails;
    TextView estado0,estado1,estado2,estado3,estado4,estado5,estado6,estado7,estado8,estado9;
    TextView precio0,precio1,precio2,precio3,precio4,precio5,precio6,precio7,precio8,precio9;
    TextView descrip0,descrip1,descrip2,descrip3,descrip4,descrip5,descrip6,descrip7,descrip8,descrip9;

    private SQLiteDatabase db;
    private OnFragmentInteractionListener mListener;
    private Articulo[] articulos;
    ArticuloService sw;

    public MisArticulos() {




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mis_articulos, container, false);

        IniciarComponentes(v);

//        ArticuloService st =  new ArticuloService(getActivity());
//        st.execute();

        try {
            String receivedData = new ArticuloService(getActivity()).execute(ruta + getAll, "1").get();
            pintarPantalla(receivedData);
        }
        catch (ExecutionException | InterruptedException ei) {
            ei.printStackTrace();
        }


        return v;
    }

    private Articulo[] parseArticulos(String cadena){
        Articulo[] aux = new Articulo[10];

        String[] articulos2 = cadena.split("::");
        for (int i =1; i< articulos2.length; i++){
            if(articulos2[i] != null){
                String[] atributos = articulos2[i].split(";;");
                aux[i-1] = new Articulo(
                        Integer.parseInt(atributos[0]), Integer.parseInt(atributos[5]),
                        Integer.parseInt(atributos[6]), Integer.parseInt(atributos[3]), atributos[1],
                        atributos[4], atributos[2], Double.parseDouble(atributos[7])
                );
            }
        }
        return  aux;
    }

    private void pintarPantalla(String cadena){

        articulos = parseArticulos(cadena);

        if(articulos[0] != null) {
            email0.setText(articulos[0].getEmail());
            estado0.setText("Estado: " + articulos[0].getEstado());
            precio0.setText("Precio: " + articulos[0].getPrecio() + " $");
            descrip0.setText("Descripcion: \n" + articulos[0].getDescripcion());

            add0.setEnabled(false);
            add0.setVisibility(View.INVISIBLE);
        }
        else {
            email0.setText("----Añadir nuevo articulo----");
            estado0.setText("");
            precio0.setText("");
            descrip0.setText("");

            borrar0.setEnabled(false);
            borrar0.setVisibility(View.INVISIBLE);
            editar0.setEnabled(false);
            editar0.setVisibility(View.INVISIBLE);
        }
        //item 2
        if(articulos[1] != null) {
            email1.setText(articulos[1].getEmail());
            estado1.setText("Estado: " + articulos[1].getEstado());
            precio1.setText("Precio: " + articulos[1].getPrecio() + " $");
            descrip1.setText("Descripcion: \n" + articulos[1].getDescripcion());

            add1.setEnabled(false);
            add1.setVisibility(View.INVISIBLE);
        }
        else {
            email1.setText("----Añadir nuevo articulo----");
            estado1.setText("");
            precio1.setText("");
            descrip1.setText("");

            borrar1.setEnabled(false);
            borrar1.setVisibility(View.INVISIBLE);
            editar1.setEnabled(false);
            editar1.setVisibility(View.INVISIBLE);
        }
        //item 3
        if(articulos[2] != null) {
            email2.setText(articulos[2].getEmail());
            estado2.setText("Estado: " + articulos[2].getEstado());
            precio2.setText("Precio: " + articulos[2].getPrecio() + " $");
            descrip2.setText("Descripcion: \n" + articulos[2].getDescripcion());

            add2.setEnabled(false);
            add2.setVisibility(View.INVISIBLE);
        }
        else {
            email2.setText("----Añadir nuevo articulo----");
            estado2.setText("");
            precio2.setText("");
            descrip2.setText("");

            borrar2.setEnabled(false);
            borrar2.setVisibility(View.INVISIBLE);
            editar2.setEnabled(false);
            editar2.setVisibility(View.INVISIBLE);
        }
        //item 4
        if(articulos[3] != null) {
            email3.setText(articulos[3].getEmail());
            estado3.setText("Estado: " + articulos[3].getEstado());
            precio3.setText("Precio: " + articulos[3].getPrecio() + " $");
            descrip3.setText("Descripcion: \n" + articulos[3].getDescripcion());

            add3.setEnabled(false);
            add3.setVisibility(View.INVISIBLE);
        }
        else {
            email3.setText("----Añadir nuevo articulo----");
            estado3.setText("");
            precio3.setText("");
            descrip3.setText("");

            borrar3.setEnabled(false);
            borrar3.setVisibility(View.INVISIBLE);
            editar3.setEnabled(false);
            editar3.setVisibility(View.INVISIBLE);
        }
        //item 5
        if(articulos[4] != null) {
            email4.setText(articulos[4].getEmail());
            estado4.setText("Estado: " + articulos[4].getEstado());
            precio4.setText("Precio: " + articulos[4].getPrecio() + " $");
            descrip4.setText("Descripcion: \n" + articulos[4].getDescripcion());

            add4.setEnabled(false);
            add4.setVisibility(View.INVISIBLE);
        }
        else
        {
            email4.setText("----Añadir nuevo articulo----");
            estado4.setText("");
            precio4.setText("");
            descrip4.setText("");

            borrar4.setEnabled(false);
            borrar4.setVisibility(View.INVISIBLE);
            editar4.setEnabled(false);
            editar4.setVisibility(View.INVISIBLE);
        }
        //item 6
        if(articulos[5] != null){
            nombre5.setText(articulos[5].getEmail());
            estado5.setText("Estado: " + articulos[5].getEstado());
            precio5.setText("Precio: " + articulos[5].getPrecio() + " $");
            descrip5.setText("Descripcion: \n" + articulos[5].getDescripcion());

            add5.setEnabled(false);
            add5.setVisibility(View.INVISIBLE);
        }
        else {
            nombre5.setText("----Añadir nuevo articulo----");
            estado5.setText("");
            precio5.setText("");
            descrip5.setText("");

            borrar5.setEnabled(false);
            borrar5.setVisibility(View.INVISIBLE);
            editar5.setEnabled(false);
            editar5.setVisibility(View.INVISIBLE);
        }
        //item 7
        if(articulos[6] != null) {
            nombre6.setText(articulos[6].getEmail());
            estado6.setText("Estado: " + articulos[6].getEstado());
            precio6.setText("Precio: " + articulos[6].getPrecio() + " $");
            descrip6.setText("Descripcion: \n" + articulos[6].getDescripcion());

            add6.setEnabled(false);
            add6.setVisibility(View.INVISIBLE);
        }
        else {
            nombre6.setText("----Añadir nuevo articulo----");
            estado6.setText("");
            precio6.setText("");
            descrip6.setText("");

            borrar6.setEnabled(false);
            borrar6.setVisibility(View.INVISIBLE);
            editar6.setEnabled(false);
            editar6.setVisibility(View.INVISIBLE);
        }
        //item 8
        if(articulos[7] != null) {
            nombre7.setText(articulos[7].getEmail());
            estado7.setText("Estado: " + articulos[7].getEstado());
            precio7.setText("Precio: " + articulos[7].getPrecio() + " $");
            descrip7.setText("Descripcion: \n" + articulos[7].getDescripcion());

            add7.setEnabled(false);
            add7.setVisibility(View.INVISIBLE);
        }
        else {
            nombre7.setText("----Añadir nuevo articulo----");
            estado7.setText("");
            precio7.setText("");
            descrip7.setText("");

            borrar7.setEnabled(false);
            borrar7.setVisibility(View.INVISIBLE);
            editar7.setEnabled(false);
            editar7.setVisibility(View.INVISIBLE);
        }
        //item 9
        if(articulos[8] != null) {
            nombre8.setText(articulos[8].getEmail());
            estado8.setText("Estado: " + articulos[8].getEstado());
            precio8.setText("Precio: " + articulos[8].getPrecio() + " $");
            descrip8.setText("Descripcion: \n" + articulos[8].getDescripcion());

            add8.setEnabled(false);
            add8.setVisibility(View.INVISIBLE);
        }
        else {
            nombre8.setText("----Añadir nuevo articulo----");
            estado8.setText("");
            precio8.setText("");
            descrip8.setText("");

            borrar8.setEnabled(false);
            borrar8.setVisibility(View.INVISIBLE);
            editar8.setEnabled(false);
            editar8.setVisibility(View.INVISIBLE);
        }
        //item 10
        if(articulos[9] != null) {
            nombre9.setText(articulos[9].getEmail());
            estado9.setText("Estado: " + articulos[9].getEstado());
            precio9.setText("Precio: " + articulos[9].getPrecio() + " $");
            descrip9.setText("Descripcion: \n" + articulos[9].getDescripcion());

            add9.setEnabled(false);
            add9.setVisibility(View.INVISIBLE);
        }
        else {
            nombre9.setText("----Añadir nuevo articulo----");
            estado9.setText("");
            precio9.setText("");
            descrip9.setText("");

            borrar9.setEnabled(false);
            borrar9.setVisibility(View.INVISIBLE);
            editar9.setEnabled(false);
            editar9.setVisibility(View.INVISIBLE);
        }
    }

    private void IniciarComponentes(View view){

        editar0 = (Button) view.findViewById(R.id.editar0);
        editar1 = (Button) view.findViewById(R.id.editar1);
        editar2 = (Button) view.findViewById(R.id.editar2);
        editar3 = (Button) view.findViewById(R.id.editar3);
        editar4 = (Button) view.findViewById(R.id.editar4);
        editar5 = (Button) view.findViewById(R.id.editar5);
        editar6 = (Button) view.findViewById(R.id.editar6);
        editar7 = (Button) view.findViewById(R.id.editar7);
        editar8 = (Button) view.findViewById(R.id.editar8);
        editar9 = (Button) view.findViewById(R.id.editar9);

        add0 = (Button) view.findViewById(R.id.añadir0);
        add1 = (Button) view.findViewById(R.id.añadir1);
        add2 = (Button) view.findViewById(R.id.añadir2);
        add3 = (Button) view.findViewById(R.id.añadir3);
        add4 = (Button) view.findViewById(R.id.añadir4);
        add5 = (Button) view.findViewById(R.id.añadir5);
        add6 = (Button) view.findViewById(R.id.añadir6);
        add7 = (Button) view.findViewById(R.id.añadir7);
        add8 = (Button) view.findViewById(R.id.añadir8);
        add9 = (Button) view.findViewById(R.id.añadir9);

        borrar0 = (Button) view.findViewById(R.id.eliminar0);
        borrar1 = (Button) view.findViewById(R.id.eliminar1);
        borrar2 = (Button) view.findViewById(R.id.eliminar2);
        borrar3 = (Button) view.findViewById(R.id.eliminar3);
        borrar4 = (Button) view.findViewById(R.id.eliminar4);
        borrar5 = (Button) view.findViewById(R.id.eliminar5);
        borrar6 = (Button) view.findViewById(R.id.eliminar6);
        borrar7 = (Button) view.findViewById(R.id.eliminar7);
        borrar8 = (Button) view.findViewById(R.id.eliminar8);
        borrar9 = (Button) view.findViewById(R.id.eliminar9);

        email0 = (TextView) view.findViewById(R.id.nombre0);
        email1 = (TextView) view.findViewById(R.id.nombre1);
        email2 = (TextView) view.findViewById(R.id.nombre2);
        email3 = (TextView) view.findViewById(R.id.nombre3);
        email4 = (TextView) view.findViewById(R.id.nombre4);
        nombre5 = (TextView) view.findViewById(R.id.nombre5);
        nombre6 = (TextView) view.findViewById(R.id.nombre6);
        nombre7 = (TextView) view.findViewById(R.id.nombre7);
        nombre8 = (TextView) view.findViewById(R.id.nombre8);
        nombre9 = (TextView) view.findViewById(R.id.nombre9);

        precio0 = (TextView) view.findViewById(R.id.precio0);
        precio1 = (TextView) view.findViewById(R.id.precio1);
        precio2 = (TextView) view.findViewById(R.id.precio2);
        precio3 = (TextView) view.findViewById(R.id.precio3);
        precio4 = (TextView) view.findViewById(R.id.precio4);
        precio5 = (TextView) view.findViewById(R.id.precio5);
        precio6 = (TextView) view.findViewById(R.id.precio6);
        precio7 = (TextView) view.findViewById(R.id.precio7);
        precio8 = (TextView) view.findViewById(R.id.precio8);
        precio9 = (TextView) view.findViewById(R.id.precio9);

        descrip0 = (TextView) view.findViewById(R.id.descricion0);
        descrip1 = (TextView) view.findViewById(R.id.descricion1);
        descrip2 = (TextView) view.findViewById(R.id.descricion2);
        descrip3 = (TextView) view.findViewById(R.id.descricion3);
        descrip4 = (TextView) view.findViewById(R.id.descricion4);
        descrip5 = (TextView) view.findViewById(R.id.descricion5);
        descrip6 = (TextView) view.findViewById(R.id.descricion6);
        descrip7 = (TextView) view.findViewById(R.id.descricion7);
        descrip8 = (TextView) view.findViewById(R.id.descricion8);
        descrip9 = (TextView) view.findViewById(R.id.descricion9);

        estado0 = (TextView) view.findViewById(R.id.estado0);
        estado1 = (TextView) view.findViewById(R.id.estado1);
        estado2 = (TextView) view.findViewById(R.id.estado2);
        estado3 = (TextView) view.findViewById(R.id.estado3);
        estado4 = (TextView) view.findViewById(R.id.estado4);
        estado5 = (TextView) view.findViewById(R.id.estado5);
        estado6 = (TextView) view.findViewById(R.id.estado6);
        estado7 = (TextView) view.findViewById(R.id.estado7);
        estado8 = (TextView) view.findViewById(R.id.estado8);
        estado9 = (TextView) view.findViewById(R.id.estado9);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void cerrarFragment(){
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

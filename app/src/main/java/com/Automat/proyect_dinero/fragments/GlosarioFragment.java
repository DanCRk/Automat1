package com.Automat.proyect_dinero.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.Palabra;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterPalabras;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

import static com.google.android.gms.ads.MobileAds.initialize;

public class GlosarioFragment extends Fragment{
    EditText buscador;
    AdapterPalabras adapterPersona;
    RecyclerView recyclerViewpalabras;
    ArrayList<Palabra> listaPalabras;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.glosario_fragment, container, false);

        initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2030839089746380/3174310759");

        AdView mAdView = view.findViewById(R.id.adView_Glo);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerViewpalabras = view.findViewById(R.id.recyclerViewPalabras);
        buscador = view.findViewById(R.id.buscador);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }
        });
        listaPalabras = new ArrayList<>();
        // Cargar la lista

        cargarLista();

        //mostrar datos

        mostrarData();

        return view;
    }

    // Asignar los datos de cada apartado

    public void cargarLista() {
        listaPalabras.add(new Palabra("Ajuste","Cantidad de juego o interferencia de un ensamble entre dos piezas."));
        listaPalabras.add(new Palabra("Análisis","Revisión en la secuencia en la que intervienen los equipos, herramientas y operaciones."));
        listaPalabras.add(new Palabra("Avance","Es la velocidad relativa entre la pieza y la herramienta, es decir, la velocidad con la que progresa el corte (Velocidad lineal)."));
        listaPalabras.add(new Palabra("Conicidad","Diferencia en diámetros (Diámetro mayor-Diámetro menor) a través de una longitud determinada."));
        listaPalabras.add(new Palabra("Diagrama de flujo","Es un diagrama pictórico donde se dibuja el proceso (Indica el orden de este)."));
        listaPalabras.add(new Palabra("Dimensión nominal","Dimensión original de una pieza."));
        listaPalabras.add(new Palabra("Ductilidad","Mide el grado de deformación que un material pueda soportar sin romperse."));
        listaPalabras.add(new Palabra("Dureza","Resistencia que opone un material a ser rayado o penetrado."));
        listaPalabras.add(new Palabra("Diseño industrial","Es un proceso consistente en convertir una idea existente en el mercado con el conjunto de información necesario para el producto final."));
        listaPalabras.add(new Palabra("Engranaje","Se caracterizan por ser cilíndricos o conos rodantes que poseen dientes en la superficie de contacto para que se genere un movimiento positivo."));
        listaPalabras.add(new Palabra("Ensamble","Montaje de dos o más piezas."));
        listaPalabras.add(new Palabra("Fase","Operación requerida para cumplir con una etapa de la fabricación de un producto."));
        listaPalabras.add(new Palabra("Fuerza de corte","Es el parámetro necesario a tener en cuenta para evitar roturas y deformaciones en la pieza."));
        listaPalabras.add(new Palabra("Límite","Es el valor máximo permitido en relación a un plano o norma."));
        listaPalabras.add(new Palabra("Línea de medición","Es la línea que une los dos puntos medidos, es paralela a la escala del instrumento empleado y es imaginaria."));
        listaPalabras.add(new Palabra("Medir","Es el acto de comparar una longitud o extensión establecida."));
        listaPalabras.add(new Palabra("Polímero","substancia compuesta por grandes moléculas, o macromoléculas formadas por la unión mediante enlaces covalentes de una o más unidades simples llamadas monómeros"));
        listaPalabras.add(new Palabra("Rosca","Se define como una cresta helicoidal de sección uniforme, que se forma en el interior o exterior de un cono o cilindro."));
        listaPalabras.add(new Palabra("Rugosidad","Es una imperfección micro-geométrica, que se ve principalmente en las piezas maquinadas, su origen son las RPM y el avance."));
        listaPalabras.add(new Palabra("Sujeción","Acción de mantener una pieza en su lugar mediante la ubicación y fijación."));
        listaPalabras.add(new Palabra("Tensión","Someter un cuerpo a cargas axiales."));
        listaPalabras.add(new Palabra("Tolerancia","Rango de variación permitido en una pieza respecto al plano original."));
        listaPalabras.add(new Palabra("Velocidad de corte","Velocidad en m/min de un punto de la superficie que se mecaniza si es esta la que lleva en torneado."));
        listaPalabras.add(new Palabra("Volumen de viruta","Volumen de viruta arrancado por minuto (cm^2)."));
    }
    public void mostrarData(){
        recyclerViewpalabras.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona = new AdapterPalabras(getContext(), listaPalabras);
        recyclerViewpalabras.setAdapter(adapterPersona);
    }
    public void filtrar(String texto){
        ArrayList<Palabra> filtrarLista = new ArrayList<>();
        for (Palabra palabra : listaPalabras){
            if (palabra.getTituloGlosario().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(palabra);
            }
        }
        adapterPersona.filtrar(filtrarLista);
    }
}


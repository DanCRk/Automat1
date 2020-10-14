package com.Automat.proyect_dinero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AcercadeActivity extends Activity {

    TextView textView, textView1, textView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Para que salga a pantalla completa
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_acercade);

        // Agregar animaciones

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba2);

        // Crear clases

        textView1 = findViewById(R.id.version);
        textView2 = findViewById(R.id.nombre);
        textView = findViewById(R.id.compartir_acercade);
        TextView PorTextView =findViewById(R.id.PorTextView);
        TextView FutureFixTextView =findViewById(R.id.FutureFixTextView);
        ImageView LogoImageView = findViewById(R.id.LogoImageView);

        // Asignar animaciones

        textView2.setAnimation(animation3);
        textView1.setAnimation(animation3);
        textView.setAnimation(animation2);
        PorTextView.setAnimation(animation2);
        FutureFixTextView.setAnimation(animation2);
        LogoImageView.setAnimation(animation1);

        // Asignar la accion para compartir la app

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compartir = new Intent(Intent.ACTION_SEND);
                compartir.setType("text/plain");
                String mensaje = "Comparte la app:)";
                compartir.putExtra(Intent.EXTRA_SUBJECT,"App prrona");
                compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
                startActivity(Intent.createChooser(compartir,"Compartir via"));
            }
        });
    }

    public void pulsar(View view) {
    }
}
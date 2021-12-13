package es.studium.pmdm_t4_p4_frm;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Interfaz {
    Button btnAvatar;
    DialogNombre dialogNombre;
    DialogSexo dialogSexo;
    DialogEspecie dialogEspecie;
    DialogProfesion dialogProfesion;
    String nombre, sexo, especie, profesion;
    ImageView imgAvatar, imgArma, imgVida, imgMagia, imgFuerza, imgVelocidad;
    ProgressBar vida, magia, fuerza, velocidad;
    TextView min1, min2, min3, min4, max1, max2, max3,max4;
    int ruta, ruta2;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAvatar = findViewById(R.id.btnAvatar);
        btnAvatar.setOnClickListener(this);
        imgAvatar = findViewById(R.id.imgAvatar);
        imgArma = findViewById(R.id.imgArma);
        vida = findViewById(R.id.progressBarVida);
        magia = findViewById(R.id.progressBarMagia);
        fuerza = findViewById(R.id.progressBarFuerza);
        velocidad = findViewById(R.id.progressBarVelocidad);

        imgVida = findViewById(R.id.imgVida);
        imgMagia = findViewById(R.id.imgMagia);
        imgFuerza = findViewById(R.id.imgFuerza);
        imgVelocidad = findViewById(R.id.imgVelocidad);

        min1 = findViewById(R.id.txtMin);
        min2 = findViewById(R.id.txtMin2);
        min3 = findViewById(R.id.txtMin3);
        min4 = findViewById(R.id.txtMin4);
        min1 = findViewById(R.id.txtMax);
        min2 = findViewById(R.id.txtMax2);
        min3 = findViewById(R.id.txtMax3);
        min4 = findViewById(R.id.txtMax4);


    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnAvatar)) {
            dialogNombre = new DialogNombre();
            dialogNombre.setCancelable(false);
            dialogNombre.show(getSupportFragmentManager(), "Nuevo Diálogo");
        }

    }

    @Override
    public void guardarNombre(String nombreObtenido) {
        dialogSexo = new DialogSexo();
        dialogSexo.setCancelable(false);
        dialogSexo.show(getSupportFragmentManager(), "Nombre Diálogo");
        nombre = nombreObtenido;
        System.out.println(nombre);
    }

    public void guardarSexo(String sexoObtenido) {
        dialogEspecie = new DialogEspecie();
        dialogEspecie.setCancelable(false);
        dialogEspecie.show(getSupportFragmentManager(), "Sexo Diálogo");
        sexo = sexoObtenido;
        System.out.println(sexo);

    }

    public void guardarEspecie(String especieObtenida) {
        dialogProfesion = new DialogProfesion();
        dialogProfesion.setCancelable(false);
        dialogProfesion.show(getSupportFragmentManager(), "Especie Diálogo");
        especie = especieObtenida;
        System.out.println(especie);
    }

    public void guardarProfesion(String profesionObtenida) {
        profesion = profesionObtenida;
        System.out.println(profesion);
        crearAvatar();
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0) {
            if (profesionObtenida.equals("Arquero@"))
            {
                System.out.println("elfoooo");
                ruta2 = R.drawable.ic_arquero;
            }
            else if (profesionObtenida.equals("Guerrer@"))
            {
                ruta2 = R.drawable.ic_guerrero;
            }
            else if (profesionObtenida.equals("Mag@"))
            {
                ruta2 = R.drawable.ic_mago;
            }
            else if (profesionObtenida.equals("Herrer@"))
            {
                ruta2 = R.drawable.ic_herrero;
            }
            else if (profesionObtenida.equals("Miner@"))
                ruta2 = R.drawable.ic_minero;
        }
        imgArma.setImageResource(ruta2);
        generarAtributos();
    }

    private void generarAtributos()
    {
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0) {
            int v = (int) (Math.random() * (100 - 0)) + 0;
            int m = (int) (Math.random() * (10 - 0)) + 0;
            int f = (int) (Math.random() * (20 - 0)) + 0;
            int ve = (int) (Math.random() * (5 - 0)) + 0;
            System.out.println("" + v + "-" + m + "-" + f + "-" + ve);

            vida.setProgress(v);
            magia.setProgress(m);
            fuerza.setProgress(f);
            velocidad.setProgress(ve);
            imgFuerza.setImageResource(R.drawable.ic_fuerza);
            imgVelocidad.setImageResource(R.drawable.ic_velocidad);
            imgVida.setImageResource(R.drawable.ic_corazon);
            imgMagia.setImageResource(R.drawable.ic_magia);


            min1.setVisibility(View.VISIBLE);
            min2.setVisibility(View.VISIBLE);
            min3.setVisibility(View.VISIBLE);
            min4.setVisibility(View.VISIBLE);
            min1.setVisibility(View.VISIBLE);
            min2.setVisibility(View.VISIBLE);
            min3.setVisibility(View.VISIBLE);
            min4.setVisibility(View.VISIBLE);
            vida.setVisibility(View.VISIBLE);
            magia.setVisibility(View.VISIBLE);
            fuerza.setVisibility(View.VISIBLE);
            velocidad.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void cancelarNombre()
    {

    }
    public void cancelarSexo()
    {
        dialogSexo.dismiss();
        dialogNombre = new DialogNombre();
        dialogNombre.setCancelable(false);
        dialogNombre.show(getSupportFragmentManager(), "Nombre");
    }
    public void cancelarEspecie()
    {
        dialogEspecie.dismiss();
        dialogSexo = new DialogSexo();
        dialogSexo.setCancelable(false);
        dialogSexo.show(getSupportFragmentManager(), "Sexo");

    }
    public void cancelarProfesion()
    {
        dialogProfesion.dismiss();
        dialogEspecie = new DialogEspecie();
        dialogEspecie.setCancelable(false);
        dialogEspecie.show(getSupportFragmentManager(), "Especie");

    }
    private void crearAvatar() {
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0) {
            if (sexo.equals("Hombre") && especie.equals("Elf@")) {
                System.out.println("elfoooo");
                ruta = R.drawable.ic_elfo;
            } else if (sexo.equals("Mujer") && especie.equals("Elf@")) {
                ruta = R.drawable.ic_elfa;
            } else if (sexo.equals("Mujer") && especie.equals("Enan@")) {
                ruta = R.drawable.ic_enana;
            } else if (sexo.equals("Hombre") && especie.equals("Enan@")) {
                ruta = R.drawable.ic_enano;
            } else if (sexo.equals("Mujer") && especie.equals("Human@")) {
                ruta = R.drawable.ic_mujer;
            } else if (sexo.equals("Hombre") && especie.equals("Human@")) {
                ruta = R.drawable.ic_hombre;
            }
        }
        imgAvatar.setImageResource(ruta);

    }
}

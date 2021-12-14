package es.studium.pmdm_t4_p4_frm;

import static es.studium.pmdm_t4_p4_frm.R.drawable.ic_vida;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Interfaz {
    Button btnAvatar;
    DialogNombre dialogNombre;
    DialogSexo dialogSexo;
    DialogEspecie dialogEspecie;
    DialogProfesion dialogProfesion;
    String nombre, sexo, especie, profesion;
    ImageView imgAvatar, imgArma, imgVida, imgMagia, imgFuerza, imgVelocidad;
    ProgressBar vida, magia, fuerza, velocidad;
    TextView min1, min2, min3, min4, max1, max2, max3,max4, txtNombre;
    int ruta, ruta2;

    @SuppressLint({"WrongConstant", "ResourceType"})
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
        max1 = findViewById(R.id.txtMax);
        max2 = findViewById(R.id.txtMax2);
        max3 = findViewById(R.id.txtMax3);
        max4 = findViewById(R.id.txtMax4);

        txtNombre = findViewById(R.id.txtNombre);

    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnAvatar)) {
            dialogNombre = new DialogNombre();
            dialogNombre.setCancelable(false);
            dialogNombre.show(getSupportFragmentManager(), "Nombre");
        }

    }

    @Override
    public void guardarNombre(String nombreObtenido) {
        dialogSexo = new DialogSexo();
        dialogSexo.setCancelable(false);
        dialogSexo.show(getSupportFragmentManager(), "Nombre");
        nombre = nombreObtenido;
    }

    public void guardarSexo(String sexoObtenido) {
        dialogEspecie = new DialogEspecie();
        dialogEspecie.setCancelable(false);
        dialogEspecie.show(getSupportFragmentManager(), "Sexo");
        sexo = sexoObtenido;

    }

    public void guardarEspecie(String especieObtenida) {
        dialogProfesion = new DialogProfesion();
        dialogProfesion.setCancelable(false);
        dialogProfesion.show(getSupportFragmentManager(), "Especie");
        especie = especieObtenida;
    }

    public void guardarProfesion(String profesionObtenida) {
        profesion = profesionObtenida;
        crearAvatar();
        generarAtributos();
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0) {
            if (profesion.equals("Arquero@"))
            {
                ruta2 = R.drawable.ic_arquero;
            }
            else if (profesion.equals("Guerrer@"))
            {
                ruta2 = R.drawable.ic_guerrero;
            }
            else if (profesion.equals("Mag@"))
            {
                ruta2 = R.drawable.ic_mago;
            }
            else if (profesion.equals("Herrer@"))
            {
                ruta2 = R.drawable.ic_herrero;
            }
            else if (profesion.equals("Miner@")) {
                ruta2 = R.drawable.ic_minero;
            }
        }
        imgArma.setImageResource(ruta2);

    }

    private void generarAtributos()
    {
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0)
        {
            imgFuerza.setImageResource(R.drawable.ic_fuerza);
            imgVelocidad.setImageResource(R.drawable.ic_velocidad);
            imgVida.setImageResource(ic_vida);
            imgMagia.setImageResource(R.drawable.ic_magia);

            int v = (int) (Math.random() * (100 - 0)) + 0;
            int m = (int) (Math.random() * (10 - 0)) + 0;
            int f = (int) (Math.random() * (20 - 0)) + 0;
            int ve = (int) (Math.random() * (5 - 0)) + 0;

            vida.setProgress(v);
            magia.setProgress(m);
            fuerza.setProgress(f);
            velocidad.setProgress(ve);
            txtNombre.setText(nombre);

            min1.setVisibility(View.VISIBLE);
            min2.setVisibility(View.VISIBLE);
            min3.setVisibility(View.VISIBLE);
            min4.setVisibility(View.VISIBLE);

            max1.setVisibility(View.VISIBLE);
            max2.setVisibility(View.VISIBLE);
            max3.setVisibility(View.VISIBLE);
            max4.setVisibility(View.VISIBLE);

            vida.setVisibility(View.VISIBLE);
            velocidad.setVisibility(View.VISIBLE);
            fuerza.setVisibility(View.VISIBLE);
            magia.setVisibility(View.VISIBLE);
            txtNombre.setVisibility(View.VISIBLE);
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
        if (nombre.length() != 0 && sexo.length() != 0 && especie.length() != 0 && profesion.length() != 0)
        {
            if (sexo.equals("Hombre") && especie.equals("Elf@"))
            {
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

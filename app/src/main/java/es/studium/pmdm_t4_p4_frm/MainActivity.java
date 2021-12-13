package es.studium.pmdm_t4_p4_frm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Interfaz
{
    Button btnAvatar;
    DialogNombre dialogNombre;
    DialogSexo dialogSexo;
    DialogEspecie dialogEspecie;
    DialogProfesion dialogProfesion;
    String nombre, sexo, especie, profesion;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAvatar = findViewById(R.id.btnAvatar);
        btnAvatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(btnAvatar))
        {
            dialogNombre = new DialogNombre();
            dialogNombre.show(getSupportFragmentManager(), "Nuevo Diálogo");
        }

    }

    @Override
    public void guardarNombre(String nombreObtenido)
    {
        dialogSexo = new DialogSexo();
        dialogSexo.show(getSupportFragmentManager(), "Nombre Diálogo");
        nombre = nombreObtenido;
        System.out.println(nombre);
    }
    public void guardarSexo(String sexoObtenido)
    {
        dialogEspecie = new DialogEspecie();
        dialogEspecie.show(getSupportFragmentManager(), "Sexo Diálogo");
        sexo = sexoObtenido;
        System.out.println(sexo);

    }public void guardarEspecie(String especieObtenida)
    {
        dialogProfesion = new DialogProfesion();
        dialogProfesion.show(getSupportFragmentManager(), "Especie Diálogo");
        especie = especieObtenida;
        System.out.println(especie);
    }
    public void guardarProfesion(String profesionObtenida)
    {
        profesion = profesionObtenida;
        System.out.println(profesion);
    }

    @Override
    public void cancelar() {

    }
}
package es.studium.pmdm_t4_p4_frm;

import android.widget.Spinner;

public interface Interfaz
{
    public void guardarNombre(String nombre);
    public void guardarSexo(String sexo);
    public void guardarEspecie(String especie);
    public void guardarProfesion(String profesion);

    public void cancelarNombre();
    public void cancelarSexo();
    public void cancelarEspecie();
    public void cancelarProfesion();
}

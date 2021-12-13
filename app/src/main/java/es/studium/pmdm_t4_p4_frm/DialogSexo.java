package es.studium.pmdm_t4_p4_frm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogSexo extends DialogFragment
{
    Interfaz listener;
    RadioButton masculino, femenino;
    String sexo;
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogo_sexo, null);
        masculino = v.findViewById(R.id.rbMasculino);
        femenino = v.findViewById(R.id.rbFemenino);
        builder.setView(v);
        builder.setTitle(R.string.titulo2)
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        if(masculino.isChecked()==true||femenino.isChecked()==true)
                        {

                            comprobarSexo();
                            listener.guardarSexo(sexo);
                            dialog.dismiss();
                        }
                        else
                            {
                                Toast.makeText(v.getContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                            }

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        listener.cancelarSexo();

                    }
                });
        return builder.create();
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        try {
            listener = (Interfaz) context;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ "Implemneta el Interfaz listener");
        }
    }
    public void comprobarSexo()
    {
        if(masculino.isChecked()==true)
        {
           sexo = getString(R.string.rbMasculino);
        }
        else if(femenino.isChecked()==true)
        {
            sexo = getString(R.string.rbFemenino);
        }
    }
}

package es.studium.pmdm_t4_p4_frm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogProfesion extends DialogFragment
{
    Spinner spProfesion;
    Interfaz listener;
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogo_profesion, null);
        builder.setView(v);
        spProfesion = v.findViewById(R.id.spProfesion);
        builder.setTitle(R.string.titulo4)
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if(spProfesion.getSelectedItemPosition()!=0) {
                            dialog.dismiss();
                            listener.guardarProfesion(spProfesion.getSelectedItem().toString());
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
                        listener.cancelarProfesion();
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
}

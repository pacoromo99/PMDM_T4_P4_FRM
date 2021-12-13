package es.studium.pmdm_t4_p4_frm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogEspecie extends DialogFragment
{
    Spinner especie;
    Interfaz listener;
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogo_especie, null);
        builder.setView(v);
        especie = v.findViewById(R.id.spEspecies);
        builder.setTitle("especie Diálogo")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                        listener.guardarEspecie(especie.getSelectedItem().toString());
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        listener.cancelar();
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

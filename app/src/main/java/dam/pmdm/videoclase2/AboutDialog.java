package dam.pmdm.videoclase2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

/**
 * La clase AboutDialog corresponde con la ventana de información "Acerca de", a la que se accede a
 * través del botón localizado en la barra superior, a la derecha, con un icono de "información"
 */
public class AboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.about_alert)
                .setPositiveButton(R.string.positive_button, (dialog, id) -> {
                    dialog.dismiss();
                });
        // Create the AlertDialog object and return it.
        return builder.create();
    }
}

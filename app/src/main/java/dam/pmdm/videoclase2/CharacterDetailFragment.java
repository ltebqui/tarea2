package dam.pmdm.videoclase2;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.videoclase2.databinding.CharacterDetailFragmentBinding;

/**
 * La clase CharacterDetailFragment conforma la lógica detrás del layout character_detail-fragment.
 * Es la estructura donde el usuario accede a la información más detallada del personaje
 * seleccionado dentro de la lista
 */

public class CharacterDetailFragment extends Fragment {

    private CharacterDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            int name = getArguments().getInt("name");
            int description = getArguments().getInt("description");
            int skills = getArguments().getInt("skills");

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalles_del_juego);
        }
    }
}

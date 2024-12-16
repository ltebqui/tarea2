package dam.pmdm.videoclase2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import dam.pmdm.videoclase2.databinding.CharacterListFragmentBinding;

import java.util.ArrayList;

/**
 *La clase CharacterListFragment aporta la lógica correspondiente a character_list_fragment, que
 * contiene la lista (tipo recyclerview) de los personajes
 */

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding; // Binding para el layout
    private ArrayList<CharacterData> characters; // Lista de personajes
    private CharacterRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        Snackbar.make(binding.getRoot(), R.string.welcome, Snackbar.LENGTH_SHORT).show();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de juegos
        loadCharacters(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);


    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadCharacters() {
        characters = new ArrayList<CharacterData>();
        // Llenar la lista con datos de personajes
        characters.add(new CharacterData(
                R.drawable.mario,
                R.string.mario_name,
                R.string.mario_detail,
                R.string.heroes_skills
        ));

        characters.add(new CharacterData(
                R.drawable.luigi,
                R.string.luigi_name,
                R.string.luigi_detail,
                R.string.heroes_skills
        ));

        characters.add(new CharacterData(
                R.drawable.peach,
                R.string.peach_name,
                R.string.peach_detail,
                R.string.heroes_skills
        ));

        characters.add(new CharacterData(
                R.drawable.toad,
                R.string.toad_name,
                R.string.toad_detail,
                R.string.heroes_skills
        ));

        characters.add(new CharacterData(
                R.drawable.yoshi,
                R.string.yoshi_name,
                R.string.yoshi_detail,
                R.string.heroes_skills
        ));

        characters.add(new CharacterData(
                R.drawable.boo,
                R.string.boo_name,
                R.string.boo_detail,
                R.string.ghost_skills
        ));

        characters.add(new CharacterData(
                R.drawable.bowser,
                R.string.bowser_name,
                R.string.boo_detail,
                R.string.boss_skills
        ));

        characters.add(new CharacterData(
                R.drawable.goomba,
                R.string.goomba_name,
                R.string.goomba_detail,
                R.string.enemies_skills
        ));

        characters.add(new CharacterData(
                R.drawable.koopa,
                R.string.koopa_name,
                R.string.koopa_detail,
                R.string.enemies_skills
        ));
    }


    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_juegos);
        }
    }
}

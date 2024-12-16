package dam.pmdm.videoclase2;

import androidx.recyclerview.widget.RecyclerView;

import dam.pmdm.videoclase2.databinding.CharacterCardviewBinding;

/**
 *La clase CharacterViewHolder aporta la lógica al layout character_cardview, que consiste en la
 * estructura de los items que forman la lista de personajes
 */

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding;

    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (CharacterData characterData){
        binding.image.setImageResource(characterData.getImage());
        binding.name.setText(characterData.getName());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}


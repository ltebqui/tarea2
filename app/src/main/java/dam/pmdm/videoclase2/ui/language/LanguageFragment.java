package dam.pmdm.videoclase2.ui.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dam.pmdm.videoclase2.databinding.FragmentGalleryBinding;

import java.util.Locale;

import android.content.res.Configuration;

public class LanguageFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LanguageViewModel galleryViewModel =
                new ViewModelProvider(this).get(LanguageViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*RadioButton spanishButton = galleryViewModel.findViewById(R.id.spanish);

        if (spanishButton.isChecked()){
            changeLanguage("es");
        }else{
            changeLanguage("en");
        }*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void selectLanguage(){

    }

    private void changeLanguage(String lang){
        Locale locale;
        locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}
package dam.pmdm.videoclase2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import dam.pmdm.videoclase2.databinding.ActivityMainBinding;

/**
 * Clase principal desde que se lanza la aplicación. Corresponde con el layout activity_main que se
 * encuentra dividido, permitiendo mostrar el menu lateral y  el fragmento que contendrá la lista
 * de personajes
 */

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_language)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // Método para manejar el clic en un juego
    public void characterClicked(CharacterData character, View view) {
        // Crear un Bundle para pasar los datos al CharacterDetailFragment
        Bundle bundle = new Bundle();
        bundle.putInt("name", character.getName());
        bundle.putInt("skills", character.getSkills());
        bundle.putInt("image", character.getImage());
        bundle.putInt("description", character.getDescription());

        // Navegar al CharacterDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);

        String name = getResources().getString(character.getName());
        String characterSelected = getResources().getString(R.string.character_selected, name);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, characterSelected, duration);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            new AboutDialog().show(getSupportFragmentManager(),"AboutUs");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
package com.example.ejercicio_indiv_2_m_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.ejercicio_indiv_2_m_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    private boolean isFragmentShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAbrir.setOnClickListener(v -> {

            if(!isFragmentShow) {
                openFragment();
            } else {
                closeFragment();
            }
        });
        binding.btnCerrarApp.setOnClickListener(view -> finishAffinity());
    }
        private void openFragment() {
            // 1primer paso es instanciar el fragmento
            Fragment1 questionFragment = new Fragment1();

            //2 instancia del fragment manager
            FragmentManager manager = getSupportFragmentManager();

            //3 crear la transaccion
            FragmentTransaction transaction = manager.beginTransaction().replace(binding.contenedor.getId(), questionFragment);
            transaction.commit();

            binding.btnAbrir.setText(R.string.btn_cerrar);
            isFragmentShow = true;
        }

        private void closeFragment () {
            // GENERAR INSTANCIA DEL MANAGER
            FragmentManager manager = getSupportFragmentManager();
            Fragment1 questionFragment = (Fragment1) manager.findFragmentById(binding.contenedor.getId());

            if (questionFragment != null) {

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(questionFragment).commit();
                binding.btnAbrir.setText(R.string.btn_abrir);
                isFragmentShow = false;
            }
        }
    }
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.     fab.setOnClickListener(view -> showSignUpDialog());
    }

    private void showSignUpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sign Up");

        View dialogView = getLayoutInflater().inflate(R.layout.dialogue_signup, null);
        builder.setView(dialogView);

        EditText etUserType = dialogView.findViewById(R.id.etUserType);
        EditText etId = dialogView.findViewById(R.id.etId);
        EditText etFirstName = dialogView.findViewById(R.id.etFirstName);
        EditText etSurname = dialogView.findViewById(R.id.etSurname);
        EditText etUsername = dialogView.findViewById(R.id.etUsername);
        EditText etMedReq = dialogView.findViewById(R.id.etMedReq);
        EditText etFoodReq = dialogView.findViewById(R.id.etFoodReq);

        builder.setPositiveButton("Sign Up", (dialog, which) -> {
            try {
                String userType = etUserType.getText().toString().trim();
                int id = Integer.parseInt(etId.getText().toString());
                String firstName = etFirstName.getText().toString().trim();
                String surname = etSurname.getText().toString().trim();
                String username = etUsername.getText().toString().trim();

                if (firstName.isEmpty() || surname.isEmpty() || username.isEmpty()) {
                    throw new IllegalArgumentException("All fields are required");
                }

                if (userType.equalsIgnoreCase("student")) {
                    String medReq = etMedReq.getText().toString().trim();
                    String foodReq = etFoodReq.getText().toString().trim();

                    Student student = new Student();
                    student.setStuNum(id);
                    student.setStuName(firstName);
                    student.setStuSurname(surname);
                    student.setUserName(username);
                    student.setMedRequirement(medReq);
                    student.setFoodReq(foodReq);

                    userViewModel.insertStudent(student);
                    Snackbar.make(binding.getRoot(), "Student registered successfully!", Snackbar.LENGTH_SHORT).show();
                }
                else if (userType.equalsIgnoreCase("nurse")) {
                    Nurse nurse = new Nurse();
                    nurse.setEmpNum(id);
                    nurse.setEmpName(firstName);
                    nurse.setEmpSurname(surname);
                    nurse.setEmpUserName(username);

                    userViewModel.insertNurse(nurse);
                    Snackbar.make(binding.getRoot(), "Nurse registered successfully!", Snackbar.LENGTH_SHORT).show();
                } else {
                    throw new IllegalArgumentException("Invalid user type. Use 'student' or 'nurse'");
                }
            } catch (NumberFormatException e) {
                Snackbar.make(binding.getRoot(), "Invalid ID format. Please enter numbers only", Snackbar.LENGTH_LONG).show();
            } catch (IllegalArgumentException e) {
                Snackbar.make(binding.getRoot(), e.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
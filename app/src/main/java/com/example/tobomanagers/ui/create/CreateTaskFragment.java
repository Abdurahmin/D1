package com.example.tobomanagers.ui.create;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tobomanagers.R;
import com.example.tobomanagers.databinding.FragmentCreateTaskBinding;
import com.example.tobomanagers.intils.Constant;

import org.jetbrains.annotations.NotNull;


public class CreateTaskFragment extends Fragment {
    private FragmentCreateTaskBinding binding;
    String userTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup contbainer = null;
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.taskEd.getText().toString();
        NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_content_main);
        userTask = binding.taskEd.getText().toString();
        binding.appleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Constant.USER_TASK,userTask);
                navController.navigate(R.id.nav_home,bundle);
                Toast.makeText(requireContext(),""+bundle.getString(userTask),Toast.LENGTH_SHORT).show();
                bundle.putString(Constant.USER_TASK,userTask);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
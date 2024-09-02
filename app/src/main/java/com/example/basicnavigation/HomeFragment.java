package com.example.basicnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up navigation button
        Button navigateButton = view.findViewById(R.id.navigate_destination_button);
        NavOptions.Builder navOptionsBuilder = new NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right);
        final NavOptions options = navOptionsBuilder.build();
        navigateButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this).navigate(R.id.flow_step_one_dest, null, options));

        // Set up action button
        Button actionButton = view.findViewById(R.id.navigate_action_button);
        actionButton.setOnClickListener(v -> {
            int flowStepNumber = 1;
            HomeFragmentDirections.NextAction action = HomeFragmentDirections.nextAction();
            action.setFlowStepNumber(flowStepNumber);
            NavHostFragment.findNavController(this).navigate(action);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home_dest) {
            NavHostFragment.findNavController(this).navigate(R.id.home_dest);
            return true;
        } else if (id == R.id.settings_dest) {
            NavHostFragment.findNavController(this).navigate(R.id.settings_dest);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

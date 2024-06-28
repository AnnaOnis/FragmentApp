package com.example.fragmentapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView profileImage = view.findViewById(R.id.profile_image);
        TextView profileName = view.findViewById(R.id.profile_name);
        TextView profilePhone = view.findViewById(R.id.profile_phone);

        profileImage.setImageResource(R.drawable.ic_launcher_foreground);
        profileName.setText("Иван Иванов");
        profilePhone.setText("+123456789");

        return view;
    }
}


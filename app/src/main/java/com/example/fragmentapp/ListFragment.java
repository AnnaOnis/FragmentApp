package com.example.fragmentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    //private List<Item> itemList;
    private List<PersonItem> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        itemList = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            itemList.add(new Item("Item " + i, "Description " + i, R.drawable.ic_launcher_background));
//        }

        itemList = new ArrayList<>();
        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        OkHttpClient client = new OkHttpClient();
        String url ="https://api.randomdatatools.ru/?unescaped=false&count=15&params=LastName,FirstName,Phone,Email";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()){
                    String str = "Api request failed";
                    System.out.println(str);
                }else{
                    try {
                        assert response.body() != null;
                        String jsonData = response.body().string();
                        JSONArray jsonArray = new JSONArray(jsonData);

                        List<PersonItem> newItems = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String firstName = jsonObject.getString("FirstName");
                            String lastName = jsonObject.getString("LastName");
                            String email = jsonObject.getString("Email");
                            String phone = jsonObject.getString("Phone");

                            PersonItem personItem = new PersonItem(firstName, lastName, email, phone, R.drawable.ic_launcher_background);
                            newItems.add(personItem);
                        }
                        new Handler(Looper.getMainLooper()).post(() -> {
                            itemList.clear();
                            itemList.addAll(newItems);
                            adapter.notifyDataSetChanged();
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            }
        });

        return view;

    }

}


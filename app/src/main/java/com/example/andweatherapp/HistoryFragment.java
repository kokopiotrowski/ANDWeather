package com.example.andweatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryFragment extends Fragment {

    private RecyclerView historyRecyclerView;
    private Button clearHistoryButton;
    private Set<String> setOfSearchHistoryInfo;
    private SharedPreferences pref;
    private List<String> searchHistoryInfo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.history_fragment, container, false);

        historyRecyclerView = v.findViewById(R.id.historyView);
        clearHistoryButton = v.findViewById(R.id.clear_history_button);

        historyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyRecyclerView.hasFixedSize();

        updateSearchHistory();

        clearHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putStringSet("searchHistory", null);
                editor.apply();
                updateSearchHistory();
            }
        });
        return v;
    }

    private void updateSearchHistory()
    {
        searchHistoryInfo = new ArrayList<>();
        pref = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);

        setOfSearchHistoryInfo = pref.getStringSet("searchHistory", null);
        if(setOfSearchHistoryInfo !=null) {
            for (String historyInfo : setOfSearchHistoryInfo) {
                searchHistoryInfo.add(historyInfo);
            }
        }
        HistoryAdapter adapter = new HistoryAdapter(searchHistoryInfo);
        historyRecyclerView.setAdapter(adapter);
    }
}

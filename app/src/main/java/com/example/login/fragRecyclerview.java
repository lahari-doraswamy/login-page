package com.example.login;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragRecyclerview#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class fragRecyclerview extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragRecyclerview.
     */
    // TODO: Rename and change types and number of parameters
    public static fragRecyclerview newInstance(String param1, String param2) {
        fragRecyclerview fragment = new fragRecyclerview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public fragRecyclerview() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_frag_recyclerview,container,false);
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //initData();
        recyclerView.setAdapter(new ItemAdapter(initData()));
        return  view;
    }

    private List<Model> initData() {

        ArrayList<Model> itemList=new ArrayList<>();
        itemList.add(new Model(R.drawable.facebook,"FaceBook"));
        itemList.add(new Model(R.drawable.google,"Google"));
        itemList.add(new Model(R.drawable.instagram1,"instagram"));
        itemList.add(new Model(R.drawable.youtube,"Youtube"));
        itemList.add(new Model(R.drawable.telegram,"Telegram"));
        itemList.add(new Model(R.drawable.linkedin,"Linkedin"));
       return itemList;
    }
}
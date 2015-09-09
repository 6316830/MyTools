package com.baofeng.hero.myapplication.com.baofeng.view;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.baofeng.hero.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageThreeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   View mainView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageThreeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageThreeFragment newInstance(String param1, String param2) {
        PageThreeFragment fragment = new PageThreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PageThreeFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView=inflater.inflate(R.layout.fragment_page_three, container, false);
        return mainView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ListView listView=(ListView)mainView.findViewById(R.id.listView);
        listView.setOnItemClickListener(onItemClickListener);
    }
    AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              switch (position){
                  case 0:
                      Intent intent=new Intent(getActivity(),MyPositionActivity.class);
                      startActivity(intent);
                      break;
                  case  1:
                      intent=new Intent(getActivity(),MyNoteActivity.class);
                      startActivity(intent);
                      break;
              }
        }
    };
}

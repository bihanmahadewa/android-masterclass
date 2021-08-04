package com.bihanmahadewa.dominospizza;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Tandoori Chicken", "Tandoori oven baked shredded chicken breasts, onion, and capsicum", "989", "https://images.dominos.co.in/srilanka/Tandoori_Chicken.png"));
        productList.add(new Product("Hot Chili Chicken", "Quick fried hot chili chicken, capsicum, onion, red paprika slices and devil sauce", "989", "https://images.dominos.co.in/srilanka/Devil_Chicken.png"));
        productList.add(new Product("Texas BBQ Chicken", "Prepared Texas BBQ chicken, Mango BBQ sauce, Herb Tomato blend, 100% real mozzarella", "939", "https://images.dominos.co.in/srilanka/cheesebbq.png"));

        ListView productListView = view.findViewById(R.id.product_list_view);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), productList);
        productListView.setAdapter(productAdapter);

        productListView.setDivider(null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}
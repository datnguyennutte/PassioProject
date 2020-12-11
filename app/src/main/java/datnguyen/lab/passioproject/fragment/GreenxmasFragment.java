package datnguyen.lab.passioproject.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import datnguyen.lab.passioproject.R;
import datnguyen.lab.passioproject.adapter.RecyclerOrderAdapter;
import datnguyen.lab.passioproject.model.Drink;

public class GreenxmasFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Drink> drinkList;

    public GreenxmasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Choco Xmas (L)", 55000, R.drawable.ic_choco_xmas));
        drinkList.add(new Drink("Cookie XMas", 55000, R.drawable.ic_cooikie_xmas));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_greenxmas, container, false);
        recyclerView = v.findViewById(R.id.greenxmas_recyclerview);
        RecyclerOrderAdapter recyclerOrderAdapter = new RecyclerOrderAdapter(getContext(), drinkList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerOrderAdapter);

        return v;
    }


}
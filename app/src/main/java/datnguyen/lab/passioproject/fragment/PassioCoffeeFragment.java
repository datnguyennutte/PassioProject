package datnguyen.lab.passioproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import datnguyen.lab.passioproject.R;
import datnguyen.lab.passioproject.adapter.RecyclerOrderAdapter;
import datnguyen.lab.passioproject.model.Drink;

public class PassioCoffeeFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Drink> drinkList;

    public PassioCoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Iced Espresso", 25000, R.drawable.ic_iced_espresso));
        drinkList.add(new Drink("Iced Americano", 34000, R.drawable.ic_ice_americano));
        drinkList.add(new Drink("Iced Americano With Milk", 25000, R.drawable.ic_ice_americano));
        drinkList.add(new Drink("Iced Capuchino", 40000, R.drawable.ic_iced_espresso));
        drinkList.add(new Drink("Iced Cafe Latte", 40000, R.drawable.ic_late));
        drinkList.add(new Drink("Espresso Bạc Xĩu", 25000, R.drawable.ic_bac_siu));
        drinkList.add(new Drink("Hot Latte", 35000, R.drawable.ic_ice_cafe_latte));
        drinkList.add(new Drink("Hot Americano", 29000, R.drawable.ic_hot_americano));
        drinkList.add(new Drink("Espresso Bạc Xĩu", 25000, R.drawable.ic_bac_siu));
        drinkList.add(new Drink("Hot Latte", 35000, R.drawable.ic_ice_cafe_latte));
        drinkList.add(new Drink("Hot Americano", 29000, R.drawable.ic_hot_americano));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_passio_coffee, container, false);

        recyclerView = v.findViewById(R.id.passiocoffe_recyclerview);
        RecyclerOrderAdapter recyclerOrderAdapter = new RecyclerOrderAdapter(getContext(), drinkList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerOrderAdapter);

        return v;
    }
}
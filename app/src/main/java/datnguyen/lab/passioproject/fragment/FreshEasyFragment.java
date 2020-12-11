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


public class FreshEasyFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Drink> drinkList;

    public FreshEasyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Chanh Tuyết", 29000, R.drawable.ic_chanh_tuyet));
        drinkList.add(new Drink("Mojito Tea", 39000, R.drawable.ic_passio_choco));
        drinkList.add(new Drink("Pink Lady Iced Tea (L)", 42000, R.drawable.ic_pinky_sumer));
        drinkList.add(new Drink("Chanh Tuyết", 29000, R.drawable.ic_chanh_tuyet));
        drinkList.add(new Drink("Mojito Tea", 39000, R.drawable.ic_passio_choco));
        drinkList.add(new Drink("Pink Lady Iced Tea (L)", 42000, R.drawable.ic_pinky_sumer));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fresh_easy, container, false);

        recyclerView = v.findViewById(R.id.fresh_easy_recyclerview);
        RecyclerOrderAdapter recyclerOrderAdapter = new RecyclerOrderAdapter(getContext(), drinkList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerOrderAdapter);
        return v;
    }
}
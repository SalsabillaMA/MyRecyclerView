package id.sch.smktelkom.www.myrecyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom.www.myrecyclerview.adapter.CardViewAnimalAdapter;
import id.sch.smktelkom.www.myrecyclerview.adapter.GridAnimalAdapter;
import id.sch.smktelkom.www.myrecyclerview.adapter.ListAnimalAdapter;
import id.sch.smktelkom.www.myrecyclerview.model.Animal;
import id.sch.smktelkom.www.myrecyclerview.model.AnimalsData;

public class MainActivity extends AppCompatActivity {
    private String title = "Mode List";
    private RecyclerView rvAnimals;
    private ArrayList<Animal> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTittle(title);

        rvAnimals = findViewById(R.id.rv_animal);
        rvAnimals.setHasFixedSize(true);

        list.addAll(AnimalsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        ListAnimalAdapter listAnimalAdapter = new ListAnimalAdapter(list);
        rvAnimals.setAdapter(listAnimalAdapter);

        listAnimalAdapter.setOnItemClickCallback(new ListAnimalAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Animal data) {
                showSelectedAnimal(data);
            }
        });
    }

    private void showRecycleGrid() {
        rvAnimals.setLayoutManager(new GridLayoutManager(this, 2));
        GridAnimalAdapter gridAnimalAdapter = new GridAnimalAdapter(list);
        rvAnimals.setAdapter(gridAnimalAdapter);

        gridAnimalAdapter.setOnItemClickCallback(new GridAnimalAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Animal data) {
                showSelectedAnimal(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        CardViewAnimalAdapter cardViewAnimalAdapter = new
                CardViewAnimalAdapter(list);
        rvAnimals.setAdapter(cardViewAnimalAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_gird:
                title = "Mode Grid";
                showRecycleGrid();
                break;
            case R.id.action_cardview:
                title = "Mode Card View";
                showRecyclerCardView();
                break;
        }
        setActionBarTittle(title);
    }


    private void setActionBarTittle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedAnimal(Animal animal) {
        Toast.makeText(this, "Kamu memilih " + animal.getName(),
                Toast.LENGTH_SHORT).show();
    }


}
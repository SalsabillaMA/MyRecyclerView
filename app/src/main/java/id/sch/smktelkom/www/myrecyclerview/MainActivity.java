package id.sch.smktelkom.www.myrecyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom.www.myrecyclerview.model.Animal;
import id.sch.smktelkom.www.myrecyclerview.model.AnimalsData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAnimals;
    private ArrayList<Animal> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAnimals = findViewById(R.id.rv_animal);
        rvAnimals.setHasFixedSize(true);

        list.addAll(AnimalsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        ListAnimalAdapter listAnimalAdapter = new ListAnimalAdapter(list);
        rvAnimals.setAdapter(listAnimalAdapter);
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
                showRecyclerList();
                break;
            case R.id.action_gird:
                showRecycleGrid();
                break;
            case R.id.action_cardview:
                break;
        }
    }

    private void showRecycleGrid() {
        rvAnimals.setLayoutManager(new GridLayoutManager(this, 2));
        GridAnimalAdapter gridAnimalAdapter = new GridAnimalAdapter(list);
        rvAnimals.setAdapter(gridAnimalAdapter);

    }

}
package id.gdev.androidrecyclerviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gdev.androidrecyclerviewgridview.adapter.MenuAdapter;
import id.gdev.androidrecyclerviewgridview.model.Data;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
        rvMenu.setHasFixedSize(true);

        MenuAdapter adapter = new MenuAdapter(getData());
        rvMenu.setAdapter(adapter);
        adapter.setOnMenuClick(new MenuAdapter.OnMenuClick() {
            @Override
            public void onMenuClicked(String title) {
                Toast.makeText(MainActivity.this, title + " Clicked !", Toast.LENGTH_LONG).show();
            }
        });

    }

    private List<Data> getData() {
        List<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.ic_launcher_background, "Wisata"));
        data.add(new Data(R.drawable.ic_launcher_background, "Hotel"));
        data.add(new Data(R.drawable.ic_launcher_background, "Transportasi"));
        data.add(new Data(R.drawable.ic_launcher_background, "Kuliner"));
        data.add(new Data(R.drawable.ic_launcher_background, "SPBU"));
        data.add(new Data(R.drawable.ic_launcher_background, "No Darurat"));
        return data;
    }
}

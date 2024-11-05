package com.example.ruta2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class SearchRouteActivity extends AppCompatActivity {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private RouteAdapter routeAdapter;
    private List<String> busRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_route);

        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the list of bus routes
        busRoutes = new ArrayList<>();
        busRoutes.add("Route 1 - Downtown");
        busRoutes.add("Route 2 - Uptown");
        busRoutes.add("Route 3 - Suburbs");
        busRoutes.add("Route 4 - University");
        // Add more routes as needed

        // Set up RecyclerView with an adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        routeAdapter = new RouteAdapter(busRoutes);
        recyclerView.setAdapter(routeAdapter);

        // Implement search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                routeAdapter.filter(newText); // Filter the route list based on user input
                return true;
            }
        });
    }
}

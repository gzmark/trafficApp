package com.example.ruta2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    private List<String> busRoutes;
    private List<String> busRoutesFiltered;

    public RouteAdapter(List<String> busRoutes) {
        this.busRoutes = busRoutes;
        this.busRoutesFiltered = new ArrayList<>(busRoutes); // Initialize with the full list
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_item, parent, false);  // Use custom route item layout
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {
        String routeName = busRoutesFiltered.get(position);
        holder.routeName.setText(routeName);
        holder.routeDetails.setText("Additional details about " + routeName); // Add dynamic details if available
    }

    @Override
    public int getItemCount() {
        return busRoutesFiltered.size();
    }

    public static class RouteViewHolder extends RecyclerView.ViewHolder {
        public TextView routeName;
        public TextView routeDetails;

        public RouteViewHolder(View itemView) {
            super(itemView);
            routeName = itemView.findViewById(R.id.routeName);
            routeDetails = itemView.findViewById(R.id.routeDetails);
        }
    }

    // Method to filter the list of routes based on search input
    public void filter(String text) {
        busRoutesFiltered.clear();
        if (text.isEmpty()) {
            busRoutesFiltered.addAll(busRoutes);
        } else {
            text = text.toLowerCase();
            for (String route : busRoutes) {
                if (route.toLowerCase().contains(text)) {
                    busRoutesFiltered.add(route);
                }
            }
        }
        notifyDataSetChanged();
    }
}
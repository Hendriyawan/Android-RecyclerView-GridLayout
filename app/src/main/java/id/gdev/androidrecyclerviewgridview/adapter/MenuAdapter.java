package id.gdev.androidrecyclerviewgridview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gdev.androidrecyclerviewgridview.R;
import id.gdev.androidrecyclerviewgridview.model.Data;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    private List<Data> listData;
    private OnMenuClick onMenuClick;


    public MenuAdapter(List<Data> listData) {
        this.listData = listData;
    }

    public void setOnMenuClick(OnMenuClick onMenuClick) {
        this.onMenuClick = onMenuClick;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MenuHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_menu, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder menuHolder, final int position) {
        menuHolder.itemIcon.setImageResource(listData.get(position).getResId());
        menuHolder.itemTitle.setText(listData.get(position).getTitle());
        menuHolder.itemCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuClick.onMenuClicked(listData.get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_cv)
        CardView itemCv;
        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_title)
        TextView itemTitle;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnMenuClick {
        void onMenuClicked(String title);
    }
}

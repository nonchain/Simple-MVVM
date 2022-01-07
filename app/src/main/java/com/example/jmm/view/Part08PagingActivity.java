package com.example.jmm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jmm.R;
import com.example.jmm.adapter.PagingItemAdapter;
import com.example.jmm.model.ItemsList;
import com.example.jmm.viewmodel.ViewModelPaging;

public class Part08PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part08_paging);

        RecyclerView rec_paging = findViewById(R.id.recPaging);
        rec_paging.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        ));

        PagingItemAdapter adapter = new PagingItemAdapter(this);
        ViewModelPaging viewModelPaging = new ViewModelProvider(this).get(ViewModelPaging.class);

        viewModelPaging.items.observe(this, new Observer<PagedList<ItemsList>>() {
            @Override
            public void onChanged(PagedList<ItemsList> itemsLists) {
                adapter.submitList(itemsLists);
            }
        });

        rec_paging.setAdapter(adapter);
    }
}
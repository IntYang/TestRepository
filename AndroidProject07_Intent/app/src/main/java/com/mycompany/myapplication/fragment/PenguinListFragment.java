package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Food;
import com.mycompany.myapplication.dto.Penguin;

import java.util.ArrayList;
import java.util.List;

public class PenguinListFragment extends Fragment {
    private static final String TAG = "PenguinListFragment";
    private ListView listView;
    private List<Penguin> list = new ArrayList<>();
    private ItemAdapter itemAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = (ListView)inflater.inflate(R.layout.fragment_penguin_list, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);

        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=10;i++){

            Penguin penguin = new Penguin();
            penguin.setPno(i);
            penguin.setPname("펭귄"+i);
            penguin.setP_photo(getResources().getIdentifier("penguin"+i, "drawable", getContext().getPackageName()));
            penguin.setPstar(getResources().getIdentifier("star"+(10-i),"drawable",getContext().getPackageName()));
            penguin.setPdesc("펭귄"+i+"이 귀여우면 소리질러요오오오~~~~~~~~~~~~~~~~~~~~");
            addItem(penguin);

        }


    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Penguin penguin = (Penguin) itemAdapter.getItem(position);
            Log.i(TAG, penguin.getPname());
            Log.i(TAG, penguin.getPdesc());
        }
    };

    class ItemAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).getPno();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.penguin_item, null);
            }

            ImageView fphoto = (ImageView) convertView.findViewById(R.id.p_photo);
            TextView fname = (TextView) convertView.findViewById(R.id.pname);
            ImageView fstar = (ImageView) convertView.findViewById(R.id.pstar);
            TextView fdesc = (TextView) convertView.findViewById(R.id.pdesc);

            Penguin penguin = list.get(position);
            fphoto.setImageResource(penguin.getP_photo());
            fname.setText(penguin.getPname());
            fstar.setImageResource(penguin.getPstar());
            fdesc.setText(penguin.getPdesc());

            return convertView;
        }
    }

    public void addItem(Penguin item) {
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Penguin item) {
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }

}

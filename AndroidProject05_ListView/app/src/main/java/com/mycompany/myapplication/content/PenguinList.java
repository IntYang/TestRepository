package com.mycompany.myapplication.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;

import com.mycompany.myapplication.dto.Penguin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-06-29.
 */

public class PenguinList extends LinearLayout {

    private ListView listView;
    private List<Penguin> list = new ArrayList<>();

    private PenguinList.ItemAdapter itemAdapter;

    public PenguinList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.penguin_list, null);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        addView(listView);
    }

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

            ImageView p_photo = (ImageView) convertView.findViewById(R.id.p_photo);
            TextView pname = (TextView) convertView.findViewById(R.id.pname);
            ImageView pstar = (ImageView) convertView.findViewById(R.id.pstar);
            TextView pdesc = (TextView) convertView.findViewById(R.id.pdesc);

            Penguin penguin = list.get(position);
            p_photo.setImageResource(penguin.getP_photo());
            pname.setText(penguin.getPname());
            pstar.setImageResource(penguin.getPstar());
            pdesc.setText(penguin.getPdesc());



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

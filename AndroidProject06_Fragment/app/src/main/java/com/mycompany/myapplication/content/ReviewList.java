package com.mycompany.myapplication.content;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.dto.Review;
import com.mycompany.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewList extends LinearLayout{
    private static final String TAG = ReviewList.class.getSimpleName();
    private ListView listView;
    private List<Review> list = new ArrayList<>();
    private ItemAdapter itemAdapter;



    public ReviewList(Context context) {
        super(context);

        //리스트뷰 생성
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.review_list, null);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);

        //리스트뷰를 내용으로 추가
        addView(listView);
        //리스트뷰 이벤트 처리
        listView.setOnItemClickListener(itemClickListener);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //선택된 item의 데이터 얻기
            Review review = (Review) itemAdapter.getItem(position);
            Log.i(TAG, review.getTitle());
            Log.i(TAG, review.getContent());


        }
    };

    class ItemAdapter extends BaseAdapter{

        @Override
        public int getCount() { // 데이터가 현재 몇개냐
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                //Item UI 객체 생성(Inflation)
                LayoutInflater inflater = LayoutInflater.from(getContext());
               convertView = (LinearLayout) inflater.inflate(R.layout.review_item, null);
            }
            //데이터 세팅
            ImageView photo = (ImageView)  convertView.findViewById(R.id.photo);
            TextView title=(TextView)  convertView.findViewById(R.id.title);
            ImageView star=(ImageView)  convertView.findViewById(R.id.star);
            TextView content=(TextView)  convertView.findViewById(R.id.content);

            Review item = list.get(position);
            photo.setImageResource(item.getPhoto());
            title.setText(item.getTitle());
            star.setImageResource(item.getStar());
            content.setText(item.getContent());
            return  convertView;
        }
    }

    public void addItem(Review item){
        list.add(item);

        //데이터 변경됨을 ItemAdapter에게 알려줌
        itemAdapter.notifyDataSetChanged();
    }
    public void removeItem(Review item){
        list.remove(item);

        //데이터 변경됨을 ItemAdapter에게 알려줌
        itemAdapter.notifyDataSetChanged();
    }
}

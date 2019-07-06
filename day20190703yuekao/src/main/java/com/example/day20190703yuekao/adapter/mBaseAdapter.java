package com.example.day20190703yuekao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day20190703yuekao.R;
import com.example.day20190703yuekao.bean.Bean;

import java.util.List;

public class mBaseAdapter extends BaseAdapter {

    private Context context;
    private List<Bean.DataBean.NewsBean> list;

    public mBaseAdapter(Context context, List<Bean.DataBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        int itemViewType = getItemViewType(i);
        if (itemViewType==1){
            if (convertview==null){
                convertview = View.inflate(context, R.layout.aaa, null);
                holder = new ViewHolder();
                holder.img_view = convertview.findViewById(R.id.img_view);
                holder.tv_titles = convertview.findViewById(R.id.tv_titles);
                holder.tv_description = convertview.findViewById(R.id.tv_description);
                convertview.setTag(holder);
            }else {
                holder = (ViewHolder) convertview.getTag();
            }
            Glide.with(context)
                    .load("http://blog.zhaoliang5156.cn/zixunnew/"+list.get(i).getImageUrl()).into(holder.img_view);

            holder.tv_titles.setText(list.get(i).getTitle());
            holder.tv_description.setText(list.get(i).getPublishAt());

        }else {
            if (convertview==null){
                convertview = View.inflate(context, R.layout.bbb, null);
                holder = new ViewHolder();
                holder.img_view = convertview.findViewById(R.id.img_view);
                holder.tv_titles = convertview.findViewById(R.id.tv_titles);
                holder.tv_description = convertview.findViewById(R.id.tv_description);
                convertview.setTag(holder);
            }else {
                holder = (ViewHolder) convertview.getTag();
            }
            Glide.with(context)
                    .load("http://blog.zhaoliang5156.cn/zixunnew/"+list.get(i).getImageUrl()).into(holder.img_view);

            holder.tv_titles.setText(list.get(i).getTitle());
            holder.tv_description.setText(list.get(i).getPublishAt());
        }


        return convertview;
    }

    class ViewHolder{
        private ImageView img_view;
        private TextView tv_titles;
        private TextView tv_description;
    }
}

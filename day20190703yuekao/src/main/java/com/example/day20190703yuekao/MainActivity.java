package com.example.day20190703yuekao;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day20190703yuekao.adapter.mViewPager;
import com.example.day20190703yuekao.fragment.fragment_1;
import com.example.day20190703yuekao.fragment.fragment_2;
import com.example.day20190703yuekao.fragment.fragment_3;
import com.example.day20190703yuekao.httputils.HttpUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout draw;
    private TabLayout tab;
    private ViewPager viewPager;
    private ImageView iv;
    //创建集合
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //添加选项卡
        titles.add("风景");
        titles.add("美女");
        titles.add("动漫卡通");
        titles.add("娱乐明星");
        titles.add("萌宠");
        //加载视图
        fragments.add(new fragment_1());
        fragments.add(new fragment_2());
        fragments.add(new fragment_3());
        fragments.add(new fragment_3());
        fragments.add(new fragment_3());


        //判断有无网络
        boolean netWork = HttpUtils.isNetWork(MainActivity.this);
        if (netWork!=false){
            Toast.makeText(this, "当前有网络!!!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "当前无网络!!!!", Toast.LENGTH_SHORT).show();

        }


        mViewPager mViewPager = new mViewPager(getSupportFragmentManager(),fragments,titles);

        viewPager.setAdapter(mViewPager);
        //将视图和TabLayout关联起来
        tab.setupWithViewPager(viewPager);


        //点击图像换头像
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101&&data!=null){
            Uri data1 = data.getData();
            Glide.with(MainActivity.this).load(data1)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);

        }

    }

    private void initView() {
        draw = findViewById(R.id.draw);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        iv = findViewById(R.id.iv);
    }


    //点击左上角图片打来侧拉界面
    public void img(View view) {
            draw.openDrawer(Gravity.LEFT);

    }


    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        iv.setOnClickListener(null);
    }
}

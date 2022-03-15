package com.mehboob.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
        private ArrayList<ViewPagerModel> sliderArrayList;
        private Context context;

        public SliderAdapter(ArrayList<ViewPagerModel> sliderArrayList, Context context) {
            this.sliderArrayList = sliderArrayList;
            this.context = context;
        }

        @Override
        public SliderViewHolder onCreateViewHolder(ViewGroup viewGroup) {

            View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, null);
            return new SliderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SliderViewHolder sliderViewHolder, int i) {
            ViewPagerModel model = sliderArrayList.get(i);
            Glide.with(sliderViewHolder.imageView)
                    .load(model.getImage())
                    .fitCenter()
                    .into(sliderViewHolder.imageView);
        }

        @Override
        public int getCount() {
            return sliderArrayList.size();
        }

        public class SliderViewHolder extends SliderViewAdapter.ViewHolder {
            ImageView imageView;

            public SliderViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.myimage);

            }
        }
    }


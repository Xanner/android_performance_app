package com.example.androidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView
        .Adapter<RecycleAdapter.ViewHolder>{
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView
            .ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v){
            super(v);
            TextView mTextView = (TextView) v.findViewById(R.id.textView);
            ImageView mImageView = (ImageView) v.findViewById(R.id.imageView);
            this.mTextView = mTextView;
            this.mImageView = mImageView;
        }
    }

    public RecycleAdapter(String[] myDataset)
    {
        mDataset = myDataset;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);

        RotateAnimation rotate = new RotateAnimation(
                0, 360,

                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setDuration(2000);
        rotate.setRepeatCount(Animation.INFINITE);
        holder.mImageView.startAnimation(rotate);
    }

    @Override
    public int getItemCount()
    {
        return mDataset.length;
    }
}

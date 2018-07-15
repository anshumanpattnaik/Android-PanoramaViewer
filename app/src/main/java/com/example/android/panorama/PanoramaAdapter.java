package com.example.android.panorama;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class PanoramaAdapter extends RecyclerView.Adapter<PanoramaAdapter.PanoramaViewHolder> {

    private Context mContext;

    private ArrayList<Integer> mPanoramaList;
    private IPanoramaClickListener mListener;

    public PanoramaAdapter(Context context, ArrayList<Integer> panoramaList, IPanoramaClickListener listener) {
        this.mContext = context;
        this.mPanoramaList = panoramaList;
        this.mListener = listener;
    }

    @Override
    public PanoramaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_panorama, parent, false);

        return new PanoramaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PanoramaViewHolder holder, final int position) {
        Glide.with(mContext).load(mPanoramaList.get(position))
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.panoImg);
        //holder.panoImg.setImageResource(mPanoramaList.get(position));

        holder.panoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    public class PanoramaViewHolder extends RecyclerView.ViewHolder {

        ImageView panoImg;

        public PanoramaViewHolder(View view) {
            super(view);
            panoImg = (ImageView) view.findViewById(R.id.pano_img);
        }
    }

    @Override
    public int getItemCount() {
        return mPanoramaList.size();
    }
}
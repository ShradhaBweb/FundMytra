package com.example.bcs.fundmytra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class AllProductGridAdapter extends BaseAdapter {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public AllProductGridAdapter(Context context, ArrayList<String> names, ArrayList<Integer> imageUrls) {
        mNames = names;
        mImageUrls = imageUrls;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mImageUrls.size();
    }

    @Override
    public Object getItem(int i) {
        return mImageUrls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_all_list, viewGroup, false);
        ImageView imageView=(ImageView)view.findViewById(R.id.image_view);
        TextView textView=(TextView)view.findViewById(R.id.name);

//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImageUrls.get(i))
//                .into(imageView);

//        byte[] byteimage=mImageUrls.get(i).getImage();
//        ByteArrayInputStream imageStream = new ByteArrayInputStream(byteimage);
//        BitmapFactory.Options op=new BitmapFactory.Options();
//        op.inSampleSize=12;
//        Bitmap theImage= BitmapFactory.decodeStream(imageStream,null,op);

        imageView.setImageResource(mImageUrls.get(i));
        textView.setText(mNames.get(i));

        return view;
    }
}

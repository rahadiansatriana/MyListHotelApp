package id.co.sigma.android.mylisthotelapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Sidiq on 30/08/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<ImageItem> listImage;
    private LayoutInflater mInflater;

    public ImageAdapter(Activity mActivity){
        this.mActivity=mActivity;
        mInflater=LayoutInflater.from(mActivity);
    }

    public ArrayList<ImageItem> getListImage() {
        return listImage;
    }

    public void setListImage(ArrayList<ImageItem> listImage) {
        this.listImage = listImage;
    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view == null){
            view=mInflater.inflate(R.layout.item_row_image,null);
            holder=new ViewHolder();
            holder.imgItem=(ImageView)view.findViewById(R.id.img_item_galley);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }

        Glide.with(mActivity).load(getListImage().get(i).getImageUrl()).into(holder.imgItem);

        return view;
    }

    static class ViewHolder {
        ImageView imgItem;
    }
}

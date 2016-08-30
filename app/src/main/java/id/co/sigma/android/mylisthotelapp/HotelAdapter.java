package id.co.sigma.android.mylisthotelapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Sidiq on 30/08/2016.
 */
public class HotelAdapter extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<HotelItem> data;
    private LayoutInflater mInflater;

    public HotelAdapter(Activity mActivity){
        this.mActivity=mActivity;
        mInflater=LayoutInflater.from(mActivity);
    }

    public ArrayList<HotelItem> getData(){
        return data;
    }

    public void setData(ArrayList<HotelItem> data){
        this.data=data;
    }

    @Override
    public int getCount() {

        return getData().size();
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
            view=mInflater.inflate(R.layout.item_row_hotel,null);
            holder=new ViewHolder();
            holder.imgItem=(ImageView)view.findViewById(R.id.img_item_hotel);
            holder.tvName=(TextView)view.findViewById(R.id.tv_item_name);
            holder.tvLocation=(TextView)view.findViewById(R.id.tv_item_location);
            holder.tvRate=(TextView)view.findViewById(R.id.tv_item_rate);
            holder.tvType=(TextView)view.findViewById(R.id.tv_item_type);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }

        holder.tvName.setText(getData().get(i).getName());
        holder.tvLocation.setText(getData().get(i).getLocation());
        holder.tvType.setText("Bintang : "+getData().get(i).getType());
        holder.tvRate.setText(getData().get(i).getPriceRate());

        Glide.with(mActivity).load(getData().get(i).getImageUrl()).into(holder.imgItem);

        return view;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView tvName,tvType,tvLocation,tvRate;
    }
}

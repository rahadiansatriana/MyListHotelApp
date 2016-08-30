package id.co.sigma.android.mylisthotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
/*  1. model data POJO
    2. create layout item
    3. create adapter
    4. tambah listview di layout activity/Fragment
    5. modifikasi activity/fragment
    6. Permission using internet
  */

    private String[][] data =new String[][]{
            {"Prima In Hotel","3","Jl Gandekan Lor No 47, Malioboro, Yogyakarta, Indonesia","Rp 351,240","http://origin.pegipegi.com/jalan/images/pict2L/Y2/Y969772/Y969772024.jpg"},
            {"Hotel Neo Malioboro","3","Jl. Pasar Kembang No.21, Yogyakarta","Rp 458,000","http://origin.pegipegi.com/jalan/images/pict2L/Y8/Y981228/Y981228037.jpg"},
            {"Jambuluwuk Malioboro Hotel","4","Jl. Gajah Mada No.67, Yogyakarta ","Rp 912,397","http://origin.pegipegi.com/jalan/images/pict2L/Y5/Y935905/Y935905056.jpg"},
            {"Hotel Melia Purosani","5","Jl. Suryotomo No.31, Yogyakarta","Rp 798,000","http://origin.pegipegi.com/jalan/images/pict2L/Y0/Y920390/Y920390010.jpg"},
            {"Inna Garuda Hotel","4","Jl. Malioboro No.60, Suryatmajan, Danurejan, Yogyakarta","Rp 557,851","http://origin.pegipegi.com/jalan/images/pict2L/Y8/Y927168/Y927168030.jpg"}
    };

    private ListView lvItem;
    private ArrayList<HotelItem> listHotel;
    private HotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem=(ListView)findViewById(R.id.lv_item);
        listHotel=new ArrayList<HotelItem>();
        adapter=new HotelAdapter(MainActivity.this);
        adapter.setData(listHotel);

        lvItem.setAdapter(adapter);

        HotelItem item=null;
        for(int i=0;i<data.length;i++){
            item=new HotelItem();
            item.setName(data[i][0]);
            item.setType(Integer.parseInt(data[i][1]));
            item.setLocation(data[i][2]);
            item.setPriceRate(data[i][3]);
            item.setImageUrl(data[i][4]);

            listHotel.add(item);
        }
        adapter.setData(listHotel);
        adapter.notifyDataSetChanged();
        lvItem.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent mIntent=new Intent(MainActivity.this,DetailHotelActivity.class);
        mIntent.putExtra(DetailHotelActivity.EXTRA_HOTEL,listHotel.get(i));
        startActivity(mIntent);
    }
}

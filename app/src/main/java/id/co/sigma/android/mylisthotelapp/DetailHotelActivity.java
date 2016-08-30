package id.co.sigma.android.mylisthotelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailHotelActivity extends AppCompatActivity {
    ImageView imgHotel;
    TextView tvLocation, tvRate, tvType;
    Button btnBook;
    GridView gvGallery;

    ArrayList<ImageItem> listImage;
    ImageAdapter adapter;

    String[] images = new String[]{
            "http://origin.pegipegi.com/jalan/images/pictL/Y5/Y935905/Y935905067.jpg",
            "http://origin.pegipegi.com/jalan/images/pict2L/Y5/Y935905/Y935905055.jpg",
            "http://origin.pegipegi.com/jalan/images/pict2L/Y5/Y935905/Y935905056.jpg",
            "http://origin.pegipegi.com/jalan/images/pict2L/Y5/Y935905/Y935905058.jpg",
            "http://origin.pegipegi.com/jalan/images/pict2L/Y5/Y935905/Y935905060.jpg",
            "http://origin.pegipegi.com/jalan/images/pictL/Y5/Y935905/Y935905057.jpg"
    };

    public static String EXTRA_HOTEL="extra_hotel";
    private HotelItem mHotelItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        mHotelItem=getIntent().getParcelableExtra(EXTRA_HOTEL);

        getSupportActionBar().setTitle(mHotelItem.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgHotel = (ImageView) findViewById(R.id.img_detail);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvRate = (TextView) findViewById(R.id.tv_rate);
        tvType = (TextView) findViewById(R.id.tv_type);
        btnBook = (Button) findViewById(R.id.btn_book);
        gvGallery = (GridView) findViewById(R.id.gv_gallery);

        tvType.setText("Bintang : "+mHotelItem.getType());
        tvLocation.setText(mHotelItem.getLocation());
        tvRate.setText(mHotelItem.getPriceRate());
        Glide.with(DetailHotelActivity.this).load(mHotelItem.getImageUrl()).into(imgHotel);


        listImage = new ArrayList<>();
        adapter = new ImageAdapter(DetailHotelActivity.this);
        adapter.setListImage(listImage);
        gvGallery.setAdapter(adapter);

        ImageItem imgItem=null;
        for(String item: Arrays.asList(images)){
            imgItem=new ImageItem();
            imgItem.setImageUrl(item);
            listImage.add(imgItem);
        }

        adapter.setListImage(listImage);
        adapter.notifyDataSetChanged();

    }
}

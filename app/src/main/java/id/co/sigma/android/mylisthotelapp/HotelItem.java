package id.co.sigma.android.mylisthotelapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sidiq on 30/08/2016.
 */
public class HotelItem implements Parcelable {
    private String name;
    private int type;
    private String location;
    private String priceRate;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.type);
        dest.writeString(this.location);
        dest.writeString(this.priceRate);
        dest.writeString(this.imageUrl);
    }

    public HotelItem() {
    }

    protected HotelItem(Parcel in) {
        this.name = in.readString();
        this.type = in.readInt();
        this.location = in.readString();
        this.priceRate = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<HotelItem> CREATOR = new Parcelable.Creator<HotelItem>() {
        @Override
        public HotelItem createFromParcel(Parcel source) {
            return new HotelItem(source);
        }

        @Override
        public HotelItem[] newArray(int size) {
            return new HotelItem[size];
        }
    };
}

package com.example.c4q.examapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c4q on 1/9/18.
 */

public class PokeModel implements Parcelable{
    public int id;
    public String name;
    public int height;
    public Abilities[] abilities;
    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PokeModel(){

    }

    public Abilities[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }

    protected PokeModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        height = in.readInt();
    }

    public static final Creator<PokeModel> CREATOR = new Creator<PokeModel>() {
        @Override
        public PokeModel createFromParcel(Parcel in) {
            return new PokeModel(in);
        }

        @Override
        public PokeModel[] newArray(int size) {
            return new PokeModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(height);
        dest.writeArray(abilities);
        dest.writeString(url);
    }
}

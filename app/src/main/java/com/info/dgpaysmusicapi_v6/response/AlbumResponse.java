package com.info.dgpaysmusicapi_v6.response;

import com.google.gson.annotations.SerializedName;
import com.info.dgpaysmusicapi_v6.model.Album;

import java.util.List;

public class AlbumResponse {
    @SerializedName("data")
    private List<Album> data;

    public List<Album> getData() {
        return data;
    }

    public void setData(List<Album> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AlbumResponse{" +
                "data=" + data +
                '}';
    }
}

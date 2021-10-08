package com.info.dgpaysmusicapi_v6.response;

import com.google.gson.annotations.SerializedName;
import com.info.dgpaysmusicapi_v6.model.Tracks;

import java.util.List;

public class TrackResponse {

    @SerializedName("data")
    private List<Tracks> data;

    public List<Tracks> getData() {
        return data;
    }

    public void setData(List<Tracks> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrackResponse{" +
                "data=" + data +
                '}';
    }
}

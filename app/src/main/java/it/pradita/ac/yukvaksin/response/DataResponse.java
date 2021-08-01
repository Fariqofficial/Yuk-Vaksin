package it.pradita.ac.yukvaksin.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.pradita.ac.yukvaksin.model.Data;

public class DataResponse {

    @Expose
    @SerializedName("message")
    String message;

    @Expose
    @SerializedName("data")
    List<Data> lisData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getLisData() {
        return lisData;
    }

    public void setLisData(List<Data> lisData) {
        this.lisData = lisData;
    }
}

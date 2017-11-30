package com.emptryrunningproject;


import org.json.JSONObject;

/**
 * Created by manish on 11/27/2015.
 */
public interface CommonListioner {
//    public void onLoadFailVolleyError(VolleyError error);
void onLoadFail(JSONObject error);
    void onLoadSuccess(JSONObject success);
}

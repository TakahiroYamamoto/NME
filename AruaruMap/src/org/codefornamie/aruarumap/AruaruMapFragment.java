package org.codefornamie.aruarumap;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class AruaruMapFragment extends MapFragment {
	GoogleMap mMap = null;
	HashMap<Integer, Marker> mMarkers = new HashMap<Integer, Marker>();
	Context mContext = null;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mContext = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View returnedView = super.onCreateView(inflater, container, savedInstanceState);
		if(mMap == null) {
			Log.i("AruaruMap", "onCreateView");
			mMap = getMap();
			mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {

				@Override
				public void onMapLoaded() {
					Log.i("AruaruMap", "onMapLoaded");
					// TODO Auto-generated method stub
					mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4833,141.0000), 13));
					try {
						JSONArray jarray = new JSONArray(mContext.getString(R.string.address_list));
						setMarkers(jarray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		return returnedView;
	}

	public void setMarkers(JSONArray jarray) {
		LatLngBounds.Builder builder = new LatLngBounds.Builder();
		int c = 0;
		LatLng pos = null;
		for(int i = 0 ; i < jarray.length() ; i++) {
			JSONObject json = jarray.optJSONObject(i);
			if(json != null) {
				Integer key = json.optInt("key");
				MarkerOptions marker = new MarkerOptions();
				marker.title(json.optString("name"));
				marker.snippet(json.optString("currentAddress"));
				Geocoder gc = new Geocoder(mContext);
				try {
					Address addr = gc.getFromLocationName(json.optString("currentAddress"), 1).get(0);
					pos = new LatLng(addr.getLatitude(), addr.getLongitude());
					marker.position(pos);
					if("male".equals(json.optString("sex")))
						marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_male_green));
					else
						marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_female_green));
					mMarkers.put(key, mMap.addMarker(marker));
					builder.include(pos);
					c++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(c > 0) {
			LatLngBounds bounds = builder.build();
			mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 64));
		}
	}
}

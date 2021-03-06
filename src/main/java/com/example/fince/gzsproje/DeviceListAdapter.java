package com.example.fince.gzsproje;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fince on 24.11.2017.
 */

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<BluetoothDevice> mDevices;
    private int mViewResourceId;
    public DeviceListAdapter(Context baseContext, int device_adapter_view, ArrayList<BluetoothDevice> mBTDevices) {
        super(baseContext,device_adapter_view,mBTDevices);
        this.mDevices=mBTDevices;
        mLayoutInflater=(LayoutInflater)baseContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId=device_adapter_view;
    }
    public View getView(int position , View convertView, ViewGroup parent){
        convertView=mLayoutInflater.inflate(mViewResourceId,null);
        BluetoothDevice device=mDevices.get(position);

        if(device != null){
            TextView deviceName=(TextView)convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAdress=(TextView)convertView.findViewById(R.id.tvDeviceAddress);

            if(deviceName != null){
                deviceName.setText(device.getName());
            }
            if(deviceAdress != null){
                deviceAdress.setText(device.getAddress());
            }
        }
        return convertView;
    }
}

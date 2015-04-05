package com.speedometer;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Formatter;
import java.util.Locale;


public class MainActivity extends ActionBarActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager lm=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        this.onLocationChanged(null);
    }


    @Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

   // @Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
            //return true;
        //}

       // return super.onOptionsItemSelected(item);
    //}

    //@Override
    public void onLocationChanged(Location location) {

        TextView tvSpeed=(TextView) this.findViewById(R.id.tvSpeed);
        tvSpeed.setRotationX(180);
        //tvSpeed.setScaleX(-1);
        if(location==null) {
            tvSpeed.setText("-,- m/h");
        }
        else
        {
            float nCurrentSpeed=location.getSpeed();
            //tvSpeed.setText(nCurrentSpeed+" m/s");

            Formatter fmt = new Formatter(new StringBuilder());
            fmt.format(Locale.US, "%5.1f", nCurrentSpeed);
            String strCurrentSpeed = fmt.toString();
            strCurrentSpeed = strCurrentSpeed.replace(' ', '0');

            String strUnits = "m/h";


            TextView txtCurrentSpeed = (TextView) this.findViewById(R.id.tvSpeed);


            tvSpeed.setText(strCurrentSpeed + " " + strUnits);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }




}

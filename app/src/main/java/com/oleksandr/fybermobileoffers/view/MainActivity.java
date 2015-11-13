package com.oleksandr.fybermobileoffers.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oleksandr.fybermobileoffers.R;
import com.oleksandr.fybermobileoffers.data.OffersResponse;
import com.oleksandr.fybermobileoffers.network.QueryParams;
import com.oleksandr.fybermobileoffers.network.RetrofitService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class MainActivity extends AppCompatActivity {

    CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(new VariableParamsDialog(), VariableParamsDialog.class.getCanonicalName()).commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        mCompositeSubscription.clear();
        mCompositeSubscription.unsubscribe();
        super.onDestroy();
    }

    public void sendRequest(String appid, String uid, String pub0) {
        RetrofitService retrofitService = new RetrofitService();
        Map<String, String> params = new HashMap<>();
        params.put(QueryParams.FORMAT, "json");
        params.put(QueryParams.APPID, appid);
        params.put(QueryParams.UID, uid);
        params.put(QueryParams.LOCALE, Locale.getDefault().getLanguage());
        params.put(QueryParams.OS_VERSION, android.os.Build.VERSION.RELEASE);
        long unixTime = System.currentTimeMillis() / 1000L;
        params.put(QueryParams.TIMESTAMP, Long.toString(unixTime));
        params.put(QueryParams.HASHKEY, "eff26c67f527e6817bf6935c75f8cc5cc5cffac2");
        params.put(QueryParams.PUBO, pub0);
        Subscription subscription = retrofitService.getOffers(params).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<OffersResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OffersResponse offersResponse) {

            }
        });
        mCompositeSubscription.add(subscription);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

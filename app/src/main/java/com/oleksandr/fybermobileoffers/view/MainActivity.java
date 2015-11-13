package com.oleksandr.fybermobileoffers.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oleksandr.fybermobileoffers.Constants;
import com.oleksandr.fybermobileoffers.R;
import com.oleksandr.fybermobileoffers.data.OffersResponse;
import com.oleksandr.fybermobileoffers.network.QueryParams;
import com.oleksandr.fybermobileoffers.network.RetrofitService;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

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

    private Map<String, String> getTextRequestParams(Map<String, String> params) {
        params.put(QueryParams.APPID, "157");
        params.put(QueryParams.UID, "player1");
        params.put(QueryParams.IP, "212.45.111.17");
        params.put(QueryParams.LOCALE, "de");
        params.put(QueryParams.DEVICE_ID, "2b6f0cc904d137be2e1730235f5664094b831186");
        params.put(QueryParams.PS_TIME, "1312211903");
        params.put(QueryParams.PUBO, "campaign2");
        params.put(QueryParams.PAGE, "2");
        params.put(QueryParams.TIMESTAMP, "1312553361");
        return params;
    }


    public void sendRequest(String appid, String uid, String pub0) {
        RetrofitService retrofitService = new RetrofitService();
        Map<String, String> params = new TreeMap<>();
        params.put(QueryParams.FORMAT, "json");
        params.put(QueryParams.APPID, appid);
        params.put(QueryParams.UID, uid);
        params.put(QueryParams.LOCALE, Locale.getDefault().getLanguage());
        params.put(QueryParams.OS_VERSION, android.os.Build.VERSION.RELEASE);
        long unixTime = System.currentTimeMillis() / 1000L;
        params.put(QueryParams.TIMESTAMP, Long.toString(unixTime));
        params.put(QueryParams.PUBO, pub0);
        Subscription subscription = retrofitService.getOffers(getRequestParams(params)).subscribeOn(Schedulers.io()).
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

    private Map<String, String> getRequestParams(Map<String, String> params) {
        StringBuilder hashKey = new StringBuilder();
        for (String key : params.keySet()) {
            hashKey.append(key).append("=").append(params.get(key)).append("&");
        }
        hashKey.append(Constants.api_key);
        try {
            params.put(QueryParams.HASHKEY, SHA1(hashKey.toString()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return params;

    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte aData : data) {
            int halfByte = (aData >>> 4) & 0x0F;
            int twoHalfs = 0;
            do {
                if ((0 <= halfByte) && (halfByte <= 9)) {
                    buf.append((char) ('0' + halfByte));
                } else {
                    buf.append((char) ('a' + (halfByte - 10)));
                }
                halfByte = aData & 0x0F;
            } while (twoHalfs++ < 1);
        }
        return buf.toString();
    }


    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash;
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
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

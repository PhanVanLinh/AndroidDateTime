package toong.vn.androiddatetime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = (TextView) findViewById(R.id.text_time);
        findViewById(R.id.button_get_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTime.setText("" + "" + (System.currentTimeMillis() / 1000));
            }
        });

        parseDateWithoutTimeZone();
    }

    /**
     * Out put:
     * Hour = 10 if time zone is +8
     * Hour = 9 if time zone is +7
     * ...
     */
    private void parseDateWithTimeZone() {
        String aTime = "2017-10-25T11:39:00+09:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(aTime));
            Log.i(TAG, "time = " + cal.getTimeInMillis());
            Log.i(TAG, "hour = " + cal.get(Calendar.HOUR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseDateWithoutTimeZone(){
        String aTime = "2017-10-25T11:39:00+13:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(aTime));
            Log.i(TAG, "time = " + cal.getTimeInMillis());
            Log.i(TAG, "hour = " + cal.get(Calendar.HOUR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

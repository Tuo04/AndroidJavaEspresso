package androidespresso.androidespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileCenter.start(getApplication(), "ac928cc1-deda-4c65-ac27-be76323fea20",
                Analytics.class, Crashes.class);

        editText = (EditText) findViewById(R.id.inputField);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;
        }

    }
}

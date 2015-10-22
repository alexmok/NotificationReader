package stuff.mok.notificationreader;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends Activity {
    ListView displayList;
    HashMap<String, MessageModel> activeNotifications = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayList = (ListView) findViewById(R.id.displayList);

        LocalBroadcastManager.getInstance(this).registerReceiver(onReceiveMessage, new IntentFilter("Notification Msg"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    private BroadcastReceiver onReceiveMessage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.hasExtra("title")) {
                String packageName = intent.getStringExtra("package");
                String title = intent.getStringExtra("title");
                String text = intent.getStringExtra("text");

                if(!activeNotifications.containsKey(packageName)) {
                    MessageModel curMsg = new MessageModel(packageName, title, text);
                    activeNotifications.put(packageName, curMsg);
                } else {
                    activeNotifications.get(packageName).getTexts().add(text);
                }

                for(String key : activeNotifications.keySet()){

                }
//                displayView.setText("Package Name: " + packageName + "\nTitle: " + title + "\nMessage: " + text);
            } else {
                String packageName = intent.getStringExtra("package");

                if(activeNotifications.containsKey(packageName)){
                    activeNotifications.remove(packageName);
                }
            }
        }
    };
}

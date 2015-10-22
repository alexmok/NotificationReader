package stuff.mok.notificationreader;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alexander on 10/22/2015.
 */
public class DisplayListAdapter extends ArrayAdapter<String>{
    private Context context;
//    private MessageModel msg;
    private String[] keys;
    private HashMap<String, MessageModel> activeNotifications;

    public DisplayListAdapter(Context context, String[] keys, HashMap<String, MessageModel> activeNotifications){
        super(context, R.layout.displaylist_layout, keys);
        this.context = context;
//        this.msg = msg;
        this.keys = keys;
        this.activeNotifications = activeNotifications;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.displaylist_layout, parent, false);
        TextView packageName = (TextView) rowView.findViewById(R.id.packageName);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView message = (TextView) rowView.findViewById(R.id.message);

        MessageModel msg = activeNotifications.get(keys[position]);

        packageName.setText(msg.getPackageName());
        title.setText(msg.getTitle());

        String messages = "";

        for(int i = 0; i < msg.getTexts().size(); i++){
            if(i == 0){
                messages = msg.getTexts().get(i);
            } else {
                messages = messages + "\n" + msg.getTexts().get(i);
            }
        }

        message.setText(messages);

        return rowView;

    }
}

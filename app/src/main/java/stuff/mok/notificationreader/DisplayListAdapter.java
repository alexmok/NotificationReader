package stuff.mok.notificationreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Alexander on 10/22/2015.
 */
public class DisplayListAdapter extends ArrayAdapter<String>{
    private Context context;
    private String[] values;

    public DisplayListAdapter(Context context, String[] values){
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.displaylist_layout, parent, false);
        TextView packageName = (TextView) rowView.findViewById(R.id.packageName);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView message = (TextView) rowView.findViewById(R.id.message);



        return rowView;

    }
}

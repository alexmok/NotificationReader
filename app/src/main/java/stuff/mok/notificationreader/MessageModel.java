package stuff.mok.notificationreader;

import java.util.ArrayList;

/**
 * Created by Alexander on 10/22/2015.
 */
public class MessageModel {
    private String packageName;
    private String title;
    private ArrayList<String> texts = new ArrayList<String>();

    public MessageModel(String packageName, String title, String text){
        this.packageName = packageName;
        this.title = title;
        texts.add(text);
    }

    public void addTextToList(String text){
        texts.add(text);
    }

    public ArrayList<String> getTexts(){
        return texts;
    }
}

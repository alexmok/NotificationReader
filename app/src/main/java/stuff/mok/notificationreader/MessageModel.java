package stuff.mok.notificationreader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alexander on 10/22/2015.
 */
public class MessageModel {
    private String packageName;
    private ArrayList<String> titles = new ArrayList<>();
    private HashMap<String, ArrayList<String>> titleToMessageMap = new HashMap<>();
    private ArrayList<String> texts = new ArrayList<>();

    public MessageModel(String packageName, String title, String text){
        this.packageName = packageName;
        if(!titles.contains(title)){
            titles.add(title);
        }
        texts.add(text);
        titleToMessageMap.put(title, texts);
    }

    public void addTextToList(String text, String title){
        titleToMessageMap.get(title).add(text);
    }

    public ArrayList<String> getTexts(String title){
        return titleToMessageMap.get(title);
    }

    public String getPackageName(){
        return packageName;
    }

    public ArrayList<String> getTitles(){
        return titles;
    }

    public void addTitleToList(String text, String title){
        titles.add(title);
        ArrayList<String> newText = new ArrayList<>();
        newText.add(text);
        titleToMessageMap.put(title, newText);
    }
}

package com.example.capitalizationapplication.pack;

// https://www.w3schools.com/java/java_arraylist.asp
import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import com.example.capitalizationapplication.MainActivity;
import com.example.capitalizationapplication.R;

import java.util.ArrayList;


// https://beginnersbook.com/2015/05/java-string-to-arraylist-conversion/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChangeCapitalization {
    //current string
    ArrayList<String> currentState;




//    https://stackoverflow.com/questions/10996479/how-to-update-a-textview-of-an-activity-from-another-class/27939196
    Context context;

    //default constructor
//    https://stackoverflow.com/questions/10996479/how-to-update-a-textview-of-an-activity-from-another-class/27939196
    public ChangeCapitalization(Context context){

        //initialize member variables
        currentState = new ArrayList<String>();
        this.context = context;
    }

    public void upperCapitalize(){

        getInputString();

        for (int i = 0; i < currentState.size() ; i++)
        {
            currentState.set(i, currentState.get(i).toUpperCase());
        }

        //code below to update textField with setText("...")
        updateText();

    }

    public void lowerCapitalize(){

        getInputString();

        for (int i = 0; i < currentState.size() ; i++)
        {
            currentState.set(i, currentState.get(i).toLowerCase());
        }
        //code below to update textField with setText("...")

        updateText();
    }

    public void normalCapitalize(){

        getInputString();

        // put everything in lowercase
        for (int i = 0; i < currentState.size() ; i++)
        {
            currentState.set(i, currentState.get(i).toLowerCase());
        }

        for (int i = 0; i < currentState.size() ; i++)
        {
            // https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
            if (i == 0)
                currentState.set(i, currentState.get(i).substring(0, 1).toUpperCase() + currentState.get(i).substring(1));
            if (i != 0)
                if (currentState.get(i-1).endsWith("."))
                    currentState.set(i, currentState.get(i).substring(0, 1).toUpperCase() + currentState.get(i).substring(1));
// TODO: move second if block above to first if block, a la i == 0 || currentState.get(i-1).endsWith(".")
        }
        //code below to update textField with setText("...")

        updateText();

    }


    public void titleCase(){

        getInputString();

        // put everything in lowercase
        for (int i = 0; i < currentState.size() ; i++)
        {
            currentState.set(i, currentState.get(i).toLowerCase());
        }

        for (int i = 0; i < currentState.size() ; i++)
        {
            // https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
            currentState.set(i, currentState.get(i).substring(0, 1).toUpperCase() + currentState.get(i).substring(1));

        }
        //code below to update textField with setText("...")
        updateText();
    }

//    https://stackoverflow.com/questions/10996479/how-to-update-a-textview-of-an-activity-from-another-class/27939196
    public void updateText(){

        String string = "";

//        https://www.geeksforgeeks.org/java-string-concat-examples/
        for (int i = 0; i < currentState.size(); i++)
            string = string.concat(currentState.get(i) + " ");

        //code below to update textField with setText("...")
        EditText editText = (EditText) ((MainActivity)context).findViewById(R.id.textField);
        editText.setText(string);
    }

    //parses textfield and moves it into current, original, and previous Arraylist<String>s
    public void getInputString(){
        String string;
        EditText editText = (EditText) ((MainActivity)context).findViewById(R.id.textField);

//        https://stackoverflow.com/questions/5324941/get-text-string-from-edittext/11706585
        string = editText.getText().toString();

        // https://beginnersbook.com/2015/05/java-string-to-arraylist-conversion/
//        https://www.jackrutorial.com/2018/06/java-split-string-by-space-and-newline.html
        String str[] = string.split(" ");
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(str);


        // https://stackoverflow.com/questions/5134466/how-to-cast-arraylist-from-list/41136009
        currentState = new ArrayList<String>(list);
    }

}

package com.example.daliys.mios;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by daliys on 04.07.17.
 */

public class Video extends Activity {
    private static final String fileName = "Redactor.txt";
    private static final String text = "Hello World";

    TextView TextMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        TextMess = (TextView)findViewById(R.id.TextMess);

      //  CreateFile();
        ShowDirectFiles();

    }
    public void listf(String msHowa, ArrayList<File> files) {
        File directory = new File (msHowa);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
                Log.e("Files",file.getAbsolutePath()+"");
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
    private void ShowDirectFiles(){

  //    listf("/",null);

        File msHowa = new File(getExternalFilesDir("/msHowa").getPath());
        File[] files = msHowa.listFiles();
        if(files != null) {
            for (File life : files) {
                TextMess.setText(files + "" + life);
                Log.e("Fiel",life+"   ");
            }
        }else{
            Log.e("Filese","NULL");
        }

    }

    private void CreateFile() {

        for (int a = 0; a < 10; a++) {

            String bc = "";
            int ran = (5 + new Random().nextInt(10));

            for (int q = 0; q < ran; q++) {
                char rc = (char) ('A' + new Random().nextInt(26));
                bc += rc;
            }


            File files = new File(getExternalFilesDir("/msHowa"), "qqqq.txt");
            try {
                files.createNewFile();
            } catch (Exception e) {}
        }
    }

}

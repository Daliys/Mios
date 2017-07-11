package com.example.daliys.mios;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by daliys on 04.07.17.
 */

public class SettingsBody extends Activity{
    ImageView main_body1,main_body2;
    ImageView image221,image222,image223,image224,image225,image226,image227,image228,image229,
        image230,image231,image232,image233,image234,image235,image236;
    ImageView image101,image102,image103,image104,image105,image106,image107,image108,image109,image110,
            image111,image112,image113,image114,image115,image116,image117,image118,image119,image120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.settingsbody);

        InitializationElements();





    }


    private void InitializationElements(){
        main_body1 = (ImageView)findViewById(R.id.mainBody1);
        main_body2 = (ImageView)findViewById(R.id.mainBody2);

        image221 = (ImageView)findViewById(R.id.imageN221);
        image222 = (ImageView)findViewById(R.id.imageN222);
        image223 = (ImageView)findViewById(R.id.imageN223);
        image224 = (ImageView)findViewById(R.id.imageN224);
        image225 = (ImageView)findViewById(R.id.imageN225);
        image226 = (ImageView)findViewById(R.id.imageN226);
        image227 = (ImageView)findViewById(R.id.imageN227);
        image228 = (ImageView)findViewById(R.id.imageN228);
        image229 = (ImageView)findViewById(R.id.imageN229);
        image230 = (ImageView)findViewById(R.id.imageN230);
        image231 = (ImageView)findViewById(R.id.imageN231);
        image232 = (ImageView)findViewById(R.id.imageN232);
        image233 = (ImageView)findViewById(R.id.imageN233);
        image234 = (ImageView)findViewById(R.id.imageN234);
        image235 = (ImageView)findViewById(R.id.imageN235);
        image236 = (ImageView)findViewById(R.id.imageN236);

        image101 = (ImageView)findViewById(R.id.imageN101);
        image102 = (ImageView)findViewById(R.id.imageN102);
        image103 = (ImageView)findViewById(R.id.imageN103);
        image104 = (ImageView)findViewById(R.id.imageN104);
        image105 = (ImageView)findViewById(R.id.imageN105);
        image106 = (ImageView)findViewById(R.id.imageN106);
        image107 = (ImageView)findViewById(R.id.imageN107);
        image108 = (ImageView)findViewById(R.id.imageN108);
        image109 = (ImageView)findViewById(R.id.imageN109);
        image110 = (ImageView)findViewById(R.id.imageN110);
        image111 = (ImageView)findViewById(R.id.imageN111);
        image112 = (ImageView)findViewById(R.id.imageN112);
        image113 = (ImageView)findViewById(R.id.imageN113);
        image114 = (ImageView)findViewById(R.id.imageN114);
        image115 = (ImageView)findViewById(R.id.imageN115);
        image116 = (ImageView)findViewById(R.id.imageN116);
        image117 = (ImageView)findViewById(R.id.imageN117);
        image118 = (ImageView)findViewById(R.id.imageN118);
        image119 = (ImageView)findViewById(R.id.imageN119);
        image120 = (ImageView)findViewById(R.id.imageN120);




        main_body1.setImageResource(R.drawable.main_body1);
        main_body2.setImageResource(R.drawable.main_body2);

        image221.setImageResource(R.drawable.n221);
        image222.setImageResource(R.drawable.n222);
        image223.setImageResource(R.drawable.n223);
        image224.setImageResource(R.drawable.n224);
        image225.setImageResource(R.drawable.n225);
        image226.setImageResource(R.drawable.n226);
        image227.setImageResource(R.drawable.n227);
        image228.setImageResource(R.drawable.n228);
        image229.setImageResource(R.drawable.n229);
        image230.setImageResource(R.drawable.n230);
        image231.setImageResource(R.drawable.n231);
        image232.setImageResource(R.drawable.n232);
        image233.setImageResource(R.drawable.n233);
        image234.setImageResource(R.drawable.n234);
        image235.setImageResource(R.drawable.n235);
        image236.setImageResource(R.drawable.n236);

        image101.setImageResource(R.drawable.n101);
        image102.setImageResource(R.drawable.n102);
        image103.setImageResource(R.drawable.n103);
        image104.setImageResource(R.drawable.n104);
        image105.setImageResource(R.drawable.n105);
        image106.setImageResource(R.drawable.n106);
        image107.setImageResource(R.drawable.n107);
        image108.setImageResource(R.drawable.n108);
        image109.setImageResource(R.drawable.n109);
        image110.setImageResource(R.drawable.n110);
        image111.setImageResource(R.drawable.n111);
        image112.setImageResource(R.drawable.n112);
        image113.setImageResource(R.drawable.n113);
        image114.setImageResource(R.drawable.n114);
        image115.setImageResource(R.drawable.n115);
        image116.setImageResource(R.drawable.n116);
        image117.setImageResource(R.drawable.n117);
        image118.setImageResource(R.drawable.n118);
        image119.setImageResource(R.drawable.n119);
        image120.setImageResource(R.drawable.n120);
    }


}

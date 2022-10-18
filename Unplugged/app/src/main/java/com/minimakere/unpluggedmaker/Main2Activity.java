package com.minimakere.unpluggedmaker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    ImageButton imageButtonPixel=null;
    ImageButton imageButtonBinario=null;
    ImageView imageViewPixelTrofeu = null;
    ImageView imageViewBinarioTrofeu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageButtonBinario = (ImageButton) findViewById(R.id.imageViewBinario);
        imageButtonPixel = (ImageButton) findViewById(R.id.imageViewPixel);
        imageViewBinarioTrofeu = (ImageView) findViewById(R.id.imageViewBinarioTrofeu);
        imageViewPixelTrofeu = (ImageView) findViewById(R.id.imageViewPixelTrofeu);

        imageButtonPixel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent iuploadHexActivity = new Intent(Main2Activity.this, MainActivityMenu.class);

                iuploadHexActivity.putExtra("tipo", "pixel");


                Main2Activity.this.startActivityForResult(iuploadHexActivity,1);


            }
        });

        imageButtonBinario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent iuploadHexActivity = new Intent(Main2Activity.this, MainActivityMenu.class);

                iuploadHexActivity.putExtra("tipo", "binario");

                Main2Activity.this.startActivityForResult(iuploadHexActivity,1);


            }
        });


        avaliaTrofeuBinario();
        avaliaTrofeuPixel();




    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        avaliaTrofeuBinario();
        avaliaTrofeuPixel();

    }



    private void avaliaTrofeuBinario(){
        int count=0;

        for (int i = 1; i <= 10; i++) {

            SharedPreferences settings = getSharedPreferences("binario" + i, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            String temp = settings.getString("binario" + i, "");

        //    getSharedPreferences("binario" + i, 0).edit().clear().commit();


            //String temp =System.getProperty("binario"+(position+1));
            if (!temp.equals("")) {
                count = count +1;

            } else {


            }

        }
        if (count==10){
            imageViewBinarioTrofeu.setImageResource(R.drawable.tofeuouro);

        }

    }
    private void avaliaTrofeuPixel(){
        int count=0;
        for (int i = 1; i <= 4; i++) {

            SharedPreferences settings = getSharedPreferences("pixel" + i, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            String temp = settings.getString("pixel" + i, "");
          //  getSharedPreferences("pixel" + i, 0).edit().clear().commit();

            //String temp =System.getProperty("binario"+(position+1));
            if (!temp.equals("")) {
                count = count +1;

            } else {


            }

        }
        if (count==4){
            imageViewPixelTrofeu.setImageResource(R.drawable.tofeuouro);

        }

    }
}

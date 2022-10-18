package com.minimakere.unpluggedmaker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.StringReader;

public class MainActivity extends Activity {
    GridView gridView;
    boolean isFirstTimeGetFocused=true;
    static final String[] numbers = new String[] {


            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"

    };
    EditText editText=null;
    ImageButton imageButtonEnigma;
    int[][]enigma = new int[11][6];
    String enigma_numero=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent myIntent = getIntent();
        enigma_numero = myIntent.getStringExtra("enigma");

        this.setTitle("Unplugged Enigma "+enigma_numero);
        imageButtonEnigma =(ImageButton) findViewById(R.id.imageButtonEnigma);
        editText =(EditText) findViewById(R.id.editText);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus && isFirstTimeGetFocused){
                    MainActivity.this.editText.setText("");
                    isFirstTimeGetFocused = false;
                }
            }});


        gridView = (GridView) findViewById(R.id.gridview1);

        int[] gridViewImageId = new int[54];
        for (int i=1;i<=54;i++){
            gridViewImageId[i-1]=i;
        }

        carrega_enigma();
        /*
                           {1,0,0},{1,1,1},{1,2,1},{1,3,1},{1,4,1},
                           {2,0,0},{2,1,0},{2,2,0},{2,3,1},{2,4,0},
                           {3,0,0},{3,1,1},{3,2,1},{3,3,1},{3,4,1},
                            {4,0,0},{4,1,0},{4,2,0},{4,3,0},{4,4,0},
                             {5,0,0},{5,1,0},{5,2,0},{5,3,0},{5,4,0},
                {6,0,0},{6,1,0},{6,2,0},{6,3,0},{6,4,0},
                {7,0,0},{7,1,0},{7,2,0},{7,3,0},{7,4,0},
                {8,0,0},{8,1,0},{8,2,0},{8,3,0},{8,4,0}

        };*/

       // Log.i("Teste", ""+enigma[0][3]);

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewImageId,enigma);

        // GridLayout  gameBoard = (GridLayout) findViewById(R.id.layout);

        ImageButton[] imageButtons;

        final int NUMBER_OF_IMAGE_BUTTONS = 15; //your number of image buttons

       //GridLayout.LayoutParams lp = new GridLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        //lp.addRule(RelativeLayout.CENTER_IN_PARENT, 1);



        imageButtons = new ImageButton[NUMBER_OF_IMAGE_BUTTONS];

        for (int i = 0; i < NUMBER_OF_IMAGE_BUTTONS; i++) {
            imageButtons[i] = new ImageButton(this);
            imageButtons[i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
         //   imageButtons[i].setLayoutParams(lp);
        //    imageButtons[i].setOnClickListener(mGreenBallOnClickListener);
            imageButtons[i].setBackgroundColor(Color.TRANSPARENT);
            imageButtons[i].setTag(i);
            imageButtons[i].setId(i);
          //  gameBoard.addView(imageButtons[i]);
        }

      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, numbers);


        gridView.setAdapter(adapterViewAndroid);

        imageButtonEnigma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enigma_numero.equals("1")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("ROBO")) {

                       // Toast.makeText(MainActivity.this,
                              //  "Parabéns", Toast.LENGTH_SHORT).show();
                        show_mensagem(true,enigma_numero);





                    }else{
                        show_mensagem(false,enigma_numero);
                      //  Toast.makeText(MainActivity.this,
                            //    "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (enigma_numero.equals("2")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("MAKER")) {
                        show_mensagem(true,enigma_numero);
                     //   Toast.makeText(MainActivity.this,
                         //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                       // Toast.makeText(MainActivity.this,
                          //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (enigma_numero.equals("3")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("AJUDAR")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (enigma_numero.equals("4")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("ANIME")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (enigma_numero.equals("5")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("POKEMON")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (enigma_numero.equals("6")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("IMPRIMIR")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }
                if (enigma_numero.equals("7")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("CRIATIVO")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }
                if (enigma_numero.equals("8")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("BINARIO")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }
                if (enigma_numero.equals("9")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("ENIGMA")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }
                if (enigma_numero.equals("10")) {

                    if (editText.getText().toString().trim().toUpperCase().equals("UNPLUGGED")) {
                        show_mensagem(true,enigma_numero);
                        //   Toast.makeText(MainActivity.this,
                        //       "Parabéns", Toast.LENGTH_SHORT).show();
                    }else{
                        show_mensagem(false,enigma_numero);
                        // Toast.makeText(MainActivity.this,
                        //      "Tende Novamente!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }



            }

        });

    }

    private void carrega_enigma() {

        if (enigma_numero.equals("1")){


            enigma[0][0]=1; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=1;enigma[0][4]=0;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=1;enigma[1][4]=1;
            enigma[2][0]=0; enigma[2][1]=0;enigma[2][2]=0;enigma[2][3]=1;enigma[2][4]=0;
            enigma[3][0]=0; enigma[3][1]=1;enigma[3][2]=1;enigma[3][3]=1;enigma[3][4]=1;
            enigma[4][0]=0; enigma[4][1]=0;enigma[4][2]=0;enigma[4][3]=0;enigma[4][4]=0;
            enigma[5][0]=0; enigma[5][1]=0;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=0;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("2")){


            enigma[0][0]=0; enigma[0][1]=1;enigma[0][2]=1;enigma[0][3]=0;enigma[0][4]=1;
            enigma[1][0]=0; enigma[1][1]=0;enigma[1][2]=0;enigma[1][3]=0;enigma[1][4]=1;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=0;enigma[2][3]=1;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=1;enigma[3][3]=0;enigma[3][4]=1;
            enigma[4][0]=1; enigma[4][1]=0;enigma[4][2]=0;enigma[4][3]=1;enigma[4][4]=0;
            enigma[5][0]=0; enigma[5][1]=0;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=0;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("3")){


            enigma[0][0]=0; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=0;enigma[0][4]=1;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=0;enigma[1][3]=1;enigma[1][4]=0;
            enigma[2][0]=1; enigma[2][1]=0;enigma[2][2]=1;enigma[2][3]=0;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=1;enigma[3][3]=0;enigma[3][4]=0;
            enigma[4][0]=0; enigma[4][1]=0;enigma[4][2]=0;enigma[4][3]=0;enigma[4][4]=1;
            enigma[5][0]=1; enigma[5][1]=0;enigma[5][2]=0;enigma[5][3]=1;enigma[5][4]=0;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("4")){


            enigma[0][0]=0; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=0;enigma[0][4]=1;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=1;enigma[1][4]=0;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=0;enigma[2][3]=0;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=1;enigma[3][2]=1;enigma[3][3]=0;enigma[3][4]=1;
            enigma[4][0]=0; enigma[4][1]=0;enigma[4][2]=1;enigma[4][3]=0;enigma[4][4]=1;
            enigma[5][0]=0; enigma[5][1]=0;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=0;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("5")){


            enigma[0][0]=1; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=0;enigma[0][4]=0;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=1;enigma[1][4]=1;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=0;enigma[2][3]=1;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=1;enigma[3][3]=0;enigma[3][4]=1;
            enigma[4][0]=0; enigma[4][1]=1;enigma[4][2]=1;enigma[4][3]=0;enigma[4][4]=1;
            enigma[5][0]=0; enigma[5][1]=1;enigma[5][2]=1;enigma[5][3]=1;enigma[5][4]=1;
            enigma[6][0]=0; enigma[6][1]=1;enigma[6][2]=1;enigma[6][3]=1;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("6")){


            enigma[0][0]=0; enigma[0][1]=1;enigma[0][2]=0;enigma[0][3]=0;enigma[0][4]=1;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=0;enigma[1][4]=1;
            enigma[2][0]=1; enigma[2][1]=0;enigma[2][2]=0;enigma[2][3]=0;enigma[2][4]=0;
            enigma[3][0]=1; enigma[3][1]=0;enigma[3][2]=0;enigma[3][3]=1;enigma[3][4]=0;
            enigma[4][0]=0; enigma[4][1]=1;enigma[4][2]=0;enigma[4][3]=0;enigma[4][4]=1;
            enigma[5][0]=0; enigma[5][1]=1;enigma[5][2]=1;enigma[5][3]=0;enigma[5][4]=1;
            enigma[6][0]=0; enigma[6][1]=1;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=1;
            enigma[7][0]=1; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=1;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("7")){


            enigma[0][0]=0; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=1;enigma[0][4]=1;
            enigma[1][0]=1; enigma[1][1]=0;enigma[1][2]=0;enigma[1][3]=1;enigma[1][4]=0;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=0;enigma[2][3]=0;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=0;enigma[3][3]=0;enigma[3][4]=1;
            enigma[4][0]=1; enigma[4][1]=0;enigma[4][2]=0;enigma[4][3]=1;enigma[4][4]=1;
            enigma[5][0]=0; enigma[5][1]=1;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=1;
            enigma[6][0]=1; enigma[6][1]=0;enigma[6][2]=1;enigma[6][3]=0;enigma[6][4]=1;
            enigma[7][0]=0; enigma[7][1]=1;enigma[7][2]=1;enigma[7][3]=1;enigma[7][4]=1;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }

        if (enigma_numero.equals("8")){


            enigma[0][0]=0; enigma[0][1]=0;enigma[0][2]=0;enigma[0][3]=1;enigma[0][4]=0;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=0;enigma[1][3]=0;enigma[1][4]=1;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=1;enigma[2][3]=1;enigma[2][4]=0;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=0;enigma[3][3]=0;enigma[3][4]=1;
            enigma[4][0]=1; enigma[4][1]=0;enigma[4][2]=0;enigma[4][3]=1;enigma[4][4]=0;
            enigma[5][0]=0; enigma[5][1]=1;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=1;
            enigma[6][0]=0; enigma[6][1]=1;enigma[6][2]=1;enigma[6][3]=1;enigma[6][4]=1;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }
        if (enigma_numero.equals("9")){


            enigma[0][0]=0; enigma[0][1]=0;enigma[0][2]=1;enigma[0][3]=0;enigma[0][4]=1;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=1;enigma[1][4]=0;
            enigma[2][0]=0; enigma[2][1]=1;enigma[2][2]=0;enigma[2][3]=0;enigma[2][4]=1;
            enigma[3][0]=0; enigma[3][1]=0;enigma[3][2]=1;enigma[3][3]=1;enigma[3][4]=1;
            enigma[4][0]=0; enigma[4][1]=1;enigma[4][2]=1;enigma[4][3]=0;enigma[4][4]=1;
            enigma[5][0]=0; enigma[5][1]=0;enigma[5][2]=0;enigma[5][3]=0;enigma[5][4]=1;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=0;enigma[6][3]=0;enigma[6][4]=0;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=0;enigma[7][3]=0;enigma[7][4]=0;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=0;enigma[8][3]=0;enigma[8][4]=0;
        }
        if (enigma_numero.equals("10")){


            enigma[0][0]=1; enigma[0][1]=0;enigma[0][2]=1;enigma[0][3]=0;enigma[0][4]=0;
            enigma[1][0]=0; enigma[1][1]=1;enigma[1][2]=1;enigma[1][3]=1;enigma[1][4]=0;
            enigma[2][0]=1; enigma[2][1]=0;enigma[2][2]=0;enigma[2][3]=0;enigma[2][4]=0;
            enigma[3][0]=0; enigma[3][1]=1;enigma[3][2]=1;enigma[3][3]=0;enigma[3][4]=0;
            enigma[4][0]=1; enigma[4][1]=0;enigma[4][2]=1;enigma[4][3]=0;enigma[4][4]=0;
            enigma[5][0]=0; enigma[5][1]=0;enigma[5][2]=1;enigma[5][3]=1;enigma[5][4]=1;
            enigma[6][0]=0; enigma[6][1]=0;enigma[6][2]=1;enigma[6][3]=1;enigma[6][4]=1;
            enigma[7][0]=0; enigma[7][1]=0;enigma[7][2]=1;enigma[7][3]=0;enigma[7][4]=1;
            enigma[8][0]=0; enigma[8][1]=0;enigma[8][2]=1;enigma[8][3]=0;enigma[8][4]=0;
        }
    }

    private void show_mensagem(boolean ok, String numero){
        if(ok) {

            SharedPreferences settings = getSharedPreferences("binario"+numero, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();


            String temp =settings.getString("binario"+numero,"");
            if (temp.equals("")){

                editor.putString("binario"+numero, numero+"");
                editor.commit();


            }


            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(MainActivity.this.getResources().getString(R.string.rate_title_msg))
                    .setMessage(MainActivity.this.getResources().getString(R.string.rate_description_msg_ok))
                    .setPositiveButton(MainActivity.this.getResources().getString(R.string.rate_ok_msg), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton(MainActivity.this.getResources().getString(R.string.rate_cancel_msg), null);
            builder.show();
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(MainActivity.this.getResources().getString(R.string.rate_title_msg))
                    .setMessage(MainActivity.this.getResources().getString(R.string.rate_description_msg_erro))
                    .setPositiveButton(MainActivity.this.getResources().getString(R.string.rate_ok_msg), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton(MainActivity.this.getResources().getString(R.string.rate_cancel_msg), null);
            builder.show();
        }
    }
}

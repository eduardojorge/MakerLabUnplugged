package com.minimakere.unpluggedmaker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivityPixel extends Activity {
    GridView gridViewTabuleiro;
    GridView gridViewText;
    boolean isFirstTimeGetFocused = true;

    EditText editText = null;
    ImageButton imageButtonPixel;
    int[][] tabuleiro = new int[9][8];
    String desafio_numero = null;

    String[] desafio = new String[9];

    CustomGridViewActivityPixel adapterViewAndroidTabuleriro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pixel);

        Intent myIntent = getIntent();
        desafio_numero = myIntent.getStringExtra("pixel");


        this.setTitle("Unplugged Desafio Pixel " + desafio_numero);


        gridViewTabuleiro = (GridView) findViewById(R.id.gridview1);


        gridViewText = (GridView) findViewById(R.id.gridview2);


        imageButtonPixel = (ImageButton) findViewById(R.id.imageButtonPixel);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = 0;

            }
        }


        int[] gridViewImageId = new int[72];
        int[] gridViewImageIdText = new int[9];
        for (int i = 1; i < 54; i++) {
            gridViewImageId[i - 1] = i;
        }

        carrega_desafio();
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

        adapterViewAndroidTabuleriro = new CustomGridViewActivityPixel(MainActivityPixel.this, gridViewImageId, tabuleiro);
        CustomGridViewActivityPixelText adapterViewAndroidText = new CustomGridViewActivityPixelText(MainActivityPixel.this, gridViewImageIdText, desafio);

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


        gridViewTabuleiro.setAdapter(adapterViewAndroidTabuleriro);
        gridViewText.setAdapter(adapterViewAndroidText);
        imageButtonPixel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (MainActivityPixel.this.adapterViewAndroidTabuleriro.verifica_resposta()) {

                    show_mensagem(true,desafio_numero+"");
                    {

                    }
                    ///    Toast.makeText(MainActivityPixel.this,
                    ///         "Parabéns", Toast.LENGTH_SHORT).show();
                } else {
                    show_mensagem(false,desafio_numero+"");
                    {

                    }
                    ///show_mensagem();

                    // Toast.makeText(MainActivityPixel.this,
                    ///       "Erro", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private void carrega_desafio() {
        int tamanho=0;
        if (desafio_numero.equals("1")) {
            desafio[0] = "2,3,3";
            desafio[1] = "5,1,2";
            desafio[2] = "2,4,2";
            desafio[3] = "1,1,3,1,2";
            desafio[4] = "1,1,3,1,2";
            desafio[5] = "2,4,2";
            tamanho = 6;

        }

        if (desafio_numero.equals("2")) {
            desafio[0] = "8";
            desafio[1] = "4,1,3";
            desafio[2] = "4,2,2";
            desafio[3] = "0,7,1";
            desafio[4] = "0,8";
            desafio[5] = "0,7,1";
            desafio[6] = "4,2,2";
            desafio[7] = "4,1,3";


            tamanho = 8;

        }

        if (desafio_numero.equals("3")) {
            desafio[0] = "4,1,3";
            desafio[1] = "3,2,3";
            desafio[2] = "2,3,3";
            desafio[3] = "4,1,3";
            desafio[4] = "1,7";
            desafio[5] = "2,1,3,1,1";
            desafio[6] = "3,3,2";


            tamanho = 7;

        }

        if (desafio_numero.equals("4")) {
            desafio[0] = "8";
            desafio[1] = "1,1,4,1,1";
            desafio[2] = "2,1,2,1,2";
            desafio[3] = "3,2,3";
            desafio[4] = "3,2,3";
            desafio[5] = "2,1,2,1,2";
            desafio[6] = "1,1,4,1,1";


            tamanho = 7;

        }



        for (int i = 0; i < tamanho; i++) {


            String[] temp = desafio[i].split(",");
            String temp1 = "";
            int count = 0;
            boolean chave = true;
            for (int j = 0; j < temp.length; j++) {

                int z = new Integer(temp[j]).intValue();

                for (int z1 = 0; z1 < z; z1++) {

                    if (chave) {
                        tabuleiro[i][count] = 0;
                        temp1 = temp1 + "0";


                    } else {
                        tabuleiro[i][count] = 1;

                        temp1 = temp1 + "1";
                    }
                    count = count + 1;

                }
                if (chave) {
                    chave = false;
                } else {
                    chave = true;
                }

            }
            Log.i("Teste", temp1);
        }
        for (int i=0;i<9;i++){
            String temp="";
            for (int j=0;j<8;j++){

               temp=temp+tabuleiro[i][j];

            }
            Log.i("Linha",""+temp);

        }




    }






    private void show_mensagem(boolean ok, String numero) {
        if(ok) {
            SharedPreferences settings = getSharedPreferences("pixel"+numero, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();


            String temp =settings.getString("pixel"+numero,"");
            if (temp.equals("")){

                editor.putString("pixel"+numero, numero+"");
                editor.commit();


            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityPixel.this)
                    .setTitle(MainActivityPixel.this.getResources().getString(R.string.rate_title_msg))
                    .setMessage(MainActivityPixel.this.getResources().getString(R.string.rate_description_msg_ok))
                    .setPositiveButton(MainActivityPixel.this.getResources().getString(R.string.rate_ok_msg), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton(MainActivityPixel.this.getResources().getString(R.string.rate_cancel_msg), null);
            builder.show();
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityPixel.this)
                    .setTitle(MainActivityPixel.this.getResources().getString(R.string.rate_title_msg))
                    .setMessage(MainActivityPixel.this.getResources().getString(R.string.rate_description_msg_erro))
                    .setPositiveButton(MainActivityPixel.this.getResources().getString(R.string.rate_ok_msg), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton(MainActivityPixel.this.getResources().getString(R.string.rate_cancel_msg), null);
            builder.show();
        }
    }
}

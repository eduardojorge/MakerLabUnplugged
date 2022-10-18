package com.minimakere.unpluggedmaker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGridViewActivityPixel extends BaseAdapter {

    private Context mContext;

    private int linha=0;
    private int coluna=0;

    private final int[] gridViewImageId;

   // private final ImageButton[] buttons= new ImageButton[53];
  //  private final ImageView[][] imageView= new ImageView[11][6];

    int[][] tabuleiro;
    int[][] resposta = new int[9][8];

    public boolean verifica_resposta(){

        for (int i=0;i<9;i++){
            String temp="";
            for (int j=0;j<8;j++){

                temp=temp+resposta[i][j];

            }
            Log.i("Linha",""+temp);

        }


        Log.i("Linha",""+this.tabuleiro[0][0]);
        for (int i=0;i<9;i++){
            String temp="";
            for (int j=0;j<8;j++){
                if(!(resposta[i][j]== this.tabuleiro[i][j])){
                    Log.i("Linha",temp+"r"+resposta[i][j]+"t"+tabuleiro[i][j]);
                    Log.i("Linha",temp+"i"+i+"j"+j);
                    return false;

                }else{
                    temp=""+resposta[i][j];

                }

            }


        }
        return true;

    }

    public CustomGridViewActivityPixel(Context context, int[] gridViewImageId, int[][] tabuleiro ) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.tabuleiro = tabuleiro;

        for (int i=0;i<9;i++){
            for (int j=0;j<8;j++){
                resposta[i][j]=0;

            }
        }

    }

    @Override
    public int getCount() {
        return gridViewImageId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        gridViewAndroid = new View(mContext);
        ImageButton imageViewAndroid=null;
        ImageButton imageViewButton = null;
        TextView textViewTabuleiro;



        if (convertView == null) {




                gridViewAndroid = inflater.inflate(R.layout.gridview_layout_pixel, null);
                imageViewButton = (ImageButton) gridViewAndroid.findViewById(R.id.imageButtonTabuleiro);

              /*  if ((linha<8) && (coluna<8) ){
                    if (tabuleiro[linha][coluna] == 1) {
                        imageViewButton.setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                        imageViewButton.setTag("B;" + i);

                    } else {
                        imageViewButton.setImageResource(R.drawable.baseline_fiber_manual_record_white_18dp);
                        imageViewButton.setTag("W;" + i);
                    }
                }*/

            if ((linha<=9) && (coluna<=8) ){

                imageViewButton.setImageResource(R.drawable.baseline_fiber_manual_record_white_18dp);

                if (linha==9){
                    linha=8;
                }
                if (coluna>=8){
                    imageViewButton.setTag("W;" + linha+";"+(7));
                }else{
                    imageViewButton.setTag("W;" + linha+";"+(coluna));
                }



            }
            if (coluna==7) {
                linha++;
                coluna=0;
            }else{
                coluna++;
            }


            imageViewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ImageButton c =(ImageButton)v;



                    String[] temp = ((String) c.getTag()).split(";");



                    //textViews[new Integer(temp[1]).intValue()].setText(""+temp[1]+","+temp[2]);

                    if (temp[0].equals("W")) {
                        c.setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                        c.setTag("B;"+new Integer(temp[1]).intValue()+";"+new Integer(temp[2]).intValue());
                        resposta[new Integer(temp[1]).intValue()][+new Integer(temp[2]).intValue()]=1;


                    }else{
                        c.setImageResource(R.drawable.baseline_fiber_manual_record_white_18dp);
                        c.setTag("W;"+new Integer(temp[1]).intValue()+";"+new Integer(temp[2]).intValue());
                        resposta[new Integer(temp[1]).intValue()][+new Integer(temp[2]).intValue()]=0;

                    }

                 /*   Toast.makeText(mContext,
                            "teste"  , Toast.LENGTH_SHORT).show();



*/

                }
            });












                    //

/*
                imageViewAndroid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ImageButton c =(ImageButton)v;



                        String[] temp = ((String) c.getTag()).split(";");

                        //textViews[new Integer(temp[1]).intValue()].setText(""+temp[1]+","+temp[2]);

                        if (temp[0].equals("W")) {
                            c.setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                            c.setTag("B;"+new Integer(temp[1]).intValue());

                        }else{
                            c.setImageResource(R.drawable.baseline_fiber_manual_record_white_18dp);
                            c.setTag("W;"+new Integer(temp[1]).intValue());
                        }
                        Toast.makeText(mContext,
                                "teste"  , Toast.LENGTH_SHORT).show();


                    }
                });

                */






        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }


}


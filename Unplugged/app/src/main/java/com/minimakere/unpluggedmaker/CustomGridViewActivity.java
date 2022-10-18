package com.minimakere.unpluggedmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomGridViewActivity extends BaseAdapter {

    private Context mContext;

    private int linha=0;
    private int coluna=0;

    private final int[] gridViewImageId;

    private final ImageButton[] buttons= new ImageButton[53];
    private final ImageView[][] imageView= new ImageView[11][6];

    int[][] enigma;

    int[] chaveClickButton= new int[10];


    public CustomGridViewActivity(Context context,  int[] gridViewImageId, int[][] enigma ) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.enigma = enigma;

        for (int i=0;i<=9;i++){
            chaveClickButton[i]=1;
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



        if (convertView == null) {





            if ((i==5) || (i==11) || (i==17) || (i==23) || (i==29) || (i==35) || (i==41) || (i==47) || (i==53)){
                gridViewAndroid = inflater.inflate(R.layout.gridview2_layout, null);
                imageViewButton = (ImageButton) gridViewAndroid.findViewById(R.id.imageButton);
              //  imageViewButton.setText("XXX");

                buttons[linha]=imageViewButton;

                imageViewButton.setTag("" + linha);
                linha=linha+1;
                if(linha>9){
                    linha=9;
                }
                coluna=0;


                imageViewButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        ImageButton t  =(ImageButton)v;


                    //    t.setText("L="+linha);

                        int linha = new Integer(t.getTag()+"").intValue();
                      //  t.setText("L="+linha);

                        for (int i=0;i<5;i++){

                            if (enigma[linha][i]==1) {

                                if (i==0) {

                                    if ( chaveClickButton[linha]==1) {

                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.dezesseis);
                                    }else{
                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                                    }
                                 //   t.setText("L="+linha+" C="+i);
                                }

                                if (i==1) {

                                    if ( chaveClickButton[linha]==1) {

                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.oito);
                                    }else{
                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                                    }
                                   // t.setText("L="+linha+" C="+i);
                                }

                                if (i==2) {

                                    if ( chaveClickButton[linha]==1) {

                                      CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.quatro);
                                    }else{
                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                                    }
                                //    t.setText("L="+linha+" C="+i);
                                }
                                if (i==3) {

                                    if ( chaveClickButton[linha]==1) {


                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.dois);
                                    }else{
                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                                    }
                                  //  t.setText("L="+linha+" C="+i);
                                }

                                if (i==4) {

                                    if ( chaveClickButton[linha]==1) {


                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.um);
                                    }else{
                                        CustomGridViewActivity.this.imageView[linha][i].setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                                    }

                                    //t.setText("L="+linha+" C="+i);
                                }
                            }

                        }
                        chaveClickButton[linha]=chaveClickButton[linha]*(-1);



                    }
                });

            }else {

                 gridViewAndroid = inflater.inflate(R.layout.gridview_layout, null);
                 imageViewAndroid = (ImageButton) gridViewAndroid.findViewById(R.id.android_gridview_image);
                // textViewAndroid.setText(gridViewString[i]);
                if (enigma[linha][coluna]==0){

                    imageViewAndroid.setImageResource(R.drawable.baseline_fiber_manual_record_white_18dp);
                    imageViewAndroid.setTag("W;" + linha + ";" + coluna);
                }else{


                    imageViewAndroid.setImageResource(R.drawable.round_fiber_manual_record_black_18dp);
                    imageViewAndroid.setTag("B;" + linha + ";" + coluna);


                }
                this.imageView[linha][coluna]= imageViewAndroid;

                coluna =coluna+1;



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
            }





        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}
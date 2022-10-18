package com.minimakere.unpluggedmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridViewActivityPixelText extends BaseAdapter {

    private Context mContext;

    private int linha=0;
    private int coluna=0;

    private final int[] gridViewImageId;

    private final ImageButton[] buttons= new ImageButton[53];
    private final ImageView[][] imageView= new ImageView[11][6];


    String[] desafio = new String[9];


    int[] chaveClickButton= new int[10];


    public CustomGridViewActivityPixelText(Context context, int[] gridViewImageId, String[] desafio ) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.desafio = desafio;


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




                gridViewAndroid = inflater.inflate(R.layout.gridview2_layout_pixel, null);

                textViewTabuleiro = (TextView) gridViewAndroid.findViewById(R.id.textViewTabuleiro);


                 textViewTabuleiro.setText(desafio[i]);










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
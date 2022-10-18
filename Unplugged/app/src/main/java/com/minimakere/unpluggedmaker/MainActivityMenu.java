package com.minimakere.unpluggedmaker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivityMenu extends Activity {

    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=1;
    final int WRITE_EXTERNAL_STORAGE=0;



    private  ListView lista=null;

    //private String[]
      //      activityHex;


    String[] activity;

    ///String[] activity_2 = {"Teste"};



    MenuItem menu_binario;
    MenuItem menu_pixel;
    MenuItem menuApp_rate;

    ImageButton imageButtonPDF= null;
    ImageButton imageButtonPixel= null;
    ImageButton imageButtonBinario= null;

    ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();

     ListView list;

    String tipo="binario";



   private ImageView imageViewLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        Intent myIntent = getIntent();
        tipo = myIntent.getStringExtra("tipo");
        imageViewLog = (ImageView) findViewById(R.id.imageViewLog) ;



          //      =
            //    {"Piscar Led", "Ligar Led Celular", "Rôbo"};
       // int layout =  android.R.layout.simple_selectable_list_item;


     //   ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this,layout, activity);


         list = findViewById(R.id.list);







        // ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        if (tipo.equals("binario")) {
            this.loadActivity_binario();
            imageViewLog.setImageResource(R.drawable.logbinario);
        }else{
            imageViewLog.setImageResource(R.drawable.logpixel);
            this.loadActivity_pixel();

        }


        CustomAdapter customAdapter = new CustomAdapter(this, arrayList,tipo);
        list.setAdapter(customAdapter);

      /*  lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <?> adapter, View view, int posicao, long id)
            {


               // Intent iProtoboarActivity = new Intent(MainActivity.this,ProtoboardActivity.class);

                //iProtoboarActivity.putExtra("file",activity[posicao]);

               // startActivity(iProtoboarActivity);



              //  Intent iuploadHexActivity = new Intent(MainActivity.this, ProtoboardMMLBoxActivity.class);

                //iuploadHexActivity.putExtra("file",activity[posicao]);

                //startActivity(iuploadHexActivity);

                Intent iuploadHexActivity = new Intent(MainActivity.this,UploadHexActivity.class);

                iuploadHexActivity.putExtra("file",activity[posicao]);

                startActivity(iuploadHexActivity);



                // Toast.makeText(MainActivity.this, "Clicou " +posicao, Toast.LENGTH_SHORT).show();
            }
        });*/



    }


    @Override
    public void onStart() {
        super.onStart();

      //  ActivityCompat.requestPermissions(MainActivityMenu.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
             //   WRITE_EXTERNAL_STORAGE);

        // Here, thisActivity is the current activity
        //  MainActivity.this.hasPermission();
      //  File direct = new File(Environment.getExternalStorageDirectory() + "/roboardu");

      //  if (!direct.exists()) {
      //      if (direct.mkdir()) ; //directory is created;
      //  }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);

       // menuActivity_1 = (MenuItem) menu.findItem(R.id.activity_1);
       // menuActivity_2 = (MenuItem) menu.findItem(R.id.activity_2);

        menu_binario
                = (MenuItem) menu.findItem(R.id.binario_menu);
        menu_pixel
                = (MenuItem) menu.findItem(R.id.pixel_menu);



        menuApp_rate = (MenuItem) menu.findItem(R.id.app_rate);
        return true;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
      //  Toast.makeText(MainActivityMenu.this, "Voltou " , Toast.LENGTH_SHORT).show();

        if (tipo.equals("binario")) {
            this.loadActivity_binario();
            imageViewLog.setImageResource(R.drawable.logbinario);
        }else{
            imageViewLog.setImageResource(R.drawable.logpixel);
            this.loadActivity_pixel();

        }


        CustomAdapter customAdapter = new CustomAdapter(this, arrayList,tipo);
        list.setAdapter(customAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        if (id == R.id.app_rate) {
            MainActivityMenu.this.showRateDialog(MainActivityMenu.this);
            return true;
            //Intent intent = new Intent(this, ClickActivity.class);
            //startActivity(intent);

        }

            if (id == R.id.binario_menu) {
                tipo="binario";
            this.loadActivity_binario();


            CustomAdapter customAdapter = new CustomAdapter(this, arrayList,tipo);
            list.setAdapter(customAdapter);

            //Intent intent = new Intent(this, ClickActivity.class);
            //startActivity(intent);

        }
        if (id == R.id.pixel_menu) {
            tipo="pixel";
            this.loadActivity_pixel();


            CustomAdapter customAdapter = new CustomAdapter(this, arrayList,tipo);
            list.setAdapter(customAdapter);


            //startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

public void loadActivity_binario() {

    arrayList.clear();
    String[] activityBox = getResources().getStringArray(R.array.activity_binario);



    activity = new String[activityBox.length];

    //  activityHex = new String[activityBox.length];



    for (int i = 0; i < activityBox.length; i++) {

        //Log.d("Teste", activityBox[i]);

        // Toast.makeText(MainActivity.this, "Clicou " +activityBox[i], Toast.LENGTH_SHORT).show();




        activity[i] = activityBox[i].split(";")[0];
        arrayList.add(new SubjectData(  activity[i],activityBox[i].split(";")[1]));

    }

}

    public void loadActivity_pixel() {

        arrayList.clear();


        String[] activityBox = getResources().getStringArray(R.array.activity_pixel);

        activity = new String[activityBox.length];

        //  activityHex = new String[activityBox.length];



        for (int i = 0; i < activityBox.length; i++) {

            //Log.d("Teste", activityBox[i]);

            // Toast.makeText(MainActivity.this, "Clicou " +activityBox[i], Toast.LENGTH_SHORT).show();




            activity[i] = activityBox[i].split(";")[0];
            arrayList.add(new SubjectData(  activity[i],activityBox[i].split(";")[1]));

        }

    }

    public void loadActivity_2(){


        String[] activityBox = getResources().getStringArray(R.array.activity_binario);


        activity = new String[activityBox.length];

        //  activityHex = new String[activityBox.length];

        activity = new String[activityBox.length];

        for (int i=0;i<activityBox.length;i++){

            //Log.d("Teste", activityBox[i]);

            // Toast.makeText(MainActivity.this, "Clicou " +activityBox[i], Toast.LENGTH_SHORT).show();



            activity[i] = activityBox[i].split(";")[0];
        }


}





    public  void showRateDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(MainActivityMenu.this.getResources().getString(R.string.rate_title))
                .setMessage(MainActivityMenu.this.getResources().getString(R.string.rate_description))
                .setPositiveButton(MainActivityMenu.this.getResources().getString(R.string.rate_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (context != null) {
                            String link = "market://details?id=com.minimakere.unplugged";
                            try {
                                // play market available
                                context.getPackageManager()
                                        .getPackageInfo("com.android.vending", 0);
                                // not available
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                                // should use browser
                                // link = "https://play.google.com/store/apps/details?id=camilaspjorge.br.teste1";
                                link = "https://play.google.com/store/apps/details?id=com.minimakere.unplugged";
                            }
                            // starts external action
                            /*context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(link + context.getPackageName())));*/

                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(link )));
                        }
                    }
                })
                .setNegativeButton(MainActivityMenu.this.getResources().getString(R.string.rate_cancel), null);
        builder.show();
    }

public void openPdf(){
    /** PDF reader code */
  //  File file = new File(MainActivity.this.getAssets().toString()+"/manual.pdf");
   // File file = new File(MainActivity.this.getAssets().toString()+"/manual.pdf");
    File f2 = new File(Environment.getExternalStorageDirectory(),  "/roboardu/manual.pdf");
    Uri uri = FileProvider.getUriForFile(MainActivityMenu.this, BuildConfig.APPLICATION_ID + ".provider",f2);


    try
    {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(uri,"application/pdf");
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        getApplicationContext().startActivity(intent);
    }
    catch (Exception e)
    {
        Toast.makeText(MainActivityMenu.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
    }
}

    private void CopyReadAssets()
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "manual.pdf");
        try
        {
            in = assetManager.open("manual.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/manual.pdf"),
                "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }

    private boolean isAccessGranted() {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            @SuppressLint("NewApi") AppOpsManager appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
            int mode = 0;
            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                        applicationInfo.uid, applicationInfo.packageName);
            }
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }




}

package com.minimakere.unpluggedmaker.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.minimakere.unpluggedmaker.BuildConfig;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class OpenLocalPDF {

    private static String TAG = OpenLocalPDF.class.getSimpleName();

    private WeakReference<Context> contextWeakReference;
    private String fileName;
    private Uri uri;

    public OpenLocalPDF(Context context, String fileName) {
        this.contextWeakReference = new WeakReference<>(context);
        this.fileName = fileName.endsWith("pdf") ? fileName : fileName + ".pdf";



    }

    public void execute() {

        Context context = contextWeakReference.get();
        if (context != null) {
            new CopyFileAsyncTask().execute();
        }

    }


    private class CopyFileAsyncTask extends AsyncTask<Void, Void, File> {


        final String appDirectoryName = BuildConfig.APPLICATION_ID;
        final File fileRoot = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), appDirectoryName);

        @Override
        protected File doInBackground(Void... params) {

            Context context = contextWeakReference.get();

            AssetManager assetManager = context.getAssets();

            File file = new File(fileRoot, fileName);

            InputStream in = null;
            OutputStream out = null;
            try {

                file.mkdirs();

                if (file.exists()) {
                    file.delete();
                }

                file.createNewFile();


                in = assetManager.open(fileName);
                Log.d(TAG, "In");

                out = new FileOutputStream(file);
                Log.d(TAG, "Out");

                Log.d(TAG, "Copy file");
                copyFile(in, out);

                Log.d(TAG, "Close");
                in.close();

                out.flush();
                out.close();

                return file;
            } catch (Exception e)
            {
                Log.e(TAG, e.getMessage());
            }

            return null;
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

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);

            Context context = contextWeakReference.get();


            Intent intent = new Intent(Intent.ACTION_VIEW);
            try {

                intent.setDataAndType(
                        Uri.fromFile(file),
                        "application/pdf");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                context.startActivity(intent);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
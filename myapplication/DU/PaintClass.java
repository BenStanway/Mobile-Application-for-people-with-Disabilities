package com.example.myapplication.DU;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.View;

import static com.example.myapplication.DU.display.colourList;
import static com.example.myapplication.DU.display.current_brush;
import static com.example.myapplication.DU.display.pathList;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class PaintClass extends shake {

    public static Path path = new Path();
    public static Paint paint_brush=new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        MediaPlayer Paint = MediaPlayer.create(this, R.raw.menupaint);
        Paint.start();

    }

    public void pencil(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColour(paint_brush.getColor());
    }

    public void eraser(View view) {
        pathList.clear();
        colourList.clear();
        path.reset();
    }

    public void redColour(View view) {
        paint_brush.setColor(Color.RED);
        currentColour(paint_brush.getColor());
    }

    public void yellowColour(View view) {
        paint_brush.setColor(Color.YELLOW);
        currentColour(paint_brush.getColor());
    }

    public void pinkColour(View view) {
        paint_brush.setColor(Color.MAGENTA);
        currentColour(paint_brush.getColor());
    }

    public void blueColour(View view) {
        paint_brush.setColor(Color.BLUE);
        currentColour(paint_brush.getColor());
    }

    public void currentColour(int c){
        current_brush=c;
        path=new Path();
    }

    public void greenColour(View view) {
        paint_brush.setColor(Color.GREEN);
        currentColour(paint_brush.getColor());
    }



    protected static File screenshot(View view, String filename) {
        Date date = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);

        try {
            String dirPath = Environment.getExternalStorageDirectory().toString() + "/Paintings";
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                boolean mkdir = fileDir.mkdir();
            }
            String path = dirPath + "/" + filename + "-" + format + ".jpeg";

            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);

            File imageFile = new File(path);

            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return imageFile;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}

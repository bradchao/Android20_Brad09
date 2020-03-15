package tw.org.iii.brad.brad09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Button test5, test6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test5 = findViewById(R.id.test5);
        test6 = findViewById(R.id.test6);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        editor = sp.edit();
    }

    public void test1(View view) {
        editor.putInt("stage", (int)(Math.random()*49+1));
        editor.putBoolean("sound", false);
        editor.putString("username", "Brad");
        editor.commit();
    }
    public void test2(View view) {
        boolean sound = sp.getBoolean("sound", true);
        int stage = sp.getInt("stage", 1);
        String username = sp.getString("username", "nobody");
        Toast.makeText(this, username+":"+stage+":"+sound,
                Toast.LENGTH_SHORT).show();
    }

    public void test3(View view) {
        Log.v("brad", "test3");
        try {
            FileOutputStream fout = openFileOutput("brad.txt", MODE_PRIVATE);
            fout.write("Hello, World\n1234567\n76543221".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save OK",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.v("brad", e.toString());
            Toast.makeText(this, "Save failure",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void test4(View view){
        try {
            FileInputStream fin = openFileInput("brad.txt");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(fin));
            StringBuffer sb = new StringBuffer();
            String line;
            while ( (line = reader.readLine()) != null){
                sb.append(line + "\n");
            }
            fin.close();
            Toast.makeText(this, sb,
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, e.toString(),
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void test56(View view) {
        Button btn = (Button)view;
        Log.v("brad", btn.getText().toString());
        if (view == test5){
            Log.v("brad", "test5");
        }else if (view == test6){
            Log.v("brad", "test6");
        }



    }
}

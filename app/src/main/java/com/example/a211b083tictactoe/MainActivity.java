package com.example.a211b083tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean winner =false;
    int image_click=-1;
    int player=1; //Cross
    int [][]winning={{0,1,2},{3,4,5},{6,7,8}};
    int []game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load (View view) {
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        image_click=game[tag];
        if(!winner && image_click==-1 ) {
            if (player == 1) {
                v.setImageResource(R.drawable.crossbg);
                game[tag] = player;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                game[tag] = player;
                Toast.makeText(this, tag + " " + "Circle", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winning.length; i++) {
                if (game[winning[i][0]] == game[winning[i][1]] && game[winning[i][1]] == game[winning[i][2]] && game[winning[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    winner=true;
                }
            }
        }

    }
    public void reset(View view) {
        GridLayout gridlayout = findViewById(R.id.gridlayout);
        int total_image = gridlayout.getChildCount();
        for (int i = 0; i < total_image; i++)
        {
            ImageView v =(ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        winner=false;
        image_click=-1;
        Arrays.fill(game, -1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Be alert!")
                .setMessage("pls play at your own risk")
                        .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT);
                            }
                        }).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
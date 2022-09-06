package com.example.geceyiyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView;
    ImageView imageView;
    int screenX;
    int screenY;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenX = size.x;
        screenY = size.y;
        textView1=findViewById(R.id.timerText);
        textView=findViewById(R.id.scoreText);
        imageView=findViewById(R.id.gece);
        startGame();
    }


    public void imgClick(View view){
        score++;
        textView.setText("Skor : "+score);
    }


    public void startGame(){
        score=0;
    textView.setText("Skor : 0");
        Toast.makeText(MainActivity.this,"Level 2 = 20 skor",Toast.LENGTH_SHORT);
        new CountDownTimer(15000, 800) {
            @Override
            public void onTick(long l) {
                textView1.setText("Süre : " + l/1000);
                float randomX= new  Random().nextInt(screenX-imageView.getMeasuredWidth());
                float randomY= new Random().nextInt(screenY-2*imageView.getMeasuredHeight());
                imageView.setX(randomX);
                imageView.setY(randomY);
            }

            @Override
            public void onFinish() {
                textView1.setText("Süre Bitti!");
                imageView.setVisibility(View.INVISIBLE);
                if(score >= 20){
                    Toast.makeText(MainActivity.this,"Level 1 ✓",Toast.LENGTH_SHORT).show();
                    level2();
                }
                else{
                    textView1.setText("Elendiniz !");
                    imageView.setVisibility(View.INVISIBLE);

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Tekrar Dene");
                    alert.setMessage("Tekrar Denemek İster Misiniz?");
                    alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startGame();
                            imageView.setVisibility(View.VISIBLE);
                        }
                    });
                    alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"Oyun Bitti!",Toast.LENGTH_LONG);
                        }
                    });
                    alert.show();


                }
            }
        }.start();

    }


    public void level2(){
        textView.setText("Skor : "+score);
        imageView.setVisibility(View.VISIBLE);
        Toast.makeText(MainActivity.this,"Level 3 = 40 skor",Toast.LENGTH_SHORT);
        new CountDownTimer(14000, 600) {
            @Override
            public void onTick(long l) {
                textView1.setText("Süre : " + l/1000);
                float randomX= new  Random().nextInt(screenX-imageView.getMeasuredWidth());
                float randomY= new Random().nextInt(screenY-2*imageView.getMeasuredHeight());
                imageView.setX(randomX);
                imageView.setY(randomY);
            }

            @Override
            public void onFinish() {
                textView1.setText("Süre Bitti!");
                imageView.setVisibility(View.INVISIBLE);
                if(score>=40){
                    Toast.makeText(MainActivity.this,"Level 2 ✓",Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,"Kazandınız Tebrikler !!",Toast.LENGTH_LONG).show();
                }
                else{
                    textView1.setText("Elendiniz !");
                    imageView.setVisibility(View.INVISIBLE);

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Tekrar Dene");
                    alert.setMessage("Tekrar Denemek İster Misiniz?");
                    alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startGame();
                            imageView.setVisibility(View.VISIBLE);
                        }
                    });
                    alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"Oyun Bitti!",Toast.LENGTH_LONG);
                        }
                    });
                    alert.show();


                }
            }
        }.start();



    }
    }

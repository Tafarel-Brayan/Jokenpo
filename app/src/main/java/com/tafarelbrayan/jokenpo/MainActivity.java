package com.tafarelbrayan.jokenpo;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static com.tafarelbrayan.jokenpo.R.color.colorDanger;
import static com.tafarelbrayan.jokenpo.R.color.colorSuccess;
import static com.tafarelbrayan.jokenpo.R.color.colorWarning;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedra(View view){
        ImageView imageView = findViewById(R.id.imagePedra);
        imageView.setImageResource(R.drawable.pedra);
        this.jogar("pedra");
    }

    public void papel(View view){
        ImageView imageView = findViewById(R.id.imagePapel);
        imageView.setImageResource(R.drawable.papel);
        this.jogar("papel");
    }

    public void tesoura(View view){
        ImageView imageView = findViewById(R.id.imageTesoura);
        imageView.setImageResource(R.drawable.tesoura);
        this.jogar("tesoura");
    }

    @SuppressLint("ResourceAsColor")
    public void jogar(String opcao){


            String[] opcoes = {"pedra", "papel", "tesoura"};

            int n = new Random().nextInt(3);

            String resultado = opcoes[n];
            ImageView imageView = findViewById(R.id.imagePadrao);
            TextView textView = findViewById(R.id.textoResultado);

            imageView.setImageResource(R.drawable.transparente);

            /*Gif Animado*/
            imageView.setBackgroundResource(R.drawable.splash_animation);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            animationDrawable.start();

            Jogar jogarr = new Jogar();
            Thread threadJogar = new Thread(jogarr);
            threadJogar.start();
            if(!threadJogar.isAlive()){
                System.out.println("Thread Terminou!");
            }
            //teste(opcao, resultado, animationDrawable, imageView, textView);


    }

    public void teste(String opcao, String resultado, AnimationDrawable animationDrawable, ImageView imageView, TextView textView){
        try {
            Thread.sleep(3000);

            switch (resultado){
                case "pedra":

                    imageView.setImageResource(R.drawable.pedra);

                    if(opcao != "pedra"){
                        if(opcao == "papel"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(colorWarning));
                    }

                    break;

                case "papel":

                    imageView.setImageResource(R.drawable.papel);

                    if(opcao != "papel"){
                        if(opcao == "tesoura"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(colorWarning));
                    }
                    break;

                case "tesoura":

                    imageView.setImageResource(R.drawable.tesoura);

                    if(opcao != "tesoura"){
                        if(opcao == "pedra"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(colorWarning));
                    }
                    break;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.tafarelbrayan.jokenpo;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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

        try {
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

            Thread.sleep(1000);

            switch (resultado){
                case "pedra":
                    animationDrawable.stop();
                    imageView.setImageResource(R.drawable.pedra);

                    if(opcao != "pedra"){
                        if(opcao == "papel"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(R.color.colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(R.color.colorWarning));
                    }

                    break;

                case "papel":
                    animationDrawable.stop();
                    imageView.setImageResource(R.drawable.papel);

                    if(opcao != "papel"){
                        if(opcao == "tesoura"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(R.color.colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(R.color.colorWarning));
                    }
                    break;

                case "tesoura":
                    animationDrawable.stop();
                    imageView.setImageResource(R.drawable.tesoura);

                    if(opcao != "tesoura"){
                        if(opcao == "pedra"){
                            textView.setText("VOCÊ GANHOU!");
                            textView.setTextColor(getResources().getColor(R.color.colorSuccess));
                        }else{
                            textView.setText("VOCÊ PERDEU!");
                            textView.setTextColor(getResources().getColor(R.color.colorDanger));
                        }
                    }else{
                        textView.setText("EMPATE");
                        textView.setTextColor(getResources().getColor(R.color.colorWarning));
                    }
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

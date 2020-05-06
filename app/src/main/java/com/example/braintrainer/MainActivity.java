package com.example.braintrainer;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.CarrierConfigManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand;
    Button go;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    TextView timer;
    TextView question;
    TextView correct;
    TextView status;
    ConstraintLayout constrain1;
    int correctans;
   ArrayList<Integer> answers =new ArrayList<>();
    int correctloc;
    int qno;




   public void Choose(View view)
   {

        if(Integer.toString(correctloc).equals(view.getTag().toString()))
        {
            status.setText("Correct!");
            correctans++;

        }
        else
        {
            status.setText("Incorrect");
        }
        qno++;
        correct.setText(Integer.toString(correctans)+"/"+Integer.toString(qno));

        answers.clear();
        Start();

   }


   public  void timer()
   {
       new CountDownTimer(31000,1000)
       {

           @Override
           public void onTick(long l) {

               timer.setText(Long.toString(l/1000)+"S");

           }

           @Override
           public void onFinish() {
               status.setText("Done");
           }
       }.start();
   }


   public void Go(View view)
   {
       go.setVisibility(View.INVISIBLE);
       constrain1.setVisibility(View.VISIBLE);
       correctans=0;
       qno=0;
       Start();
       timer();
   }


    public void Start()
    {

        rand =new Random();
        int a =rand.nextInt(40);
        int b=rand.nextInt(40);
         correctloc=rand.nextInt(4);
        int wrongans=rand.nextInt(80);
        for(int i=0;i<4;i++)
        {
            if(correctloc==i)
            {
                answers.add(a+b);
            }
            else
            {  wrongans=rand.nextInt(80);
                while(wrongans==a+b)
                {
                    wrongans=rand.nextInt(80);
                }
                answers.add(wrongans);
            }
        }

        question.setText(Integer.toString(a)+"+"+Integer.toString(b));
        b0.setText(Integer.toString(answers.get(0)));
        b1.setText(Integer.toString(answers.get(1)));
        b2.setText(Integer.toString(answers.get(2)));
        b3.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        go=(Button)findViewById(R.id.button);
        question=(TextView)findViewById(R.id.question);
        status=(TextView)findViewById(R.id.textView) ;
        correct=(TextView)findViewById(R.id.quesionstatus);
        timer=(TextView)findViewById(R.id.timer);
        constrain1=(ConstraintLayout)findViewById(R.id.constrain);

        constrain1.setVisibility(View.INVISIBLE);
        
        go.setVisibility(View.VISIBLE);


    }
}

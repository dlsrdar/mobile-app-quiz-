package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.caps.GAME.Game;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum=0;
    private String result="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String s =((TextView) findViewById(R.id.score)).getText().toString()+score;
        ((TextView) findViewById(R.id.score)).setText(s);

        ask();

    }
    private void ask(){
        Game game = new Game();
        String x = game.qa();
        this.question = x.substring(0,x.indexOf("?")+1);
        this.answer = x.substring(x.indexOf("\n")+1);
        qNum=qNum+1;
        ((TextView) findViewById(R.id.number)).setText("Q#"+qNum);
        ((TextView) findViewById(R.id.question)).setText(question);




    }
    public void onDone(View v){
        if (qNum==10){
            String a =((EditText) findViewById(R.id.p)).getText().toString();
            if ((a.compareToIgnoreCase(answer))==0){
                score=score+1;
            }

            ((TextView) findViewById(R.id.score)).setText("SCORE="+score);
            result=result+"Q#"+qNum+":"+question+"\nYour answer:"+a+"\nCorrect answer:"+answer+"\n\n";
            ((TextView) findViewById(R.id.result)).setText(result);
            ((TextView) findViewById(R.id.number)).setText("GAME OVER!");
            finish();

        }
        else{
            String a =((EditText) findViewById(R.id.p)).getText().toString();
            if ((a.compareToIgnoreCase(answer))==0){
                score=score+1;
            }

            ((TextView) findViewById(R.id.score)).setText("SCORE="+score);
            result=result+"Q#"+qNum+":"+question+"\nYour answer:"+a+"\nCorrect answer:"+answer+"\n\n";
            ((TextView) findViewById(R.id.result)).setText(result);

            ask();

        }




    }
}
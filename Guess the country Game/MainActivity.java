package ca.yorku.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private int score;
    private int qNum;
    private String question;
    private String answer;
    private String log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = "";
        answer = "";
        score = 0;
        qNum = 1;
        log = "";
        ((TextView) findViewById(R.id.score)).setText("Score = " + score);
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + qNum);
        ask();
    }

    public void ask() {
        Game game = new Game();
        String codedResultString = game.qa();
        String lines[] = codedResultString.split("\\n");
        this.question = lines[0];
        this.answer = lines[1];
        TextView ques = ((TextView) findViewById(R.id.question));
        ques.setText(question);
        ((TextView) findViewById(R.id.score)).setText("Score = " + score);
        ((TextView)findViewById(R.id.qNum)).setText("Q# "+qNum);


    }


    public void onDone(View v) {


        TextView qN_ = (TextView) findViewById(R.id.qNum);
        TextView result_ = (TextView) findViewById(R.id.log);
        TextView score_ = (TextView) findViewById(R.id.score);
        String ans_, result__ = "";

        if (qNum == 9) {
            qN_.setText("Game Over!");
            Button button1 = (Button) findViewById(R.id.done);
            button1.setEnabled(false);
            button1.setClickable(false);
            finish();
        } else {

            ans_ = ((EditText) findViewById(R.id.answer)).getText().toString();
            result__ += "\nQ# " + qNum + ":" + question + "\nYour Answer: " + ans_.toUpperCase(Locale.ROOT) + "\nCorrect Answer: " + answer + "\n";
            log += result__;
            qNum++;
            qN_.setText("Q# " + qNum);
            result_.setText(log);
            if (ans_.equalsIgnoreCase(answer)) {
                score++;
                score_.setText("SCORE= " + score);
            }

            ask();

        }


    }
}
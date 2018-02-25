package rubel.example.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button divide, multiply, plus, minus, equal, dot, clear;
    private TextView info, result;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVITION = '/';
    private final char EQUAL = 0;
    private char ACTION;

    private double value1 = Double.NaN;
    private double value2;

    private void setupUIViews() {
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        divide = (Button) findViewById(R.id.btnDevide);
        multiply = (Button) findViewById(R.id.btnMul);
        plus = (Button) findViewById(R.id.btnPlus);
        minus = (Button) findViewById(R.id.btnMinus);
        equal = (Button) findViewById(R.id.btnEqual);
        dot = (Button) findViewById(R.id.btnDot);
        clear = (Button) findViewById(R.id.btnClear);

        info = (TextView) findViewById(R.id.textViewControl);
        result = (TextView) findViewById(R.id.textViewResult);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        equal.setOnClickListener(this);
        dot.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    private void compute() {
        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(info.getText().toString());
            switch (ACTION) {
                case ADDITION:
                    value1 += value2;
                    break;
                case SUBTRACTION:
                    value1 -= value2;
                    break;
                case MULTIPLICATION:
                    value1 *= value2;
                    break;
                case DIVITION:
                    value1 /= value2;
                    break;
                case EQUAL:
                    break;
            }


        }
        else {
            value1 = Double.parseDouble(info.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

    }

    @Override
    public void onClick(View view) {

      /*  if(view.getId()==R.id.btn0){
            info.setText(info.getText().toString() +"0");
        } */
        switch (view.getId()) {
            case (R.id.btn0):
                info.setText(info.getText().toString() + "0");
                break;
            case (R.id.btn1):
                info.setText(info.getText().toString() + "1");
                break;
            case (R.id.btn2):
                info.setText(info.getText().toString() + "2");
                break;
            case (R.id.btn3):
                info.setText(info.getText().toString() + "3");
                break;
            case (R.id.btn4):
                info.setText(info.getText().toString() + "4");
                break;
            case (R.id.btn5):
                info.setText(info.getText().toString() + "5");
                break;
            case (R.id.btn6):
                info.setText(info.getText().toString() + "6");
                break;
            case (R.id.btn7):
                info.setText(info.getText().toString() + "7");
                break;
            case (R.id.btn8):
                info.setText(info.getText().toString() + "8");
                break;
            case (R.id.btn9):
                info.setText(info.getText().toString() + "9");
                break;
            case (R.id.btnDot):
                info.setText(info.getText().toString() + ".");
                break;
            case (R.id.btnPlus): {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(value1) + " + ");
                info.setText(null);
                break;
            }
            case (R.id.btnMinus): {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(value1) + " - ");
                info.setText(null);
                break;
            }
            case (R.id.btnMul): {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(value1) + " * ");
                info.setText(null);
                break;
            }
            case (R.id.btnDevide): {
                compute();
                ACTION = DIVITION;
                result.setText(String.valueOf(value1) + " / ");
                info.setText(null);
                break;
            }
            case (R.id.btnEqual): {
                    compute();
                    ACTION = EQUAL;
                    result.setText(result.getText().toString() + String.valueOf(value2) + " = " + String.valueOf(value1));
                    info.setText(null);
                break;
            }
            case (R.id.btnClear): {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() -1));
                }
                else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
                break;
            }

        }
    }
}

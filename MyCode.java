import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven;
    Button buttonEight, buttonNine, buttonPlus, buttonMinus, buttonMultiply, buttonDivision, buttonEqual;
    Button buttonPoint, buttonPercent, buttonClear, buttonBack, buttonMenu;
    TextView input, output;
    int i, j, numberTwo;
    double number, numberOne = 0, answer = 0, result, numbers[] = new double[100];
    boolean isEqual = false, minus = false;
    char operator;
    String backSpace;

    void number(double digit) {
        i = 0;
        numbers[i++] = digit;
        for (j = 0; j < i; j++) {
            number = 10 * number + numbers[j];
        }
    }

    void resetData() {
        numberOne = number = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonZero = (Button) findViewById(R.id.zero);
        buttonOne = (Button) findViewById(R.id.one);
        buttonTwo = (Button) findViewById(R.id.two);
        buttonThree = (Button) findViewById(R.id.three);
        buttonFour = (Button) findViewById(R.id.four);
        buttonFive = (Button) findViewById(R.id.five);
        buttonSix = (Button) findViewById(R.id.six);
        buttonSeven = (Button) findViewById(R.id.seven);
        buttonEight = (Button) findViewById(R.id.eight);
        buttonNine = (Button) findViewById(R.id.nine);
        buttonPlus = (Button) findViewById(R.id.plus);
        buttonMinus = (Button) findViewById(R.id.minus);
        buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonDivision = (Button) findViewById(R.id.division);
        buttonEqual = (Button) findViewById(R.id.equal);
        buttonPoint = (Button) findViewById(R.id.point);
        buttonPercent = (Button) findViewById(R.id.percent);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonBack = (Button) findViewById(R.id.back);
        buttonMenu = (Button) findViewById(R.id.menu);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "0");
            }
        });
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number(1);
                input.setText(input.getText() + "1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number(2);
                input.setText(input.getText() + "2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + ".");
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '+';
                answer = answer + number;
                output.setText(String.valueOf(answer));
                number = 0;
                if (isEqual == true) {
                    input.setText(String.valueOf(answer));
                    isEqual = false;
                }
                input.setText(input.getText() + "+");
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '-';
                if(minus == false){
                    answer = number - answer;
                }
                else{
                    answer = answer - number;
                }
                output.setText(String.valueOf(answer));
                number = 0;
                if (isEqual == true) {
                    input.setText(String.valueOf(answer));
                    isEqual = false;
                }
                input.setText(input.getText() + "-");
                minus = true;
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = '*';
                numberOne = number * numberOne;
                if (answer == 0) {
                    output.setText(String.valueOf(numberOne));
                } else if (answer > 0 || answer < 0) {
                    input.setText(String.valueOf(answer));
                }
                number = 0;
                input.setText(input.getText() + "*");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEqual = true;
                input.setText(input.getText() + "=");
                switch (operator) {
                    case '+':
                        answer = answer + number;
                        output.setText(String.valueOf(answer));
                        break;
                    case '-':
                        answer = answer - number;
                        output.setText(String.valueOf(answer));
                        break;
                    case '*':
                        break;
                    case '/':
                        break;
                    default:
                        break;
                }
                resetData();
                numberOne = answer;
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetData();
                answer = 0;
                minus = false;
                input.setText("");
                output.setText("");
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backSpace = input.getText().toString();
                backSpace = backSpace.substring(0, backSpace.length() - 1);
                numberTwo = (int) number / 10;
                number = (double) numberTwo;
                input.setText(backSpace);
            }
        });
    }
}
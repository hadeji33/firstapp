package lairg.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Double firstValue;
    Double secondValue;
    String operation;
    Boolean point = false;
    TextView result;
    String countZero = "";
    Double res;
    long sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.textView);
    }


    public void buttonClick(View view) {
        Button button = (Button) view;

        switch (button.getText().toString()) {
            case "C":
                firstValue = null;
                secondValue = null;
                operation = null;
                editText.setText("");
                break;
            case ".":
                if (firstValue == null) {
                    firstValue = Double.valueOf(editText.getText().toString());
                    editText.setText(editText.getText().toString() + button.getText());
                } else if (secondValue != null) {
                    point = true;
                    editText.setText(editText.getText().toString() + button.getText());
                }
                break;
            case "←":
                String s = editText.getText().toString();
                editText.setText(s.substring(0, s.length() - 1));
                break;
            case "+":
                point = false;
                firstValue = Double.valueOf(editText.getText().toString());
                operation = "+";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "−":
                point = false;
                firstValue = Double.valueOf(editText.getText().toString());
                operation = "-";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "x":
                point = false;
                firstValue = Double.valueOf(editText.getText().toString());
                operation = "*";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "÷":
                point = false;
                firstValue = Double.valueOf(editText.getText().toString());
                operation = "/";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "=":

                switch (operation) {
                    case "+":
                        res = firstValue + secondValue;
                        break;
                    case "-":
                        res = firstValue - secondValue;
                        break;
                    case "*":
                        res = firstValue * secondValue;
                        break;
                    case "/":
                        if (secondValue == 0) {

                            res = null;

                        } else {
                            res = firstValue / secondValue;
                        }
                        break;
                    default:
                        break;
                }
                if (res != null){
                    result.setText(String.valueOf(res));
                }
                firstValue = null;
                res = null;
                secondValue = null;
                operation = null;
                point = false;
                editText.setText("");
                countZero = "";
                break;
            default:

                if (operation != null) {
                    if (secondValue != null)
                        if (!point){
                            sv = (Math.round(secondValue));
                            secondValue = Double.valueOf((String.valueOf(sv)  + button.getText().toString()));
                        } else {
                            secondValue = secondValue + Double.valueOf("0."+ countZero + button.getText().toString());
                            countZero = countZero + "0";
                        }
                    else
                        secondValue = Double.valueOf(button.getText().toString());

                }
                editText.setText(editText.getText().toString() + button.getText());
                break;
        }

    }



}


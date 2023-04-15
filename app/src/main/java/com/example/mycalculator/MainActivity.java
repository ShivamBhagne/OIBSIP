package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result_txt,solution_txt;
    MaterialButton Btn_C,Btn_OB,Btn_CB,Btn_divide,Btn_1,Btn_2,Btn_3,Btn_4,Btn_5,Btn_6,Btn_7,Btn_8,Btn_9,Btn_0,Btn_dot,Btn_addition,Btn_subtract,Btn_multiply,Btn_equal,Btn_AC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_txt=findViewById(R.id.result_txt);
        solution_txt=findViewById(R.id.solution_txt);
        assignid(Btn_C,R.id.btn_C);
        assignid(Btn_OB,R.id.btn_OB);
        assignid(Btn_CB,R.id.btn_CB);
        assignid(Btn_divide,R.id.btn_divide);
        assignid(Btn_1,R.id.btn_1);
        assignid(Btn_2,R.id.btn_2);
        assignid(Btn_3,R.id.btn_3);
        assignid(Btn_4,R.id.btn_4);
        assignid(Btn_5,R.id.btn_5);
        assignid(Btn_6,R.id.btn_6);
        assignid(Btn_7,R.id.btn_7);
        assignid(Btn_8,R.id.btn_8);
        assignid(Btn_9,R.id.btn_9);
        assignid(Btn_0,R.id.btn_0);
        assignid(Btn_dot,R.id.btn_dot);
        assignid(Btn_addition,R.id.btn_addition);
        assignid(Btn_subtract,R.id.btn_subtract);
        assignid(Btn_multiply,R.id.btn_multiply);

        assignid(Btn_AC,R.id.btn_AC);





    }
void assignid(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
}
    @Override
    public void onClick(View v) {
        MaterialButton btn=(MaterialButton) v;
        String btn_txt=btn.getText().toString();
        String data=solution_txt.getText().toString();
        if(btn_txt.equals("AC")){
            solution_txt.setText("");
            result_txt.setText("0");
            return;
        }
        if (btn_txt.equals("=")){
            solution_txt.setText(result_txt.getText());
            return;
        }
        if(btn_txt.equals("C")){
            data=data.substring(0,data.length()-1);
        }else{
            data=data+btn_txt;

        }

        solution_txt.setText(data);
        String finalres=getres(data);

            result_txt.setText(finalres);


    }
    String getres(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalres = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalres.endsWith(".0")) {
                finalres = finalres.replace(".0", "");

            }
            return finalres;
        } catch (Exception e) {
        return " ";
    }
    }
}
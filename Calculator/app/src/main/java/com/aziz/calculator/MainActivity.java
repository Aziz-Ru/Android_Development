package com.aziz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_plus,btn_neg,btn_multi,btn_divide,btn_delete,btn_clear,btn_equal,point;

    TextView result,edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text=findViewById(R.id.edit_txt);
        result=findViewById(R.id.result_txt);

        intialization(btn0,R.id.btn0);
        intialization(btn1,R.id.btn1);
        intialization(btn2,R.id.btn2);
        intialization(btn3,R.id.btn3);
        intialization(btn4,R.id.btn4);
        intialization(btn5,R.id.btn5);
        intialization(btn6,R.id.btn6);
        intialization(btn7,R.id.btn7);
        intialization(btn8,R.id.btn8);
        intialization(btn9,R.id.btn9);
        intialization(btn_plus,R.id.btn_plus);
        intialization(btn_neg,R.id.btn_neg);
        intialization(btn_multi,R.id.btn_multi);
        intialization(btn_divide,R.id.btn_divide);
        intialization(btn_delete,R.id.btn_delete);
        intialization(btn_clear,R.id.btn_clear);
        intialization(btn_equal,R.id.btn_equal);
        intialization(point,R.id.point);


    }

    private void intialization(Button btn,int id) {
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }

    public void click(View view) {
        String button_txt;
        if(view.getId()==R.id.btn0){
            button_txt=btn0.getText().toString();
            edit_text.setText(button_txt);
        }
    }

    @Override
    public void onClick(View v) {
        Button  btn=(Button) v;
    String button_txt=btn.getText().toString();
        String calculate=edit_text.getText().toString();
    if(button_txt.equals("C")){
        result.setText("");
        edit_text.setText("");
        return;
    }
    else if(button_txt.equals("D")){
        calculate=calculate.substring(0,calculate.length()-1);
        edit_text.setText(calculate);
        if(button_txt.equals("+")||button_txt.equals("-")||button_txt.equals("/")||button_txt.equals("*")){
            return;
        }
        String fin_res=getResult(calculate);
        result.setText(fin_res);
    }
    else if(button_txt.equals("=")){
        edit_text.setText(calculate);
        String fin_res=getResult(calculate);
        result.setText(fin_res);
    }else{
        calculate=calculate+button_txt;
        edit_text.setText(calculate);
        if(button_txt.equals("+")||button_txt.equals("-")||button_txt.equals("/")||button_txt.equals("*")){
            return;
        }
        String fin_res=getResult(calculate);
        result.setText(fin_res);


    }

    }
    String getResult(String s){
        try {
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String final_res=context.evaluateString(scriptable,s,"Javascript",1,null).toString();
            return final_res;
        }catch (Exception e){
            return "ERR";
        }


    }
}
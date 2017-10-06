package com.example.ms.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText angle_edit;
    EditText radian_edit;
    EditText centigrade_edit;
    EditText fahrenheit_edit;
    EditText length1_edit;
    EditText length2_edit;
    EditText quality1_edit;
    EditText quality2_edit;
    EditText time1_edit;
    EditText time2_edit;
    EditText storage1_edit;
    EditText storage2_edit;

    Spinner length1_spinner;
    Spinner length2_spinner;
    Spinner quality1_spinner;
    Spinner quality2_spinner;
    Spinner storage1_spinner;
    Spinner storage2_spinner;

    Button conversion_button;
    Button clear1_button;
    Button hint_button;

    TextView hint_view;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        conversion_button = (Button) findViewById(R.id.conversion_button);
        conversion_button.setOnClickListener(this);
        clear1_button = (Button) findViewById(R.id.clear1_button);
        clear1_button.setOnClickListener(this);
        hint_button = (Button) findViewById(R.id.hint_button);
        hint_button.setOnClickListener(this);

        length1_spinner = (Spinner) findViewById(R.id.length1_spinner);
        length2_spinner = (Spinner) findViewById(R.id.length2_spinner);
        quality1_spinner = (Spinner) findViewById(R.id.quality1_spinner);
        quality2_spinner = (Spinner) findViewById(R.id.quality2_spinner);
        storage1_spinner = (Spinner) findViewById(R.id.storage1_spinner);
        storage2_spinner = (Spinner) findViewById(R.id.storage2_spinner);

        angle_edit = (EditText) findViewById(R.id.angle_edit);
        radian_edit = (EditText) findViewById(R.id.radian_edit);
        centigrade_edit = (EditText) findViewById(R.id.centigrade_edit);
        fahrenheit_edit = (EditText) findViewById(R.id.fahrenheit_edit);
        length2_edit = (EditText) findViewById(R.id.length1_edit);
        length2_edit = (EditText) findViewById(R.id.length2_edit);
        quality1_edit = (EditText) findViewById(R.id.quality1_edit);
        quality2_edit = (EditText) findViewById(R.id.quality2_edit);
        storage1_edit = (EditText) findViewById(R.id.storage1_edit);
        storage2_edit = (EditText) findViewById(R.id.storage2_edit);

        hint_view = (TextView) findViewById(R.id.hint_view);
    }

    //清空
    public void Clear(){
        angle_edit.setText("");
        radian_edit.setText("");
        centigrade_edit.setText("");
        fahrenheit_edit.setText("");
        length1_edit.setText("");
        length2_edit.setText("");
        quality1_edit.setText("");
        quality2_edit.setText("");
        time1_edit.setText("");
        time2_edit.setText("");
        storage1_edit.setText("");
        storage2_edit.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clear1_button:
                angle_edit.setText("");
                radian_edit.setText("");
                break;
            case R.id.hint_button:
                if(i==0) {
                    i=1;
                    hint_view.setText("1、根据需要换算的单位类型在12种输入框中选择需要的一种，" +
                            "输入相应数值或者小数，点击“换算”按钮，" +
                            "程序就会自动换算成对应的单位数并输出结果。\n" +
                            "2、米，克，KB可以点击选择不同单位类型，每一次只能输入一种单位数进行换算，否则提示错误。\n"+
                            "3、每一次得到输出结果之后，进行下一次输入之前，都需要点击“清空”按钮之后才能进行输入。");
                }
                else {
                    i=0;
                    hint_view.setText("");
                }
                break;
            case R.id.conversion_button:
                String angle = angle_edit.getText().toString();
                String radian = radian_edit.getText().toString();
                String centigrade = centigrade_edit.getText().toString();
                String fahrenheit = fahrenheit_edit.getText().toString();
                try{
                    if(angle.length()!=0 && radian.length()==0){
                        double angle1 = Math.toRadians(Double.valueOf(angle));
                        radian_edit.setText(String.valueOf(angle1));
                    }
                    else{
                        Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                //
                break;
        }
    }



}

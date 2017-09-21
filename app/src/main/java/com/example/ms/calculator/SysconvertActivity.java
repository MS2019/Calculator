package com.example.ms.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SysconvertActivity extends AppCompatActivity implements View.OnClickListener{

    EditText binary_edit;
    EditText octonary_edit;
    EditText decimalism_edit;
    EditText hexadecimal_edit;
    TextView explain_textview;
    int i=0;
    Sysconvert sysconvert = new Sysconvert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sysconvert);

        Button convert_button = (Button)findViewById(R.id.convert_button);
        convert_button.setOnClickListener(this);
        Button clear_button = (Button)findViewById(R.id.clear_button);
        clear_button.setOnClickListener(this);
        Button explain_button = (Button)findViewById(R.id.explain_button);
        explain_button.setOnClickListener(this);

        binary_edit = (EditText)findViewById(R.id.binary_edit);
        octonary_edit = (EditText)findViewById(R.id.octonary_edit);
        decimalism_edit = (EditText)findViewById(R.id.decimalism_edit);
        hexadecimal_edit = (EditText)findViewById(R.id.hexadecimal_edit);
        explain_textview = (TextView)findViewById(R.id.explain_textview);
    }

    public void Clear(){
        binary_edit.setText("");
        octonary_edit.setText("");
        decimalism_edit.setText("");
        hexadecimal_edit.setText("");
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.clear_button:
                Clear();
                break;

            case R.id.explain_button:
                if(i==0) {
                    i=1;
                    explain_textview.setText("1、根据需要转换的进制数类型在四种进制输入框中选择需要的一种，" +
                            "根据限制条件输入相应数字或者字符或者二者混合，点击“转换”按钮，" +
                            "程序就会自动转换成其他三种进制数并在对应的进制框输出转换结果。\n\n" +
                            "2、每一次只能输入一种进制数进行转换，否则提示错误。\n\n"+
                            "3、每一次得到输出结果之后，进行下一次输入之前，都需要点击“清空”按钮之后才能进行输入。\n\n" +
                            "4、十六进制数暂只支持小于等于8位字符转换。");
                }
                else {
                    i=0;
                    explain_textview.setText("");
                }
                break;

            case R.id.convert_button:
                String bin = binary_edit.getText().toString();
                String oct = octonary_edit.getText().toString();
                String dec = decimalism_edit.getText().toString();
                String hex = hexadecimal_edit.getText().toString();

                try{
                    if(bin.length()!=0 && dec.length()==0 && oct.length()==0 && hex.length()==0){
                        octonary_edit.setText(sysconvert.BinToOct(bin));
                        decimalism_edit.setText(sysconvert.BinToDec(bin));
                        hexadecimal_edit.setText(sysconvert.BinToHex(bin));
                    }
                    else if(bin.length()==0 && oct.length()!=0 && dec.length()==0 && hex.length()==0){
                        binary_edit.setText(sysconvert.OctToBin(oct));
                        decimalism_edit.setText(sysconvert.OctToDec(oct));
                        hexadecimal_edit.setText(sysconvert.OctToHex(oct));
                    }
                    else if(bin.length()==0 && oct.length()==0 && dec.length()!=0 && hex.length()==0){
                        binary_edit.setText(sysconvert.DecToBin(dec));
                        octonary_edit.setText(sysconvert.DecToOct(dec));
                        hexadecimal_edit.setText(sysconvert.DecToHex(dec));
                    }
                    else if(bin.length()==0 && oct.length()==0 && dec.length()==0 && hex.length()!=0){
                        binary_edit.setText(sysconvert.HexToBin(hex));
                        octonary_edit.setText(sysconvert.HexToOct(hex));
                        decimalism_edit.setText(sysconvert.HexToDec(hex));
                    }
                    else{
                        Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT).show();
                        Clear();
                    }
                }catch (Exception e){
                    Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT).show();
                    Clear();
                    e.printStackTrace();
                }
                break;

            default:break;
        }
    }
}

package com.example.ms.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculation calculation = new Calculation();
    ;
    private TextView textView;
    Button[] buttons = new Button[27];
    int[] id=new int[]{
      R.id.bt0,R.id.bt1,R.id.bt2,R.id.bt3,R.id.bt4,R.id.bt5,R.id.bt6,R.id.bt7,R.id.bt8,R.id.bt9
            ,R.id.bt_left,R.id.bt_right,R.id.bt_x1,R.id.bt_xy,R.id.bt_radical,R.id.bt_sin
            ,R.id.bt_tan,R.id.bt_cos,R.id.bt_mod,R.id.bt_clear,R.id.bt_back,R.id.bt_divide
            ,R.id.bt_multiply,R.id.bt_subtract,R.id.bt_add,R.id.bt_dot,R.id.bt_equal
    };


    //菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.SysConvert_item:
                Intent intent1 = new Intent(MainActivity.this,SysconvertActivity.class);
                startActivity(intent1);
                break;
            case R.id.conversion_item:
                Intent intent2 = new Intent(MainActivity.this,ConversionActivity.class);
                startActivity(intent2);
                break;
            case R.id.help_item:
                Toast.makeText(MainActivity.this,"当输入的数据超过输入框长度限制时，可以上下滑动输入框显示数据",Toast.LENGTH_SHORT).show();
                break;
            case R.id.developer_item:
                Toast.makeText(MainActivity.this,"Developed by MS",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                finish();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<id.length;i++){
            buttons[i]=(Button)findViewById(id[i]);
            buttons[i].setOnClickListener(this);
        }
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt0:
                textView.append("0");
                break;
            case R.id.bt1:
                textView.append("1");
                break;
            case R.id.bt2:
                textView.append("2");
                break;
            case R.id.bt3:
                textView.append("3");
                break;
            case R.id.bt4:
                textView.append("4");
                break;
            case R.id.bt5:
                textView.append("5");
                break;
            case R.id.bt6:
                textView.append("6");
                break;
            case R.id.bt7:
                textView.append("7");
                break;
            case R.id.bt8:
                textView.append("8");
                break;
            case R.id.bt9:
                textView.append("9");
                break;
            case R.id.bt_dot:
                textView.append(".");
                break;


            case R.id.bt_add:
                textView.append("+");
                break;
            case R.id.bt_subtract:
                textView.append("-");
                break;
            case R.id.bt_multiply:
                textView.append("×");
                break;
            case R.id.bt_divide:
                textView.append("÷");
                break;
            case R.id.bt_mod:
                textView.append("%");
                break;
            case R.id.bt_sin:
                textView.append("s");
                break;
            case R.id.bt_cos:
                textView.append("c");
                break;
            case R.id.bt_tan:
                textView.append("t");
                break;
            case R.id.bt_radical:
                textView.append("√");
                break;
            case R.id.bt_xy:
                textView.append("^");
                break;
            case R.id.bt_x1:
                textView.append("!");
                break;
            case R.id.bt_left:
                textView.append("(");
                break;
            case R.id.bt_right:
                textView.append(")");
                break;

            case R.id.bt_clear:
                textView.setText("");
                calculation.Clear();
                break;
            case R.id.bt_back:
                String str1 = textView.getText().toString();
                int length = str1.length();
                if(length>1){
                    str1 = str1.substring(0,length-1);
                    textView.setText(str1);
                }
                else textView.setText("");
                break;

            case R.id.bt_equal:
                String str2 = textView.getText().toString();
                if(str2.length()==0){
                    Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(str2.charAt(0)=='-'){
                        str2 = "0"+str2;
                    }
                    if(str2.charAt(0)=='(' && str2.charAt(1)=='-'){
                        StringBuilder stringBuilder = new StringBuilder(str2);
                        stringBuilder.insert(1,'0');
                        str2 = stringBuilder.toString();
                    }
                    try{
                        Double str3 = calculation.Result(str2);
                        String result = String.valueOf(str3);
                        calculation.Clear();
                        textView.setText(result);
                    }catch(Exception e){
                        Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                        calculation.Clear();
                        textView.setText("");
                        e.printStackTrace();
                    }
                }
                break;
            default:break;
        }
    }
}

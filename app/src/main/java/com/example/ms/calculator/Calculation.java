package com.example.ms.calculator;

import android.widget.Toast;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MS on 2017/9/10.
 */

public class Calculation {

    Gamma gam = new Gamma();

    Stack<Double> numberStack = new Stack<>();    //运算数栈
    Stack<Character> operatorStack = new Stack<>();   //运算符栈

    public void Clear(){                     //清除两个栈中的数据
        numberStack.clear();
        operatorStack.clear();
    }

    public double Result(String str){           //总运算
        try{
            String str1 = insert(str);
            String[] elements = str1.split(" ");

            for(String element:elements){
                if(element.length()==0) continue;

                else if(element.charAt(0)=='+'||element.charAt(0)=='-'){
                    while (!operatorStack.isEmpty()&&(operatorStack.peek()=='+'||operatorStack.peek()=='-'
                            ||operatorStack.peek()=='×'||operatorStack.peek()=='÷'||operatorStack.peek()=='%'||operatorStack.peek()=='^'
                            ||operatorStack.peek()=='s'||operatorStack.peek()=='c'||operatorStack.peek()=='t'
                            ||operatorStack.peek()=='!'||operatorStack.peek()=='√'))
                    {
                        process(numberStack,operatorStack);
                    }
                    operatorStack.push(element.charAt(0));
                }

                else if(element.charAt(0)=='×'||element.charAt(0)=='÷'||element.charAt(0)=='%'||element.charAt(0)=='^'
                        ||element.charAt(0)=='s'||element.charAt(0)=='c'||element.charAt(0)=='t'||element.charAt(0)=='!'||element.charAt(0)=='√'){
                    while (!operatorStack.isEmpty()&&(operatorStack.peek()=='×'||operatorStack.peek()=='÷'||operatorStack.peek()=='%'
                            ||operatorStack.peek()=='^'||operatorStack.peek()=='s'||operatorStack.peek()=='c'||operatorStack.peek()=='t'
                            ||operatorStack.peek()=='!'||operatorStack.peek()=='√'))
                    {
                        process(numberStack,operatorStack);
                    }
                    operatorStack.push(element.charAt(0));
                }

                else if(element.trim().charAt(0)=='('){        //tirm()去掉字符首尾的空格
                    operatorStack.push('(');
                }

                else if(element.trim().charAt(0)==')'){
                    while (operatorStack.peek() != '('){
                        process(numberStack,operatorStack);
                    }
                    operatorStack.pop();
                }

                else{
                    numberStack.push(new Double(element));
                }
            }
            while(!operatorStack.isEmpty()){
                process(numberStack,operatorStack);
            }

        }catch (Exception e){
            Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT);
            e.printStackTrace();
        }
        return numberStack.pop();

    }

    public void process(Stack<Double> numberStack,Stack<Character> operatorStack){   //处理运算符
        char operator = operatorStack.pop();
        if(operator=='+'||operator=='-'||operator=='×'||operator=='÷'||operator=='%'||operator=='^'){        //弹出两个栈顶元素
            double number1 = numberStack.pop();
            double number2 = numberStack.pop();
            if(operator=='+') numberStack.push(number2 + number1);
            else if(operator=='-') numberStack.push(number2 - number1);
            else if(operator=='×') numberStack.push(number2 * number1);
            else if(operator=='÷') numberStack.push(number2 / number1);
            else if(operator=='%'){
                double result = number2 % number1;
                numberStack.push(result);
            }
            else if(operator=='^') numberStack.push(Math.pow(number2,number1));
        }

        else if(operator=='s'||operator=='c'||operator=='t'||operator=='!'||operator=='√'){                 //弹出一个栈顶元素
            double number3 = numberStack.pop();
            if(operator=='s') {
                double num1 = Math.toRadians(number3);      //角度转弧度
                numberStack.push(Math.sin(num1));
            }
            else if(operator=='c'){
                double num2 = Math.toRadians(number3);
                numberStack.push(Math.cos(num2));
            }
            else if(operator=='t'){
                double num3 = Math.toRadians(number3);
                numberStack.push(Math.tan(num3));
            }
            else if(operator=='√'){
                numberStack.push(Math.sqrt(number3));
            }
            else if(operator=='!'){
                String str = String.valueOf(number3);
                Pattern pattern = Pattern.compile("\\d+\\.[0]+$");   //正则表达式判断小数点后第一位是否为0
                Matcher matcher = pattern.matcher(str);
                if(matcher.matches()){                      //判断小数点后第一位是否为0，是，则执行整数阶乘求解；否，则执行小数阶乘求解
                    double s1=1;
                    for(int i=1;i<=number3;i++){
                        s1 = s1*i;
                    }
                    numberStack.push(s1);
                }
                else{
                    double s2 = gam.gamma(number3 + 1);           //根据小数阶乘求解原理计算，例：2.5！= gamma（2.5+1）
                    numberStack.push(s2);
                }
            }
            else{
                Toast.makeText(MyApplication.getContext(),"错误",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String insert(String s){               //在字符串中插入空格以便分解读取的字符串
        String result = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='×'
                    ||s.charAt(i)=='÷'||s.charAt(i)=='%'||s.charAt(i)=='^'||s.charAt(i)=='√'
                    ||s.charAt(i)=='!'||s.charAt(i)=='s'||s.charAt(i)=='c'||s.charAt(i)=='t')
            {
                result += " "+s.charAt(i)+" ";
            }
            else result += s.charAt(i);
        }
        return result;
    }

}

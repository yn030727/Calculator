package com.example.cal;

public class JudegementType {
    //判断是括号类型
    public static boolean isBracket(char c){
        if(c=='('||c==')'){
            return true;
        }else {
            return false;
        }
    }
    //判断是数字（0——9，.）
    public static boolean isNumber(char c){
        if(c=='.'||(c<='9'&&c>='0')){
            return true;
        }else{
            return false;
        }
    }
    //判断是运算符号
    public static boolean isOperationSymbol(char c){
        if(c=='*'||c=='/'||c=='+'||c=='-'){
            return true;
        }else{
            return false;
        }
    }
}

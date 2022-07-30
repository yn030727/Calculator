package com.example.cal;

import static android.content.ContentValues.TAG;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Object RuntimeException;
    private  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        /*按钮点击事件初始化*/
        Button button_0=(Button) findViewById(R.id.zero);
        Button button_1=(Button) findViewById(R.id.one);
        Button button_2=(Button) findViewById(R.id.two);
        Button button_3=(Button) findViewById(R.id.three);
        Button button_4=(Button) findViewById(R.id.four);
        Button button_5=(Button) findViewById(R.id.five);
        Button button_6=(Button) findViewById(R.id.six);
        Button button_7=(Button) findViewById(R.id.seven);
        Button button_8=(Button) findViewById(R.id.eight);
        Button button_9=(Button) findViewById(R.id.nine);
        Button button_add=(Button) findViewById(R.id.addnumber);
        Button button_sub=(Button) findViewById(R.id.sub);
        Button button_multiply=(Button) findViewById(R.id.multiply1);
        Button button_div=(Button) findViewById(R.id.div);
        Button button_ac=(Button) findViewById(R.id.ac);
        Button button_delete=(Button) findViewById(R.id.delete);
        Button button_equal=(Button) findViewById(R.id.equal);
        Button button_point=(Button) findViewById(R.id.point);
        Button button_right=(Button) findViewById(R.id.right1);
        Button button_left=(Button) findViewById(R.id.left1);
        /*设置监听器*/
        button_0.setOnClickListener(this);
        button_1.setOnClickListener( this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_ac.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);


        textView=findViewById(R.id.result);
    }
    /*重写点击事件中我们所需要的一些参数*/
    String str="";//得到中缀表达式的字符串
    boolean firstZero=false;//对于一个数字来说，除非是小于1大于-1的小数，不然0不可能在首位。我们每次都将0添加到str中，但如果后面一个不是"."，就删除这个0
    int leftnumber=0;
    /*重写点击事件 */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                //除以0的情况
                if(str.length()!=0&&str.charAt(str.length()-1)=='/'){
                    textView.setText("Error，you div zero!");
                    break;
                }
                //如果是小数点后一个情况
                else if(str.length()!=0&&str.charAt(str.length()-1)=='.'){
                    str+="0";
                    firstZero=false;
                }
                //0前面是一个数字
                else if(str.length()!=0&&(str.charAt(str.length()-1)<='9'&&str.charAt(str.length()-1)>='0')){
                    //0前面是0，并且是首0的情况
                    if(str.charAt(str.length()-1)=='0'&&firstZero){
                        break;
                    }
                    firstZero=false;
                    str+="0";
                }
                //0前面是一个除了右括号以外的其他符号
                else if(str.length()!=0&&(!(str.charAt(str.length()-1)<='9'&&str.charAt(str.length()-1)>='0')&&str.charAt(str.length()-1)!=')')){
                    str+="0";
                    firstZero=true;
                }
                //0前面是右括号
                else if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"0";
                    firstZero=true;
                }
                //0在第一个
                else {
                    str+="0";
                    firstZero=true;
                }
                textView.setText(str);
                break;
            case R.id.one:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"1";
                }
                str+="1";
                textView.setText(str);
                break;
            case R.id.two:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"2";
                }
                str+="2";
                textView.setText(str);
                break;
            case R.id.three:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"3";
                }
                str+="3";
                textView.setText(str);
                break;
            case R.id.four:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"4";
                }
                str+="4";
                textView.setText(str);
                break;
            case R.id.five:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"5";
                }
                str+="5";
                textView.setText(str);
                break;
            case R.id.six:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"6";
                }
                str+="6";
                textView.setText(str);
                break;
            case R.id.seven:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"7";
                }
                str+="7";
                textView.setText(str);
                break;
            case R.id.eight:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"8";
                }
                str+="8";
                textView.setText(str);
                break;
            case R.id.nine:
                //如果前面一个是首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str=str.substring(0,str.length()-1);
                }
                //如果前面是右括号
                if(str.length()!=0&&str.charAt(str.length()-1)==')'){
                    str+="*"+"9";
                }
                str+="9";
                textView.setText(str);
                break;
            case R.id.addnumber:
                //根据+号前面的所有可能排列得出：
                //+号前面是除了右括号以外的符号，那么我们不用管这个+号，不用加入到str中
                if(str.length()!=0&& (str.charAt(str.length()-1)!=')'&&!(str.charAt(str.length()-1)<='9'&&str.charAt(str.length()-1)>='0'))){
                    break;
                }
                //+号是第一个，不用管，不加
                else if(str.length()==0){
                    break;
                }
                //+号前面是小数点
                else if(str.length()!=0&&str.charAt(str.length()-1)=='.'){
                    str+="0"+"+";
                }
                //加号前面是首0
                else if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero) {
                    str+="+";
                    firstZero=false;
                }else{
                    str+="+";
                }
                textView.setText(str);
                break;
            case R.id.sub:
                //-号前面首0
                if(str.length()!=0&&str.charAt(str.length()-1)=='0'&&firstZero){
                    str+="-";
                    firstZero=false;
                }
                //-号前面是"."
                else if(str.length()!=0&&str.charAt(str.length()-1)=='.'){
                    str+="0"+"-";
                }
                //-号前面是”+“ ”*“ ”/"
                else if(str.length()!=0&&(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='*'||str.charAt(str.length()-1)=='/')){
                    str=str.substring(0,str.length()-1);
                    str+="-";
                }
                //-号前面是“-”
                else if(str.length()!=0&&str.charAt(str.length()-1)=='-'){
                    str=str.substring(0,str.length()-1);
                    str+="+";
                }
                //-号在第一个
                else if(str.length()==0){
                    str+="-";
                }else{
                    str+="-";
                }
                textView.setText(str);
                break;

            case R.id.multiply1:
                //x号在第一个或者是前面是“."符号的情况
                if(str.length()==0||(str.length()!=0&&str.charAt(str.length()-1)=='.')){
                    str+="0"+"*";
                }
                //x号在四则运算符的后面
                else if(str.length()!=0&&(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='*'||str.charAt(str.length()-1)=='/')){
                    str=str.substring(0,str.length()-1);
                    str+="*";
                }
                //x号在左括号旁边
                else if(str.length()!=0&&str.charAt(str.length()-1)=='('){
                    break;
                }
                else{
                    if(firstZero)firstZero=false;
                    str+="*";
                }
                textView.setText(str);
                break;
            case R.id.div:
                //   /号在第一个或者是前面是“."符号的情况
                if(str.length()==0||(str.length()!=0&&str.charAt(str.length()-1)=='.')){
                    str+="0"+"/";
                }
                //  /号在四则运算符的后面
                else if(str.length()!=0&&(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='*'||str.charAt(str.length()-1)=='/')){
                    str=str.substring(0,str.length()-1);
                    str+="/";
                }
                // /号在左括号旁边
                else if(str.length()!=0&&str.charAt(str.length()-1)=='('){
                    break;
                }
                else{
                    if(firstZero)firstZero=false;
                    str+="/";
                }
                textView.setText(str);
                break;
            case R.id.point:
                //小数点前面是数字（需要考虑这个数字里面有几个小括号）
                //对字符串做一次遍历，减去所有的数字，如果最后一个是符号说明只有一个，但是如果是小数点说明你这个数里面有两个小数点了
                if(str.length()!=0&&str.charAt(str.length()-1)>='0'&&str.charAt(str.length()-1)<='9'){
                    if(firstZero)firstZero=false;
                    int strLength=str.length()-1;
                    while(strLength>=0&&(str.charAt(strLength)>='0'&&str.charAt(strLength)<='9')){
                        strLength--;
                    }
                    if(strLength>=0&&str.charAt(strLength)=='.'){
                        Toast.makeText(MainActivity.this,"you add 2 point",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    str+=".";
                }
                //小数点前面是右括号和小数点
                else if(str.length()!=0&&(str.charAt(str.length()-1)==')')||str.charAt(str.length()-1)=='.'){
                    break;
                }else{//小数点前面是符号和左括号
                    str+="0"+".";
                }
                textView.setText(str);
                break;
            case R.id.left1:
                //对于.( 因为在计算器中会出错，我们就不允许这种输入
                //左括号前面是小数
                if(str.length()!=0&&str.charAt(str.length()-1)=='.'){
                    break;
                }
                //左括号前面是常数和右括号
                if(str.length()!=0&&((str.charAt(str.length()-1)<='9'&&str.charAt(str.length()-1)>='0')||str.charAt(str.length()-1)==')')){
                    str+="*"+"(";
                }else{
                    str+="(";
                }
                leftnumber++;
                textView.setText(str);
                break;
            case R.id.right1:
                //判断右括号的前提就是得有左括号
                if(leftnumber>0){
                    //右括号如果前面是小数点
                    if (str.length()!=0&&str.charAt(str.length()-1)=='.'){
                        str+="0"+")";
                        leftnumber--;
                    }
                    //右括号前面是0到9或者是右括号
                    else if(str.length()!=0&&((str.charAt(str.length()-1)<='9'&&str.charAt(str.length()-1)>='0')||str.charAt(str.length()-1)==')')){
                        if(firstZero)firstZero=false;
                        str+=")";
                        leftnumber--;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
                textView.setText(str);
                break;
            case R.id.ac:
                //清空数据
                str="";
                textView.setText(str);
                break;
            case R.id.delete:
                if(str.length()==0||str.length()==1){
                    str="";
                }
                //左括号删出 number-1
                else if(str.charAt(str.length()-1)=='('){
                    str=str.substring(0,str.length()-1);
                    leftnumber--;
                }
                //右括号删出  number+1
                else if(str.charAt(str.length()-1)==')'){
                    str=str.substring(0,str.length()-1);
                    leftnumber++;
                }else{
                    if(firstZero)firstZero=false;
                    str=str.substring(0,str.length()-1);
                }
                textView.setText(str);
                break;
            case R.id.equal:
                if(str.length()==0)break;
                else if(JudegementType.isOperationSymbol(str.charAt(str.length()-1))) {
                    break;
                }
                if(leftnumber!=0){
                    for(int i=0;i<leftnumber;i++){
                        str+=')';
                    }
                    leftnumber=0;
                }
                //中缀表达式转后缀表达式
                String answer=midtoend(str);
                textView.setText(answer);
                str=answer;//你对文本的减减操作是基于str的
                break;
        }

    }
    //将中缀表达式str转换成后缀表达式并返回
    //
    public static String midtoend(String str){
      List<String> list=new ArrayList<>();//最后后缀表达式存放的地方
        Stack<Character> OperationStack=new Stack<>();//堆用来存放符号字符
        //我们根据str字符串从头开始遍历，取出数字，让数字进入队列。  取出符号，进入栈做判断
        StringBuffer sb=new StringBuffer("");//模拟队列
        //关于怎么得出一个数，判断当前数如果是字符串的最后一个或者它的下面一个数是字符，就把这个数放入到list集合，并清空队列
        //如果是左括号，直接入栈
        //如果是右括号，将符号出栈，直到碰到左括号，两者抵消
        //如果前面一个是符号，压入栈做判断

        //解决掉-号的问题
        for(int j=0;j<str.length();j++){
            if(j==0){
                if(str.charAt(j)=='-'){
                    str="0"+str;
                }
            }else if(str.charAt(j)=='-'&&str.charAt(j-1)=='('){//
                StringBuffer sb2=new StringBuffer(str);
                sb2.insert(j,"0");
                str=sb2.toString();
            }
        }
        //开始操作
        for(int i=0;i<str.length();i++) {
            //数字
            //第一个数只有左括号和数字，排除左括号    不是第一个数，数和小数点都要进入集合
            //(i==0&&str.charAt(i)!='(')||(i!=0&&JudegementType.isNumber(str.charAt(i)))
            if (JudegementType.isNumber(str.charAt(i))) {
                sb.append(str.charAt(i));
                //如果是字符串的最后一个或者它的下面一个数是字符，就把这个数放入到list集合，并清空队列
                if (i == str.length() - 1 || (i < (str.length() - 1) && (JudegementType.isOperationSymbol(str.charAt(i + 1))||(JudegementType.isBracket(str.charAt(i+1)))))) {
                    list.add(sb.toString());
                    sb = new StringBuffer("");
                }
            }
            //运算符号
            //
            else if (JudegementType.isOperationSymbol(str.charAt(i))) {
                //1.空栈直接入栈
                //2.当前符号优先级大于栈顶符号 当前符号入栈
                //3.当前符号优先级小于等于栈顶符号，栈顶符号弹出
                while (true) {
                    if (OperationStack.isEmpty()) {
                        OperationStack.push(str.charAt(i));
                        break;
                    } else if (OperationRank(str.charAt(i)) > OperationRank(OperationStack.peek())) {
                        OperationStack.push(str.charAt(i));
                        break;
                    } else {
                        char a = OperationStack.pop();
                        list.add(a + "");  //出栈
                    }
                }
            }
            //括号
            else if(JudegementType.isBracket(str.charAt(i))){
                //左括号直接压入栈
                if(str.charAt(i)=='('){
                    OperationStack.push(str.charAt(i));
                }else if(str.charAt(i)==')'){
                   while(true){
                       if(OperationStack.peek().charValue()=='('){
                           OperationStack.pop();
                           break;
                       }else{
                           list.add(OperationStack.pop().toString());
                       }
                   }
                }
            }
        }
        //最后清空栈.list里存放的就是已经分割好的后缀表达式，接下来我们计算后缀表达式
       while(!OperationStack.isEmpty()){
            list.add(OperationStack.pop()+"");
       }
         //计算后缀表达式
        BigDecimal answerfirst=culculateTwoNumber(list);
       String answer=answerfirst.toString();
        return answer ;
    }
    //对运算符号的优先级进行了一个排名
    public static int OperationRank(char t){
        switch (t) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
        }
        return -1;
    }
    //对后缀表达式进行计算
    public static BigDecimal culculateTwoNumber(List<String> list)throws  ArithmeticException{
        //新建一个栈
        Stack<BigDecimal> stackNumber =new Stack<>();
        //
        for(String item:list){
            if(JudegementType.isNumber(item.charAt(0))){
                stackNumber.push(new BigDecimal(item));
            }else{
                BigDecimal num2=stackNumber.pop();
                BigDecimal num1=stackNumber.pop();
                if(item.equals("+")){
                   stackNumber.push(num1.add(num2));
                }else if(item.equals("-")){
                    stackNumber.push(num1.subtract(num2));
                }else if(item.equals("*")){
                    stackNumber.push(num1.multiply(num2));
                }else if(item.equals("/")){
                    if(num2.intValue()==0){
                        throw new ArithmeticException("被除数为0，无法计算！");
                    }else{
                        stackNumber.push(num1.divide(num2,4,RoundingMode.HALF_UP));
                    }
                }else{
                    throw new ArithmeticException("无法运算的符号");
                }
            }
        }
        return stackNumber.pop();
    }
}
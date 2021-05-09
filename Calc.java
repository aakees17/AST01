package Calc;

import Text.Text;
import javax.swing.JOptionPane;
public class Calc {
    private Text t = null;
    public Calc() {
        this.t = new Text();
    }
    
    public char ASCII_Char(int number){
        try{return (char) number;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public int ASCII_Number(char ch){
        try{int i = ch; return i;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public long DigitSum(long num){
        long sum = 0; long q = num;
        while(q>0){
            sum = sum + (q%10);
            q = q / 10;
        }
        return sum;
    }
    public int DigitCount(long num){
        int count = 0; long q = num;
        while(q>0){
            q = q / 10;count++;
        }
        return count;
    }
    public long Sum(long... value){
        long sum = 0;
        for(int i = 0 ; i < value.length ; i++){
            sum = sum + value[i];
        }
        return sum;
    }
    public long Product(long... value){
        long product = 1;
        for(int i = 0 ; i < value.length ; i++){
            product = product * value[i];
        }
        return product;
    }
    public long Count(long... value){
        return value.length;
    }
    public long Power(long value, int power){
        long result = 1;
        while(power>0){
            result = result * value;
            power--;
        }
        return result;
    }
    public long Factorial(long value){
        long fact = 1;
        while(value>0){
            fact = fact * value;
            value--;
        }
        return fact;
    }
    public int Reverse(int value){
        int result = 0;
        while(value>0){
            result=result*10 + (value%10);
            value/=10;
        }
        return result;
    }
    public String Dec2Bin(int DecNum){
        String bin = ""; int count = 0, mul = 1;
        while(DecNum>0){
            if(DecNum%2==0){bin+=0;}
            else{bin+=1;}
            DecNum/=2;
        }
        char[] ch = bin.toCharArray();
        for(Character c: ch){
            if(c=='1'){break;}
            else{count++;}
        }
        int q = count;
        if(count>0){
            while(q>0){
                mul*=10;
                q--;
            }
            return (String.valueOf(Reverse(Integer.parseInt(bin)))  + this.t.Right(String.valueOf(mul), count));
        }
        return String.valueOf(Reverse(Integer.parseInt(bin)));
    }
    public int Dec2Oct(int dec){
        int result = 0;
        int q = dec;
        while(q>0){
            result = result * 10 + (q%8);
            q/=8;
        }
        return Reverse(result);
    }
    public String Dec2Hex(int dec){
        String result = "";
        String ch = "";
        while(dec%16!=0){
           if(dec%16>9){
               switch(dec%16){
                   case 10: ch = "A";
                   case 11: ch = "B";
                   case 12: ch = "C";
                   case 13: ch = "D";
                   case 14: ch = "E";
                   case 15: ch = "F";
               }
               result+=ch;
            }else{
              result+=dec%16;
           }
           dec/=16;
        }
        return this.t.Reverse(result);
    }
    public long Bin2Dec(String bin){
        long result = 0;
        char[] ch = bin.toCharArray();
        int len = ch.length;
        int powval = len - 1;
        for(int i = 0 ; i < len ; i++){
            result = result + Power(2,powval)*Integer.parseInt(String.valueOf(ch[i]));
            powval--;
        }
        return result;
    }
    public int Bin2Oct(String bin){
        int result = 0;
        long dec = Bin2Dec(bin);
        result = Dec2Oct((int) dec);
        return result;
    }
    public String Bin2Hex(String bin){
        String result = "";
        int dec = (int) Bin2Dec(bin);
        result = Dec2Hex(dec);
        return result;
    }
    public String Oct2Bin(int oct){
        String result = "";
        int oc = 0;
        int q = oct;
        int i = 0;
        while(q>0){
            oc = (q%10);
            while(oc>0){
                if(oc%2==0){result+="0";}
                else{result+="1";}
                oc/=2;
            }
            q=q/10;
            i++;
        }
        return t.Reverse(result);
    }
    public int Oct2Dec(int oct){
        int result = 0;
        String bin = Oct2Bin(oct);
        result = (int) Bin2Dec(bin);
        return result;
    }
    public String Oct2Hex(int oct){
        String result = "";
        int dec = Oct2Dec(oct);
        result = Dec2Hex(dec);
        return result;
    }
    
    
    public static void main(String[] args) {
        Calc calc = new Calc();
//        System.out.println(calc.Oct2Hex(75));
//        System.out.println(calc.Oct2Bin(65));
//        System.out.println(calc.Bin2Hex("11001101"));
//        System.out.println(calc.Bin2Oct("100100"));
//        System.out.println(calc.Dec2Oct(1255));
//        System.out.println(calc.Dec2Hex(1256));
//        long dec = calc.Bin2Dec("10101110");
//        System.out.println(dec);
//        JOptionPane.showMessageDialog(null, calc.Reverse(12345));
//        System.out.println( calc.Dec2Bin(451));
//        long[] val = {10,20,30,40,50,60};
//        JOptionPane.showMessageDialog(null, calc.Product(val));
//        JOptionPane.showMessageDialog(null, calc.Factorial(3));
//        JOptionPane.showMessageDialog(null, calc.Power(5,2));
//        long[] val = {10,20,30,40,50,60};
//        JOptionPane.showMessageDialog(null, calc.Count(val));
//        long[] val = {10,20,30,40,50,60};
//        JOptionPane.showMessageDialog(null, calc.Sum(val));
//        int num4 = 42;
//        JOptionPane.showMessageDialog(null, "Number: " + num4 
//                + "\nCharcter: " + calc.ASCII_Char(num4));
//        char ch = '@';
//        JOptionPane.showMessageDialog(null, "Character: " + ch 
//                + "\nCharcter: " + calc.ASCII_Number(ch));
//        long num2 = 108;
//        JOptionPane.showMessageDialog(null, "Number: " + num2 
//                + "\nDigit Sum: " + calc.DigitSum(num2));
//        long num3 = 454224465;
//        JOptionPane.showMessageDialog(null, "Number: " + num3 
//                + "\nDigit Count: " + calc.DigitCount(num3));
    }
}
    
    



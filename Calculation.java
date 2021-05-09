package Calc;

import java.util.Arrays;
import javax.swing.JOptionPane;

public interface Calculation {
    public default int getLength(String name){
        char[] ch = name.toCharArray();
        int count = 0;
        if("".equals(name)){
            JOptionPane.showMessageDialog(null, "Please enter name...");
        }
        else{
            for(char c:ch){
                count++;
            }
        }
        return count;
    }
    public default String FirstName(String fullname){
        return Left(fullname, Search(" ", fullname, 1)-1);
    }
    public default String MiddleName(String fullname){
        String middlename = "";
        int space = countSpace(fullname, ' ');
        if(space==1){
            middlename = "";
        }else{
        middlename = Mid(fullname, Search(" ", fullname, 1), 
                (Search(" ", Substitute(fullname, " ", "@"), 1)-1));
        }
        return middlename;
    }
    public default String LastName(String fullname){
        String lastname = "";
        int space = countSpace(fullname, ' ');
        if(space==1){
            lastname = Right(fullname,getLength(fullname)-Search(" ",fullname,1));
        }else{
            String substitute = Substitute(fullname," ","@");
            lastname = Right(substitute,getLength(substitute)-Search("@",substitute,1));
        }
        return lastname;
    }
    public default String Reverse(String name){
        String newStr = "";
        char[] ch = name.toCharArray();
        for(int i = ch.length-1;i>=0;i--){
            newStr = newStr + ch[i];
        }
        return newStr;
    }
    public default int Search(String charC,String name, int start){
        char[] ch = name.toCharArray();
        char c = charC.charAt(0);
        int num = 0;
        if("".equals(Arrays.toString(ch))){
           return 0;
        }
        for(int i = start-1 ; i<name.length() ; i++){
            if(ch[i] == c){
                num = num + 1;
                break;
            }
            else{
                num = num + 1;
            }
        }
        return num;
    }
    public default String Left(String name, int pos){
        String newStr = "";
        char[] c = name.toCharArray();
        for(int i=0 ; i<pos; i++){
            newStr = newStr + c[i];
        }
        return newStr;
    }
    public default String Right(String name, int num_char){
        String newStr = "";
        char[] c = name.toCharArray();
        for(int i=num_char-1 ; i<name.length(); i++){
            newStr = newStr + c[i];
        }
        return newStr;
    }
    public default String Mid(String name, int start, int num_char){
        String newStr = "";
        char[] ch = name.toCharArray();
        for(int i = num_char-1;i>=start;i--){
            newStr = newStr + ch[i];
        }
        return Reverse(newStr);
    }
    @SuppressWarnings("UnnecessaryLabelOnContinueStatement")
    public default String Substitute(String name, String oldChar, String newChar){
        String newStr = "";
        char[] ch = name.toCharArray();
        char old = oldChar.charAt(0);
        char newC = newChar.charAt(0);
        int pos = Search(oldChar,name,1)-1;
        For:
        for(int i = 0;i<ch.length;i++){
            if(i==pos){
                ch[pos]=newC;
                newStr = newStr + ch[pos];
                continue For;
            }
            else{
                newStr = newStr + ch[i];
            }
        }
        
        return newStr;
    }
    public default int countSpace(String name, char searchChar){
        int count = 0;
        char[] ch = name.toCharArray();
        for(int i = 0;i<ch.length;i++){
            if(ch[i] == searchChar){
                count++;
            }
        }
        return count;
    }
    
    public default char ASCII_Char(int number){
        try{return (char) number;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public default int ASCII_Number(char ch){
        try{int i = ch; return i;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public default long DigitSum(long num){
        long sum = 0; long q = num;
        while(q>0){
            sum = sum + (q%10);
            q = q / 10;
        }
        return sum;
    }
    public default int DigitCount(long num){
        int count = 0; long q = num;
        while(q>0){
            q = q / 10;count++;
        }
        return count;
    }
    public default long Sum(long... value){
        long sum = 0;
        for(int i = 0 ; i < value.length ; i++){
            sum = sum + value[i];
        }
        return sum;
    }
    public default long Product(long... value){
        long product = 1;
        for(int i = 0 ; i < value.length ; i++){
            product = product * value[i];
        }
        return product;
    }
    public default long Count(long... value){
        return value.length;
    }
    public default long Power(long value, int power){
        long result = 1;
        while(power>0){
            result = result * value;
            power--;
        }
        return result;
    }
    public default long Factorial(long value){
        long fact = 1;
        while(value>0){
            fact = fact * value;
            value--;
        }
        return fact;
    }
    public default int Reverse(int value){
        int result = 0;
        while(value>0){
            result=result*10 + (value%10);
            value/=10;
        }
        return result;
    }
    public default String Dec2Bin(int DecNum){
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
            return (String.valueOf(Reverse(Integer.parseInt(bin)))  + this.Right(String.valueOf(mul), count));
        }
        return String.valueOf(Reverse(Integer.parseInt(bin)));
    }
    public default int Dec2Oct(int dec){
        int result = 0;
        int q = dec;
        while(q>0){
            result = result * 10 + (q%8);
            q/=8;
        }
        return Reverse(result);
    }
    public default String Dec2Hex(int dec){
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
        return this.Reverse(result);
    }
    public default long Bin2Dec(String bin){
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
    public default int Bin2Oct(String bin){
        int result = 0;
        long dec = Bin2Dec(bin);
        result = Dec2Oct((int) dec);
        return result;
    }
    public default String Bin2Hex(String bin){
        String result = "";
        int dec = (int) Bin2Dec(bin);
        result = Dec2Hex(dec);
        return result;
    }
    public default String Oct2Bin(int oct){
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
        return Reverse(result);
    }
    public default int Oct2Dec(int oct){
        int result = 0;
        String bin = Oct2Bin(oct);
        result = (int) Bin2Dec(bin);
        return result;
    }
    public default String Oct2Hex(int oct){
        String result = "";
        int dec = Oct2Dec(oct);
        result = Dec2Hex(dec);
        return result;
    }
    
}

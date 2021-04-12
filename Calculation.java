package Calc;

import javax.swing.JOptionPane;
public class Calculation {
    public Calculation() {
    }
    
    public char getCharacter(int number){
        try{return (char) number;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public int getNumber(char ch){
        try{int i = ch; return i;}
        catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
        return 0;}
    public Object getPassword(String name){
        String str = "";
        char[] fullname = name.toCharArray(); int len = fullname.length;
        for(char c:fullname){
            int num = (int) c;
            str = str + num;
        }
        String num = getStart(str,6);
        return num;
    }
    public long getDigitSum(long num){
        long sum = 0; long q = num;
        while(q>0){
            sum = sum + (q%10);
            q = q / 10;
        }
        return sum;
    }
    public int getDigitCount(long num){
        int count = 0; long q = num;
        while(q>0){
            q = q / 10;count++;
        }
        return count;
    }
    public String getStart(String num, int pos){
        String pass = "";
        char[] ch = num.toCharArray();
        int count = 0;
        for(Character c: ch){
            pass = pass + c; count++;
            if(count==pos){return pass;}
        }
        return null;
    }
    
        public static void main(String[] args) {
        Calculation calc = new Calculation();
        
        
        String num = "456652456";
        JOptionPane.showMessageDialog(null, "Number: " + num 
                + "\nDigit: " + calc.getStart(num, 6));
        int num4 = 42;
        JOptionPane.showMessageDialog(null, "Number: " + num4 
                + "\nCharcter: " + calc.getCharacter(num4));
        char ch = '@';
        JOptionPane.showMessageDialog(null, "Character: " + ch 
                + "\nCharcter: " + calc.getNumber(ch));
        String name = "Akash Salvi";
        JOptionPane.showMessageDialog(null, "Name: " + name
                + "\nLength: " + name.length()
                + "\nConvert number name: " + calc.getPassword(name));
        long num2 = 108;
        JOptionPane.showMessageDialog(null, "Number: " + num2 
                + "\nDigit Sum: " + calc.getDigitSum(num2));
        long num3 = 454224465;
        JOptionPane.showMessageDialog(null, "Number: " + num3 
                + "\nDigit Count: " + calc.getDigitCount(num3));
    }
}
    
    



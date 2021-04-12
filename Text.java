package Text;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Text {
    public Text() {}
    public int getLength(String name){
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
    public String FirstName(String fullname){
        return Left(fullname, Search(" ", fullname, 1)-1);
    }
    public String MiddleName(String fullname){
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
    public String LastName(String fullname){
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
    public String Reverse(String name){
        String newStr = "";
        char[] ch = name.toCharArray();
        for(int i = ch.length-1;i>=0;i--){
            newStr = newStr + ch[i];
        }
        return newStr;
    }
    public int Search(String charC,String name, int start){
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
    public String Left(String name, int pos){
        String newStr = "";
        char[] c = name.toCharArray();
        for(int i=0 ; i<pos; i++){
            newStr = newStr + c[i];
        }
        return newStr;
    }
    public String Right(String name, int num_char){
        String newStr = "";
        char[] c = name.toCharArray();
        for(int i=num_char-1 ; i<name.length(); i++){
            newStr = newStr + c[i];
        }
        return newStr;
    }
    public String Mid(String name, int start, int num_char){
        String newStr = "";
        char[] ch = name.toCharArray();
        for(int i = num_char-1;i>=start;i--){
            newStr = newStr + ch[i];
        }
        return Reverse(newStr);
    }
    @SuppressWarnings("UnnecessaryLabelOnContinueStatement")
    public String Substitute(String name, String oldChar, String newChar){
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
    public int countSpace(String name, char searchChar){
        int count = 0;
        char[] ch = name.toCharArray();
        for(int i = 0;i<ch.length;i++){
            if(ch[i] == searchChar){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
//        Text str = new Text();
//        String fullname1 = "Aakash Vijay Ambulkar";
//        System.out.println("Middle Name: " + str.Mid(fullname1, 7, 12));
//        System.out.println("First Space Location: " + str.Search(" ", fullname1, 1));
//        System.out.println("Substitute: " + str.Substitute(fullname1, " ", "@"));
//        System.out.println("Length of Substitute: " + str.getLength(str.Substitute(fullname1, " ", "@")));
//        System.out.println("Find @ on Substitute: " + (str.Search(" ", str.Substitute(fullname1, " ", "@"), 1)-1));
//        System.out.println("Middle Name: " + str.Mid(fullname1, str.Search(" ", fullname1, 1), 
//                (str.Search(" ", str.Substitute(fullname1, " ", "@"), 1)-1)));
//        System.out.println("Full Name: " + fullname1 
//                + "\n First Name: " + str.FirstName(fullname1)
//                + "\n Middle Name: " + str.MiddleName(fullname1)
//                + "\n Last Name: " + str.LastName(fullname1));
//        String fullname2 = "Aakash Ambulkar";
//        System.out.println("Full Name: " + fullname2 
//                + "\n First Name: " + str.FirstName(fullname2)
//                + "\n Middle Name: " + str.MiddleName(fullname2)
//                + "\n Last Name: " + str.LastName(fullname2));
    }
}

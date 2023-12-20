import java.util.*;

class Main{
    /*
        For Simple Strings, the first byte of the reply is "+"
        For Errors, the first byte of the reply is "-"
        For Integers, the first byte of the reply is ":"
        For Bulk Strings, the first byte of the reply is "$"
        For Arrays, the first byte of the reply is "*"
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take ip
        String input = sc.nextLine();

        whichByte(input);

    }

    public static void whichByte(String input){

        if(input.equals("PING")) System.out.println("PONG");
        if(input.equals("ping")) System.out.println("pong");

        if(input.charAt(0)=='+')
            simpleString(input);
        if(input.charAt(0)=='-')
            errorMsg(input);
        if(input.charAt(0)==':')
            integers(input);
        if(input.charAt(0)=='$')
            bulkStrings(input);
        if(input.charAt(0)=='*')
            arrays(input);
    }
    //+
    public static void simpleString(String input){
        int ind = -1;
        //gives error for input "+ok" cmd -> done
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='\\') {
                ind = i;
                break;
            } 
        }

        try{
            System.out.println(input.substring(1, ind));
        }
        catch(RuntimeException e){
//            System.out.println("RunTimeException: " + e.getMessage());
            System.out.println("Wrong input format");
        }
    }

    //-
    public static void errorMsg(String input){
        int ind = -1;
        //gives error for "-ok" cmd  -> done
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='\\') {
                ind = i;
                break;
            }
        }

        try{
            System.out.println(input.substring(1, ind));
        }
        catch(RuntimeException e){
//            System.out.println("RunTimeException: " + e.getMessage());
            System.out.println("ERR unknown command " + "'" + input + "'");
        }
    }

    //:
    public static void integers(String input){
        int ind = -1;

        /*
        check early if the og redis do that
        then
        if integer, print as integer not as double
         */

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='\\') {
                ind = i;
                break;
            }
        }

        try{
            double number  = Double.parseDouble(input.substring(1, ind));
            System.out.println(number);
        }
        catch(RuntimeException e){
//            System.out.println("RunTimeException: " + e.getMessage());
            System.out.println("Wrong input format");
        }
    }

    //$
    public static void bulkStrings(String input){
        /*
        fails at any 2digit num
        $11\r\nhello world\r\n
        since it is picking only first digit, it will result in
        diff len exception
         */

        int startInd=0, lastInd = -1;
        if(input.charAt(1)=='-') {
            System.out.println("Null");
            return;
        }

        int len = Integer.parseInt(String.valueOf(input.charAt(1)));
        if(len==0) return;

        boolean started = false;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='n' && !started){
                started=true;
                startInd = i+1;
            }
            if(ch=='\\' && started) {
                lastInd = i;
                break;
            }
        }

        try{
            String output = input.substring(startInd, lastInd);
//            System.out.println(output);

            if(output.length()==len)
                System.out.println(output);
            else
                throw new Exception("Starting length differs from actual string length");
        }
        catch(RuntimeException e){
//            System.out.println("RunTimeException: " + e.getMessage());
            System.out.println("ERR unknown command " + "'" + input + "'");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void arrays(String input){
        /*
        failed for this
            *2\r\n$4\r\necho\r\n$11\r\nhello world\r\n
        only taking
            $11\r\nhell
         */

        //if len is 0
        if(input.charAt(1)=='0') return;

//        arrays can contain integers,
//        bulk of strings, simple string

        //to check if elements are size len
        int len = Integer.parseInt(String.valueOf(input.charAt(1)));


        /*
        errors can occur like
            *1\r\n   wrong format
            *\r\n    basically wrong format

            when calling other functions if one return  error
            just exit from there
         */
        int startInd = 0;
        boolean gotElem = false;
        char firstByte = '.';
        int firstByteFnLen = -1;

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);

            //find the starting char, get the whole ind
            //substring it, pass to relevant function
            if(ch=='$' || ch==':' || ch=='-' || ch=='+'){
                firstByte = ch;
                gotElem = true;
                startInd = i;
                if(ch=='$') {
                    StringBuilder ss = new StringBuilder();
                    i++;
                    while(input.charAt(i)!='\\'){
                        ss.append(input.charAt(i));
                        i++;
                    }
                    firstByteFnLen = Integer.parseInt(ss.toString());
                }
            }

            if(gotElem){
                //got the input required

                //for other input that don't require \r\n  \r\n
                int endInd = -1;
                if(firstByte!='$'){
                    while(input.charAt(i)!='\\') i++;
                    endInd = i+3;   //stops at \  so have to add for r\n
                } else {
                    endInd = startInd + 9 + firstByteFnLen;
                }


                String sub = input.substring(startInd, endInd+1);
//                System.out.println("substring: " + sub);
                whichByte(sub);

                //done with this elem
                gotElem = false;
                startInd = 0;
                firstByte = '.';
                i = endInd;
            }
        }


    }

}

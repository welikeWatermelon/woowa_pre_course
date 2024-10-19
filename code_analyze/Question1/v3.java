package question_1;

import java.util.Scanner;
import java.util.ArrayList;


public class q1 {
    public static void main(String[] args) {
        char ndiv,ndiv1,ndiv2;
        ArrayList<Integer> arr;
        div a;

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //String str = "1,2:3";
        //String str = "//@\\n123@34";
        int result;
        //왜 String str 에서 \n을 입력하면 줄바꿈이 되고
        //scanner에서 \n을 입력하면 그대로 입력이 되지??
        //Scanner를 사용하여 문자열을 입력받을 때는 사용자가 직접 입력하는 내용을 그대로 받아와. 사용자가 \n을 입력하면, 이스케이프 시퀀스가 아니라 문자 그대로 입력하게 되는 것이야

        if (isNumeric(str)) {
            result = Integer.parseInt(str);
        }
        else if(str.isEmpty() || str.trim().isEmpty()) {
            result = 0;
        }
        //얘는 구분자가 하나 있을 때 사용 @
        else if (str.length() > 4 && str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) {
            ndiv = str.charAt(2);
            a = new div(str, ndiv);
            arr = a.arr();
            result=Integer.parseInt(str.substring(5, arr.get(0)));
            for (int i = 0; i < arr.size()-1; i++) {
                String substring = str.substring(arr.get(i)+1,arr.get(i+1));
                int num = Integer.parseInt(substring);
                result += num;
            }
            result+=Integer.parseInt(str.substring(arr.get(arr.size()-1)+1));
        } else {//얘는 구분자가 두개 있을 때 사용 , :
            ndiv1 = ',';
            ndiv2 = ':';
            a = new div(str, ndiv1, ndiv2);
            arr = a.arr();
            result=Integer.parseInt(str.substring(0, arr.get(0)));
            for (int i = 0; i < arr.size()-1; i++) {
                String substring = str.substring(arr.get(i)+1,arr.get(i+1));
                int num = Integer.parseInt(substring); //에러 발생하는 놈
                result += num;
            }
            result+=Integer.parseInt(str.substring(arr.get(arr.size()-1)+1));

        }
        System.out.println(result);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // 문자열을 숫자로 변환 시도
            return true; // 변환 성공
        } catch (NumberFormatException e) {
            return false; // 변환 실패
        }
    }
}


class div{ //구분자 위치 반환
    String str;
    char std,std1, std2;
    div(String str,char std) {
        this.str = str;
        this.std1 = std;
        this.std2 = std;
    }

    div(String str,char std1, char std2) {
        this.str = str;
        this.std1 = std1;
        this.std2 = std2;
    }

    public ArrayList<Integer> arr(){ //구분자 위치를 반환한다

        ArrayList<Integer> arr = new ArrayList<>();
        if (std1 == std2) { //구분자 같은거
            for (int i = 5; i < str.length(); i++) {
                if (str.charAt(i) == std1) {
                    arr.add(i);
                }
            }
        } else { //구분자 다른거
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == std1 || str.charAt(i) == std2) {
                    arr.add(i);
                }
            }
        }

        return arr;
    }
}

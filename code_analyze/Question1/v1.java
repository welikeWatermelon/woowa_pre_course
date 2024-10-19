package question_1;
//하나의 java 파일 안에서는 public을 하나만 선언할 수 있음
//public 선언한 클래스 명은 파일 이름과 동일해야함

import java.util.Scanner;
import java.util.ArrayList;

// "" -> 0임 조심 !!.
// IllegalArgumentException 예외처리 해줘야함

public class q1 {
    public static void main(String[] args) {
        char ndiv,ndiv1,ndiv2;
        ArrayList<Integer> arr;
        div a;

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //next()는 공백 앞에까지 문자를 받음
        //nextLine()은 줄 바꾼 전까지 문자를 받음
        //공백도 문자열임 - 아스키 값 존재(32) - 띄어쓰기
        //null은 문자열이 아니다


        //문자열 검사 후 //@\n의 @을 찾음
        //str.charAt(0)은 문자열 하나의 값만 반환함
        //str.substring(3, 5)은 3부터 4까지의 문자를 반환함
        if (str.length() > 4 && str.substring(0, 2) == "//" && str.substring(3, 5) == "\\n") {
            ndiv = str.charAt(2);
            a = new div(str, ndiv);
        } else {
            ndiv1 = ',';
            ndiv2 = ':';
            a = new div(str, ndiv1, ndiv2);
        }

        arr = a.arr();
        String modifiedStr = "0" + str + "0";
        // ArrayList<Integer>의 길이는 size()로 구해야함
        int sum = 0;
        for (int i = 0; i < arr.size()-1; i++) {
            //  ArrayList<Integer>에서 인덱스의 요소 찾기 : arr.get(index)
            String substring = modifiedStr.substring(arr.get(i),arr.get(i+1));
            int num = Integer.parseInt(substring);
            sum += num;
        }

        System.out.println(sum);


        // 만약 //\n 가 없다면 ',',':'로 나뉨
        // ,의 인덱스를 모두 찾아내고, :의 인덱스를 모두 찾아내서 배열에 차례대로 저장
        // 새로생긴 배열을 arr라 하자
        // arr는 인덱스를 이용해서 문자열을 나누며 숫자를 빼낼거임
        // 오름차순으로 배열에 저장하고, 그 사이 문자열을 숫자로 바꾼 후 계속하여 더함
            // 여기서 for문 사용
    }
}
//ndiv의 인덱스를 나타내는 클래스
//생성자를 다르게 해서 div(str,ndiv) 또는
//div(str,ndiv1,ndiv2)가 되도록 나타낼거임
class div{
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

    //구분자의 위치 배열을 뱉음
    //이 위치 배열로 for문을 돌려 숫자를 구분할 거임
    public ArrayList<Integer> arr(){

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        if (std1 == std2) {
            for (int i = 1; i < str.length()+1; i++) {
                if (str.charAt(i) == std1) {
                    arr.add(i);
                }
            }
            arr.add(str.length() + 1);
        } else {
            for (int i = 1; i < str.length()+1; i++) {
                if (str.charAt(i) == std1 || str.charAt(i) == std2) {
                    arr.add(i);
                }
            }
            arr.add(str.length() + 1);
        }

        return arr;
    }
}

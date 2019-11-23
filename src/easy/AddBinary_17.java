package easy;

/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary_17 {

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        //System.out.println(a.substring(0,4));
        System.out.println(addBinary(a,b));

    }

    public static String addBinary(String a, String b) {

        //使用长加短的形式
        String l;
        String s;
        if(a.length() >= b.length()){
            l = a;
            s = b;
        }else{
            l = b;
            s = a;
        }
        StringBuilder result = new StringBuilder();
        String flag = "0";
        int x = l.length();
        int y = s.length();
        //按短串的长度循环
        while(y>=1){
            String num1 = l.substring(x-1,x);
            String num2 = s.substring(y-1,y);
            x--;
            y--;
            //分情况计算，先计算串长相等的部分
            if(num1.equals(num2)){
                if(flag.equals("0") && num1.equals("1")){
                    flag = "1";
                    result.append("0");
                    continue;
                }
                if(flag.equals("0") && num1.equals("0")){
                    flag = "0";
                    result.append("0");
                    continue;
                }
                if(flag.equals("1") && num1.equals("1")){
                    flag = "1";
                    result.append("1");
                    continue;
                }
                if(flag.equals("1") && num1.equals("0")){
                    flag = "0";
                    result.append("1");
                    continue;
                }
            }else{
                if(flag.equals("1")){
                    flag = "1";
                    result.append("0");
                    continue;
                }else{
                    flag = "0";
                    result.append("1");
                    continue;
                }
            }

        }

        if(flag.equals("1") && x<=0){//长度相同
            return reseve(result.append(flag).toString());
        }
        if(flag.equals("1") && x>0){//长的串长出的部分与进位计算
            String pre = addOne(l.substring(0,x),flag);
            String suf = reseve(result.toString());
            return pre + suf;
        }
        if(flag.equals("0") && x>0){
            return l.substring(0,x) + reseve(result.toString());
        }

        return reseve(result.toString());
    }

    public static String addOne(String s, String flag){
        StringBuilder re = new StringBuilder();
        StringBuilder zero = new StringBuilder();
        if(s.contains("0")){
            for(int i=s.length();i>=1;i--){
                if(s.substring(i-1,i).equals("0")){
                    re.append(s.substring(0,i-1)).append(flag);
                    break;
                }else{
                    zero.append("0");
                }
            }
        }else{
            re.append("1");
            for(int i=0;i<s.length();i++){
                re.append("0");
            }
        }

        return re.append(zero).toString();
    }

    public static String reseve(String s){
        StringBuilder re = new StringBuilder();
        for(int i=s.length();i>=1;i--){
            re.append(s.substring(i-1,i));
        }
        return re.toString();
    }
}

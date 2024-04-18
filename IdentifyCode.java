package identifycode;

import java.util.Random;

public class IdentifyCode {
    public static void main(String[] args) {
        System.out.println(generateCode());
    }

    public static String generateCode() {
        Random random = new Random();
        String[] alphabet = new String[62];
        // 循环放入26个大小写字母
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf((char) ('a' + i));
            alphabet[i + 26] = String.valueOf((char) ('A' + i));
        }
        // 放入10个数字
        for (int i = 0; i < 10; i++) {
            alphabet[i + 52] = String.valueOf(i);
        }

        StringBuilder code = new StringBuilder();

        // 随机生成数字的位置
        int digitPosition = random.nextInt(5);

        for (int i = 0; i < 5; i++) {
            int index;
            if (i == digitPosition) {
                // 在指定位置生成数字
                index = random.nextInt(10) + 52;
            } else {
                // 在其他位置生成字母
                index = random.nextInt(52);
            }
            String randomChar = alphabet[index];
            code.append(randomChar);
        }

        return code.toString();
    }

}
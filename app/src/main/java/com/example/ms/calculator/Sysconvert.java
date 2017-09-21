package com.example.ms.calculator;

/**
 * Created by MS on 2017/9/13.
 */

public class Sysconvert {

    //处理二进制
    public String BinToOct(String bin){                  //输入二进制，输出八进制
        int oct1 = Integer.parseInt(bin,2);
        String oct2 = Integer.toOctalString(oct1);
        return oct2;
    }

    public String BinToDec(String bin){                  //输入二进制，输出十进制
        int dec1 = Integer.parseInt(bin,2);
        String dec2 = String.valueOf(dec1);
        return dec2;
    }

    public String BinToHex(String bin){                //输入二进制，输出十六进制
        int hex1 = Integer.parseInt(bin,2);
        String hex2 = Integer.toHexString(hex1);
        return hex2;
    }

    //处理八进制
    public String OctToBin(String oct){               //输入八进制，输出二进制
        int bin1 = Integer.parseInt(oct,8);
        String bin2 = Integer.toBinaryString(bin1);
        return bin2;
    }

    public String OctToDec(String oct){               //输入八进制，输出十进制
        int dec1 = Integer.parseInt(oct,8);
        String dec2 = String.valueOf(dec1);
        return dec2;
    }

    public String OctToHex(String oct){               //输入八进制，输出十六进制
        int hex1 = Integer.parseInt(oct,8);
        String hex2 = Integer.toHexString(hex1);
        return hex2;
    }

    //处理十进制
    public String DecToBin(String dec){            //输入十进制，输出二进制
        int bin1 = Integer.valueOf(dec);
        String bin2 = Integer.toBinaryString(bin1);
        return bin2;
    }

    public String DecToOct(String dec){                  //输入十进制，输出八进制
        int oct1 = Integer.valueOf(dec);
        String oct2 = Integer.toOctalString(oct1);
        return oct2;
    }

    public String DecToHex(String dec){           //输入十进制，输出十六进制
        int hex1 = Integer.valueOf(dec);
        String hex2 = Integer.toHexString(hex1);
        return hex2;
    }

    //处理十六进制
    public String HexToBin(String hex){          //输入十六进制，输出二进制
        int bin1 = Integer.parseInt(hex,16);
        String bin2 = Integer.toBinaryString(bin1);
        return bin2;
    }

    public String HexToOct(String hex){              //输入十六进制，输出八进制
        int oct1 = Integer.parseInt(hex,16);
        String oct2 = Integer.toOctalString(oct1);
        return oct2;
    }

    public String HexToDec(String hex){         //输入十六进制，输出十进制
        int dec1 = Integer.parseInt(hex,16);
        String dec2 = String.valueOf(dec1);
        return dec2;
    }
}

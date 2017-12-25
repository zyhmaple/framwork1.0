/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class UTF8EncodeUtil {
    public static String getUTF8StringFromGBKString(String gbkStr) {
        try {
            return new String(UTF8EncodeUtil.getUTF8BytesFromGBKString(gbkStr), "UTF-8");
        }
        catch (Exception e) {
            throw new InternalError();
        }
    }

    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        int i = 0;
        while (i < n) {
            char m = gbkStr.charAt(i);
            if (m < '?' && m >= '\u0000') {
                utfBytes[k++] = (byte)m;
            } else {
                utfBytes[k++] = (byte)(224 | m >> 12);
                utfBytes[k++] = (byte)(128 | m >> 6 & 63);
                utfBytes[k++] = (byte)(128 | m & 63);
            }
            ++i;
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }

    public static String gbk2utf8(String gbk) {
        String l_temp = UTF8EncodeUtil.GBK2Unicode(gbk);
        l_temp = UTF8EncodeUtil.unicodeToUtf8(l_temp);
        return l_temp;
    }

    public static String utf82gbk(String utf) {
        String l_temp = UTF8EncodeUtil.utf8ToUnicode(utf);
        l_temp = UTF8EncodeUtil.Unicode2GBK(l_temp);
        return l_temp;
    }

    public static String GBK2Unicode(String str) {
        StringBuffer result = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char chr1 = str.charAt(i);
            if (!UTF8EncodeUtil.isNeedConvert(chr1)) {
                result.append(chr1);
            } else {
                result.append("\\u" + Integer.toHexString(chr1));
            }
            ++i;
        }
        return result.toString();
    }

    public static String Unicode2GBK(String dataStr) {
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        int li_len = dataStr.length();
        while (index < li_len) {
            if (index >= li_len - 1 || !"\\u".equals(dataStr.substring(index, index + 2))) {
                buffer.append(dataStr.charAt(index));
                ++index;
                continue;
            }
            String charStr = "";
            charStr = dataStr.substring(index + 2, index + 6);
            char letter = (char)Integer.parseInt(charStr, 16);
            buffer.append(letter);
            index += 6;
        }
        return buffer.toString();
    }

    public static boolean isNeedConvert(char para) {
        if ((para & 255) != para) {
            return true;
        }
        return false;
    }

    public static String utf8ToUnicode(String inStr) {
        char[] myBuffer = inStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < inStr.length()) {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(myBuffer[i]);
            if (ub == Character.UnicodeBlock.BASIC_LATIN) {
                sb.append(myBuffer[i]);
            } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                int j = myBuffer[i] - 65248;
                sb.append((char)j);
            } else {
                short s = (short) myBuffer[i];
                String hexS = Integer.toHexString(s);
                String unicode = "\\u" + hexS;
                sb.append(unicode.toLowerCase());
            }
            ++i;
        }
        return sb.toString();
    }

    public static String unicodeToUtf8(String theString) {
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        int x = 0;
        while (x < len) {
            int aChar;
            if ((aChar = theString.charAt(x++)) == 92) {
                if ((aChar = theString.charAt(x++)) == 117) {
                    int value = 0;
                    int i = 0;
                    while (i < 4) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case 48: 
                            case 49: 
                            case 50: 
                            case 51: 
                            case 52: 
                            case 53: 
                            case 54: 
                            case 55: 
                            case 56: 
                            case 57: {
                                value = (value << 4) + aChar - 48;
                                break;
                            }
                            case 97: 
                            case 98: 
                            case 99: 
                            case 100: 
                            case 101: 
                            case 102: {
                                value = (value << 4) + 10 + aChar - 97;
                                break;
                            }
                            case 65: 
                            case 66: 
                            case 67: 
                            case 68: 
                            case 69: 
                            case 70: {
                                value = (value << 4) + 10 + aChar - 65;
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                            }
                        }
                        ++i;
                    }
                    outBuffer.append((char)value);
                    continue;
                }
                if (aChar == 116) {
                    aChar = 9;
                } else if (aChar == 114) {
                    aChar = 13;
                } else if (aChar == 110) {
                    aChar = 10;
                } else if (aChar == 102) {
                    aChar = 12;
                }
                outBuffer.append((char)aChar);
                continue;
            }
            outBuffer.append((char)aChar);
        }
        return outBuffer.toString();
    }

    public static byte[] gbkToutf8(String chenese) {
        char[] c = chenese.toCharArray();
        byte[] fullByte = new byte[3 * c.length];
        int i = 0;
        while (i < c.length) {
            char m = c[i];
            String word = Integer.toBinaryString(m);
            System.out.println(word);
            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();
            int j = 0;
            while (j < len) {
                sb.append("0");
                ++j;
            }
            sb.append(word);
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");
            System.out.println(sb.toString());
            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);
            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            byte[] bf = new byte[]{b0, b1, b2};
            fullByte[i * 3] = bf[0];
            fullByte[i * 3 + 1] = bf[1];
            fullByte[i * 3 + 2] = bf[2];
            ++i;
        }
        return fullByte;
    }

    public static String u2g(String sourceStr) throws Exception {
        Charset charset1 = Charset.forName("GBK");
        Charset charset2 = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset1.newDecoder();
        CharsetEncoder encoder = charset2.newEncoder();
        ByteBuffer bytes = ByteBuffer.allocate(sourceStr.getBytes().length);
        bytes.put(sourceStr.getBytes("GBK"));
        bytes.rewind();
        CharBuffer chars = decoder.decode(bytes);
        bytes = encoder.encode(chars);
        String str = new String(bytes.array(), "UTF-8");
        System.out.println("\u89e3\u7801\u540e:" + str);
        return str;
    }

    public static String readString(byte[] byteStr) throws Exception {
        InputStream is;
        String result;
        result = null;
        is = null;
        try {
            try {
                is = new ByteArrayInputStream(byteStr);
                InputStreamReader isr = new InputStreamReader(is, Charset.forName("gbk"));
                char[] buf = new char[1024];
                StringBuilder strb = new StringBuilder();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int readCount = 0;
                while (-1 != (readCount = isr.read(buf))) {
                    strb.append(buf, 0, readCount - 1);
                }
                result = strb.toString();
            }
            catch (Exception e) {
                throw new Exception(e);
            }
        }
        catch (Throwable throwable) {}
        try {
            is.close();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
}


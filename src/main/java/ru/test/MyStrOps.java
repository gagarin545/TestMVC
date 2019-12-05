package ru.test;

import java.io.IOException;
import java.util.function.Function;

class MyStrOps {


    static String myRelSS(Function<String,String> sf, String s) throws IOException {
        return sf.apply( s);
    }

    static String getks(String str) {
        StringBuilder s = new StringBuilder();
        if(str.contains("ff"))
            return str.replace("00", "");
        for(int i = 0; i < str.length(); i = str.indexOf(':', i) +1)
            s.append(Integer.valueOf(str.substring(i, str.indexOf(':', i))) - 30);
        return s.toString();
    }


}

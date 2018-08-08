package ru.job4j.calculate;

public class Check {

    public boolean mono(boolean[] data) {
       boolean result = true;
       boolean hasTrue = false;
       boolean hasFalse = false;
       for (int index = 0; index < data.length; index++) {
           if (!data[index]) {
               hasFalse = true;
               if (hasTrue) {  // массив имеет и True, и False
                   result = false;
               }
           } else {
               hasTrue = true;
               if (hasFalse) { //массив имеет и True, и False
                   result = false;
               }
           }
       }
        return result;  //либо только True, либо False
        }
}
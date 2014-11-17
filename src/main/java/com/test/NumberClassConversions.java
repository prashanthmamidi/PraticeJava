package com.test;

/**
 * Created by mami01 on 25/03/14.
 *
 * byte [-2^7 to 2^7 - 1]

 short [-2^15 to 2^15 - 1]

 int [-2^31 to 2^31 - 1]

 long [-2^63 to 2^63 - 1]

 char ['\u0000' (or 0) '\uffff' (or 65,535 inclusive)]

 Data Type	Default Value (for fields)
 byte	        0
 short	        0
 int	        0
 long	        0L
 float	        0.0f
 double     	0.0d
 char	        '\u0000'
 String (or any object)  	null
 boolean    	false
 */
public class NumberClassConversions {

    public static void main(String[] args) {
        /*Byte by = 10;
        Short st = 1;
        Integer intg = 15;
        Long lg = 30l;
        Double doub = 12.00; //double is a 64-bit precision IEEE 754 floating point
        Float flt = 13.6f; //float is a 32-bit precision IEEE 754 floating point*/

        byte by = 10;
        short st = 1;
        int intg = 15;
        long lg = 30l;
        double doub = 12.00d; //double is a 64-bit precision IEEE 754 floating point
        float flt = 13.6f; //float is a 32-bit precision IEEE 754 floating point

/*        by = st; //invalid
        by = intg;//invalid
        by = lg;//invalid

        st = by; // valid
        st = intg;//invalid
        st = lg;//invalid

        intg = by; // valid
        intg = st; // valid
        intg = lg; //invalid

        lg = by;// valid
        lg = st;// valid
        lg = intg;// valid
        lg = flt;//invalid
        lg = doub;//invalid

        doub = flt; // valid
        doub = lg; // valid
        doub = intg; // valid
        doub = st; // valid
        doub = by; // valid


        flt = doub;// invalid
        flt = lg;// valid
        flt = intg;// valid
        flt = st;// valid
        flt = by;// valid*/

    }
}

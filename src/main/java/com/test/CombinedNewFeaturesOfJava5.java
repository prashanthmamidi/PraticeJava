package com.test;

//static import

/*
import static com.test.SampleStaticValues.NUM_ZERO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;*/

/**
 * Created by mami01 on 04/03/14.
 *
 * The J2SE 5.0 release is focused along the key areas of ease of development, scalability, performance, quality,
 etc. The new features include generics, metadata (aka annotations), autoboxing and auto-unboxing of
 primitive types, enhanced for loop, enumerated type, static import, C style formatted output, formatted
 input, varargs, etc. The following code sample depicts some of these new features.
 */
public class CombinedNewFeaturesOfJava5 {

    //enum OddEven {odd, even} //1. use of enum keyword. An enum is a special classs.

    public static void main(String[] args) {
        /*//2. read from keyboard using the java.util.Scanner
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your first number?");
        int i1 = keyboard.nextInt();
        System.out.println("Enter your second number?");
        int i2 = keyboard.nextInt();

        //3. using generics for type safety
        List<Integer> numList = new ArrayList<Integer>();

        //4. using auto-boxing to convert primitive int i1,i2 to wrapper Integer object.
        numList.add(i1); numList.add(i2);

        //5. ":" should be read as "foreach". So should read as, foreach "num" value in numList.
        for( Integer num : numList) {
            //6. using auto-unboxing feature to convert wrapper Integer object "num" to primitive.
            if (num >= 9) {
                // C style printf. System.out.printf(String arg0, Object ...arg1). this feature is possible due to var-args feature.
                System.out.printf("num is: %1s, list size: %2s \n", num, numList.size());
                //"%" symbol means we are using the format specifier, "1" means first arg.
                // Refer java.util.Formatter class API for the format specification details.
            }
            //7. need not do SampleStaticValues.NUM_ZERO due to static import feature
            if (num % 2 == NUM_ZERO)
                System.out.println("The num " + num + " is: " + OddEven.even);
            else
                System.out.println("The num " + num + " is: " + OddEven.odd);
        }
       CombinedNewFeaturesOfJava5 cnf = new CombinedNewFeaturesOfJava5();
      //8. invoking methods using varargs
        cnf.addNumbers(i1);
        cnf.addNumbers(i1,i2);
        cnf.addNumbers(i1,i2,3);*/

    }

    //method using varargs
/*    public void addNumbers(Object ...args){
        int sum = 0;
        for (Object object : args) {
            sum += (Integer)object;
        }
        System.out.println("sum is " + sum);
    }*/

}


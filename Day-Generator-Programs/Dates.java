/**
 * Created by kushplus on 10/1/15.
 */
// to do: leaps adjust feb, error handling and warning, input letters,
import java.util.*;

public class Dates {
    public static void main(String[] args) {
        /*variables*/

        int inmonth;
        int inday;
        int inyear;
        int indate;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a date in the format 'mm dd yyyy'");
        inmonth = scnr.nextInt();
        inday = scnr.nextInt();
        inyear = scnr.nextInt();
        System.out.println(inmonth + "," + inday + "," + inyear);
        //System.out.println(calcYN(inyear));
        int yn = calcYN(inyear);
        int mn = calcMN(inmonth);
        String day = calcDAY(inday, mn, yn);
        System.out.println(day);
    }

    public static int calcYN(int year) {
        int y2 = year % 100;
        int y1 = year / 100;

        int[] centurynums = new int[4];
        centurynums[0] = 6;
        centurynums[1] = 4;
        centurynums[2] = 2;
        centurynums[3] = 0;
        int cnum=0;
        for (int i = 3; i == 0; i--) {
            if (y1 == i) {
                cnum = centurynums[i];
            }
        }
        int remnum;
        int leaps;
        leaps = y2 / 4; // work on february concept w leaps
        y2 = y2 + leaps;
        remnum = y2 % 7;
        int yearnumber = remnum + cnum;
        return yearnumber;
    }

    public static int calcMN (int month) {
        //month numbers
        final int[] mNums = new int[12];
        mNums[0] = 0;
        mNums[1] = 3;
        mNums[2] = 3;
        mNums[3] = 6;
        mNums[4] = 1;
        mNums[5] = 4;
        mNums[6] = 6;
        mNums[7] = 2;
        mNums[8] = 5;
        mNums[9] = 0;
        mNums[10] = 3;
        mNums[11] = 5;
        int mnum = 0;
        for (int i = 0; i < mNums.length; i++){
            if (i==(month-1)){
                mnum = mNums[i];
            }
        }
        return mnum;
    }
    public static String calcDAY (int day, int monthnum, int yearnum) {
        int daynum = day+monthnum+yearnum;
        daynum = daynum % 7;
        String [] days = new String[7];
        days[0]="Sunday";
        days[1]="Monday";
        days[2]="Tuesday";
        days[3]="Wednesday";
        days[4]="Thursday";
        days[5]="Friday";
        days[6]="Saturday";
        String d = days[daynum];
        return d;
    }
}

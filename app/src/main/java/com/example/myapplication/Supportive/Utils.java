package com.example.myapplication.Supportive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Patterns;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Utils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static boolean isValidURL(String urlStr) {
        return Patterns.WEB_URL.matcher(urlStr).matches();
    }

    public static Bitmap getBitmapFromFile(String path) {
        File imageFile = new File(path);
        Bitmap bitmap = null;
        if (imageFile.exists()) {
            bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        }

        return bitmap;
    }

    public static Bitmap getBitmapFromURI(Uri uri, Context context) {
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static void removeFromArrayListByName(ArrayList<String> arrayList, String name) {

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equalsIgnoreCase(name)) {
                arrayList.remove(i);
            }
        }

    }

    public static ArrayList<String> getValuesFromHashMap(HashMap<String, String> hashMap) {
        ArrayList<String> values = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            values.add(hashMap.get(key));
        }
        return values;
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public static String getCurrentDateTime(String format) {
        return getTimeByFormat(format);
    }

    public static String getCurrentTime(String format) {
        return getTimeByFormat(format);
    }

    public static String getCurrentDateTime() {
        return getTimeByFormat("dd-MMM-yyyy hh:mm:ss");
    }


    public static String getCurrentTime() {
        return getTimeByFormat("hh:mm");
    }


    private static String getTimeByFormat(String format) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(TimeZone.getTimeZone(TimeZone.getDefault().getID()));
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }



    public static String getMonthName(String value) {

        if (value.equals("01") || value.equals("1")) {
            return "Jan";
        }
        if (value.equals("02") || value.equals("2")) {
            return "Feb";
        }
        if (value.equals("03") || value.equals("3")) {
            return "Mar";
        }
        if (value.equals("04") || value.equals("4")) {
            return "Apr";
        }
        if (value.equals("05") || value.equals("5")) {
            return "May";
        }
        if (value.equals("06") || value.equals("6")) {
            return "Jun";
        }
        if (value.equals("07") || value.equals("7")) {
            return "Jul";
        }
        if (value.equals("08") || value.equals("8")) {
            return "Aug";
        }
        if (value.equals("09") || value.equals("9")) {
            return "Sep";
        }
        if (value.equals("10") || value.equals("10")) {
            return "Oct";
        }
        if (value.equals("11")) {
            return "Nov";
        }
        if (value.equals("12")) {
            return "Dec";
        }
        return "Not Found";
    }

    public static String getLocalFromUTC(String utcTime) {
        /**  2017-10-22T18:22:37.000+06:00  **/

        try {
            String newUtcTime = utcTime.substring(0, utcTime.indexOf("+"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date date = dateFormat.parse(newUtcTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            return simpleDateFormat.format(date);
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                /** "created_at": "2017-08-15T10:29:20.000Z"  &&  **/
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                dateFormat.setTimeZone(TimeZone.getTimeZone("BST"));
                Date date = dateFormat.parse(utcTime);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                return simpleDateFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    public static String getLocalTimeFromUTCTime(String utcTime) {
        String tempTime = "";
        try {
            String time = getLocalFromUTC(utcTime);
            String[] timePice = time.split("T");
            tempTime = timePice[1].substring(0, 8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tempTime;
    }

    public static String getLocalDateFromUTCTime(String utcTime) {

        String dateString = "";

        try {

            String time = getLocalFromUTC(utcTime);

            String[] timePice = time.split("T");
            String tempDate = timePice[0];
            String tempTime = timePice[1].substring(0, 8);

            String[] date = tempDate.split("-");

            String year = date[0];
            String month = date[1];
            String day = date[2];


            dateString = day + "/" + month + "/" + year;
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return dateString;
    }

    public static String getFormatFromIntegerValue(int value) {
        String amount = String.valueOf(value);
        amount = amount.replaceAll(",", "");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(Double.valueOf(amount));
    }

    public static String getFormatFromDecimalValue(Double value) {
        String amount = String.valueOf(value);
        amount = amount.replaceAll(",", "");
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(Double.valueOf(amount));
    }



    public static long getCurrentTimeInMillis() {
        long currentTimeMillis;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        currentTimeMillis = calendar.getTimeInMillis();
        return currentTimeMillis;
    }

    public static long getHoursDifferent(long startTime, long currentTime) {
        long hours = 0;
        long diff = currentTime - startTime;
        hours = diff / (60 * 60 * 1000);
        return hours;
    }


    public static boolean isObjectNull(Object object) {
        return (object == null);
    }

}
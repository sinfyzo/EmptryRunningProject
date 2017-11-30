package com.emptryrunningproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

/**
 * Created by INFYZO\shailesh.pateliya on 10/5/17.
 */

public class DeviceInfoUtil {
    public static DeviceInfoUtil deviceInfoUtil;
    public static Activity mactivity;
    public static DeviceInfoUtil getInstance(Activity activity) {
        mactivity = activity;
        if (deviceInfoUtil == null)
            deviceInfoUtil = new DeviceInfoUtil();
        return deviceInfoUtil;
    }
    public String getAndroidVersion(int sdk) {
        //http://stackoverflow.com/questions/2768806/programmatically-obtain-the-android-api-level-of-a-device
        switch (sdk) {
            case 1: return "Android 1.0";
            case 2: return "Petit Four (Android 1.1)";
            case 3: return "Cupcake (Android 1.5)";
            case 4: return "Donut (Android 1.6)";
            case 5: return "Eclair (Android 2.0)";
            case 6: return "Eclair (Android 2.0.1)";
            case 7: return "Eclair (Android 2.1)";
            case 8: return "Froyo (Android 2.2)";
            case 9: return "Gingerbread (Android 2.3)";
            case 10: return "Gingerbread (Android 2.3.3)";
            case 11: return "Honeycomb (Android 3.0)";
            case 12: return "Honeycomb (Android 3.1)";
            case 13: return "Honeycomb (Android 3.2)";
            case 14: return "Ice Cream Sandwich (Android 4.0)";
            case 15: return "Ice Cream Sandwich (Android 4.0.3)";
            case 16: return "Jelly Bean (Android 4.1)";
            case 17: return "Jelly Bean (Android 4.2)";
            case 18: return "Jelly Bean (Android 4.3)";
            case 19: return "KitKat (Android 4.4)";
            case 20: return "KitKat Watch (Android 4.4)";
            case 21: return "Lollipop (Android 5.0)";
            case 22: return "Lollipop (Android 5.1)";
            case 23: return "Marshmallow (Android 6.0)";
            case 24: return "Nougat (Android 7.0)";
            case 25: return "Nougat (Android 7.1.1)";
            default: return "";
        }
    }
    //Resolution
    public String getResolution(){
        Display display = mactivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        //Log.e("Resolution...", "" + width + " * " + height + " pixels");
        return width + " * " + height;
    }
    public String getPhysicalSize(){
        DisplayMetrics dm = new DisplayMetrics();
        mactivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);
        //Log.e("debug","Screen inches : " +  x+"|"+Math.sqrt(x)+"|"+y+"|"+Math.sqrt(y));
        // double total = (double) Math.round(screenInches);
        //Log.e("debug","Screen inches : " + screenInches+"|round="+String.format("%.1f", screenInches));
        StringBuffer strBuff = new StringBuffer(String.format("%.1f", screenInches));
        strBuff.append(" inch");
        return strBuff.toString();
    }

    /**
     * Get IP address from first non-localhost interface
     * @param useIPv4 true=return ipv4, false=return ipv6
     * @return  address or empty string
     */
    public String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':')<0;

                        if (useIPv4) {
                            if (isIPv4){
                                //Log.d(TAG,"getIPAddress="+sAddr);
                                return sAddr;
                            }

                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                //Log.d(TAG,"getIPAddress="+(delim<0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase()));
                                return delim<0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

    /**
     * Returns MAC address of the given interface name.
     * @param interfaceName eth0, wlan0 or NULL=use first interface
     * @return  mac address or empty string
     */
    public String getMACAddress(String interfaceName) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (interfaceName != null) {
                    if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
                }
                byte[] mac = intf.getHardwareAddress();
                if (mac==null) return "";
                StringBuilder buf = new StringBuilder();
                for (int idx=0; idx<mac.length; idx++)
                    buf.append(String.format("%02X:", mac[idx]));
                if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
                //Log.d(TAG,"getMACAddress="+buf.toString());
                return buf.toString();
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
        /*try {
            // this is so Linux hack
            return loadFileAsString("/sys/class/net/" +interfaceName + "/address").toUpperCase().trim();
        } catch (IOException ex) {
            return null;
        }*/
    }
    public String getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
       // Log.d(TAG,"getTotalInternalMemorySize="+formatSize(totalBlocks * blockSize));
        return formatSize(totalBlocks * blockSize);
    }
    public String formatSize(long size1) {
        String suffix = null;
        double size = size1;
        if (size >= 1024) {
            suffix = " KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = " MB";
                size /= 1024;
                if (size >= 1024) {
                    suffix = " GB";
                    size /= 1024;
                }
            }
        }

        StringBuilder resultBuffer = new StringBuilder(String.format("%.1f", size));

       /* int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }*/

        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();
    }

    //get CPU info
    public String getCPUInfo() {
        StringBuffer buffer;
        String result = "";
        try {
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            result = run(args, "/system/bin/");
            //Log.i("result", "result=" + result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public synchronized String run(String[] cmd, String workdirectory)
            throws IOException {
        String result = "";
        String s1 = "";
        try {
            ProcessBuilder builder = new ProcessBuilder(cmd);
            // set working directory
            if (workdirectory != null)
                builder.directory(new File(workdirectory));
            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                String s = new String(re);
                if(s.contains("Processor")){
                    s1 = s.substring(s.indexOf(':')+1,s.indexOf('\n'));
                    //System.out.println("selected entries..."+s1.trim());
                    //result = result + new String(re);
                    break;
                }
                //result = result + new String(re);
            }
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s1.trim();
    }
    //get RAM size
    public String getRAMInfo() {
        StringBuffer memoryInfo = new StringBuffer();
        final ActivityManager activityManager = (ActivityManager) mactivity
                .getSystemService(Context.ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(outInfo);
        memoryInfo.append("\nTotal Available Memory :")
                .append(outInfo.availMem >> 10).append("k");
        memoryInfo.append("\nTotal Available Memory :")
                .append(outInfo.availMem >> 20).append("M");
        memoryInfo.append("\nIn low memory situation:").append(
                outInfo.lowMemory);

        String result = "";
        try {
            String[] args = { "/system/bin/cat", "/proc/meminfo" };
            result = run1(args, "/system/bin/");
        } catch (IOException ex) {
            //Log.i("fetch_process_info", "ex=" + ex.toString());
        }

        return result;
    }
    public synchronized String run1(String[] cmd, String workdirectory)
            throws IOException {
        String result = "";
        String ramSizeInKB = "";
        try {
            ProcessBuilder builder = new ProcessBuilder(cmd);
            // set working directory
            if (workdirectory != null)
                builder.directory(new File(workdirectory));
            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                if((new String(re)).contains("MemTotal")){
                    ramSizeInKB = formatSize(Long.parseLong(getOnlyNumerics(new String(re))) * 1024);
                    //ramSizeInKB = formatSize(getOnlyNumerics(new String(re)));
                    //ramSizeInKB =  getOnlyNumerics(new String(re));
                }
                //System.out.println(new String(re));
                result = result + new String(re);
            }
            in.close();
            //Log.i("ramSizeInKB", "ramSizeInKB=" + ramSizeInKB);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ramSizeInKB;
    }
    public String getOnlyNumerics(String str) {

        if (str == null) {
            return null;
        }

        StringBuffer strBuff = new StringBuffer();
        char c;
        //boolean start = false;
        for (int i = 0; i < str.length() ; i++) {
            c = str.charAt(i);

            if (Character.isDigit(c)) {
                strBuff.append(c);
            }else if(strBuff.length() > 0){
                break;
            }
        }
        return strBuff.toString();
    }
    //Screen Density
    public String getDensity() {
        float density = mactivity.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "640 dpi(xxxhdpi)";
        }
        if (density >= 3.0) {
            return "480 dpi(xxhdpi)";
        }
        if (density >= 2.0) {
            return "320 dpi(xhdpi)";
        }
        if (density >= 1.5) {
            return "240 dpi(hdpi)";
        }
        if (density >= 1.0) {
            return "160 dpi(mdpi)";
        }
        return "120 dpi(ldpi)";
    }
}

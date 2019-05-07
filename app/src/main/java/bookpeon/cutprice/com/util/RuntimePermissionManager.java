package bookpeon.cutprice.com.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Md. Rashadul Alam
 * Email: rashed.droid@gmail.com
 */
public class RuntimePermissionManager {

    public static final int REQUEST_CODE_PERMISSION = 420;

    public static ArrayList<String> getAllPermissions(Context context) {
        ArrayList<String> allPermissions = new ArrayList<String>();
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            allPermissions = new ArrayList<String>(Arrays.asList(pi.requestedPermissions));
        } catch (Exception e) {
            return new ArrayList<String>();
        }
        return allPermissions;
    }

    public static boolean isAllPermissionsGranted(Context context) {
        ArrayList<String> mPermissions = getAllPermissions(context);

        for (int i = 0; i < mPermissions.size(); i++) {
            int permissionStatus = ContextCompat.checkSelfPermission(context, mPermissions.get(i));
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAllPermissionsGranted(Context context, String permissions[]) {
        if (permissions != null && permissions.length > 0) {
            for (int i = 0; i < permissions.length; i++) {
                int permissionStatus = ContextCompat.checkSelfPermission(context, permissions[i]);
                if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isAllPermissionsGranted(Context context, List<String> permissions) {
        if (permissions != null && permissions.size() > 0) {
            for (int i = 0; i < permissions.size(); i++) {
                int permissionStatus = ContextCompat.checkSelfPermission(context, permissions.get(i));
                if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }

    public static ArrayList<String> getAllUnGrantedPermissions(Context context) {
        ArrayList<String> mPermissions = getAllPermissions(context);
        ArrayList<String> listPermissionsNeeded = new ArrayList<String>();
        for (int i = 0; i < mPermissions.size(); i++) {
            int permissionStatus = ContextCompat.checkSelfPermission(context, mPermissions.get(i));
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(mPermissions.get(i));
            }
        }

        return listPermissionsNeeded;
    }

    public static ArrayList<String> getAllUnGrantedPermissions(Context context, String permissions[]) {
        ArrayList<String> mPermissions = new ArrayList<String>(Arrays.asList(permissions));
        ArrayList<String> listPermissionsNeeded = new ArrayList<String>();
        for (int i = 0; i < mPermissions.size(); i++) {
            int permissionStatus = ContextCompat.checkSelfPermission(context, mPermissions.get(i));
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(mPermissions.get(i));
            }
        }

        return listPermissionsNeeded;
    }

    public static ArrayList<String> getAllUnGrantedPermissions(Context context, List<String> permissions) {
        ArrayList<String> mPermissions = new ArrayList<String>(permissions);
        ArrayList<String> listPermissionsNeeded = new ArrayList<String>();
        for (int i = 0; i < mPermissions.size(); i++) {
            int permissionStatus = ContextCompat.checkSelfPermission(context, mPermissions.get(i));
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(mPermissions.get(i));
            }
        }

        return listPermissionsNeeded;
    }

    public static ArrayList<String> getAllGrantedPermissions(Context context) {
        ArrayList<String> mPermissions = getAllPermissions(context);
        ArrayList<String> grantedPermissions = new ArrayList<String>();
        for (int i = 0; i < mPermissions.size(); i++) {
            int permissionStatus = ContextCompat.checkSelfPermission(context, mPermissions.get(i));
            if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
                grantedPermissions.add(mPermissions.get(i));
            }
        }

        return grantedPermissions;
    }
}

package com.denesgarda.JVersionManager;

import java.util.Arrays;

public class VersionControl {
    private static int[] balance(Version x, Version y) {
        int[] vx = x.getVersion();
        int[] vy = y.getVersion();
        if (vx.length < vy.length) {
            for (int i = 0; i < vy.length; i++) {
                try {
                    int z = vx[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    vx = Arrays.copyOf(vx, vx.length + 1);
                    vx[i] = 0;
                }
            }
        }
        return vx;
    }

    public static boolean equal(Version x, Version y) {
        int[] vx = balance(x, y);
        int[] vy = balance(y, x);
        boolean var = true;
        for (int i = 0; i < vx.length; i++) {
            if (vx[i] != vy[i]) {
                var = false;
                break;
            }
        }
        return var;
    }

    public static boolean greaterThan(Version x, Version y) {
        int[] vx = balance(x, y);
        int[] vy = balance(y, x);
        boolean var = false;
        for (int i = 0; i < vx.length; i++) {
            if (vx[i] > vy[i]) {
                var = true;
                break;
            }
            if (vx[i] < vy[i]) {
                break;
            }
        }
        return var;
    }

    public static boolean greaterThanEqual(Version x, Version y) {
        if (equal(x, y)) {
            return true;
        }
        int[] vx = balance(x, y);
        int[] vy = balance(y, x);
        boolean var = false;
        for (int i = 0; i < vx.length; i++) {
            if (vx[i] > vy[i]) {
                var = true;
                break;
            }
            if (vx[i] < vy[i]) {
                break;
            }
        }
        return var;
    }

    public static boolean lessThan(Version x, Version y) {
        int[] vx = balance(x, y);
        int[] vy = balance(y, x);
        boolean var = false;
        for (int i = 0; i < vx.length; i++) {
            if (vx[i] < vy[i]) {
                var = true;
                break;
            }
            if (vx[i] > vy[i]) {
                break;
            }
        }
        return var;
    }

    public static boolean lessThanEqual(Version x, Version y) {
        if (equal(x, y)) {
            return true;
        }
        int[] vx = balance(x, y);
        int[] vy = balance(y, x);
        boolean var = false;
        for (int i = 0; i < vx.length; i++) {
            if (vx[i] < vy[i]) {
                var = true;
                break;
            }
            if (vx[i] > vy[i]) {
                break;
            }
        }
        return var;
    }
}

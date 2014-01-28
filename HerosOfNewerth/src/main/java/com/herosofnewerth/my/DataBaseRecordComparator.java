package com.herosofnewerth.my;

import java.util.Comparator;

class DataBaseRecordComparator implements Comparator<DataBaseRecord> {
    @Override
    public int compare(DataBaseRecord o1, DataBaseRecord o2)
    {
        Integer i1 = Integer.parseInt(o1.getScore());
        Integer i2 = Integer.parseInt(o2.getScore());
        if(i1 == i2)
            return compareTime(o1, o2);
        else if(i1 < i2)
            return 1;
        else
            return -1;
    }

    private int compareTime(DataBaseRecord o1, DataBaseRecord o2) {
        String[] time1 = o1.getTime().split(":");
        String[] time2 = o2.getTime().split(":");

        Integer min1 = Integer.parseInt(time1[0]);
        Integer min2 = Integer.parseInt(time2[0]);
        Integer sec1 = Integer.parseInt(time1[1]);
        Integer sec2 = Integer.parseInt(time2[1]);

        if(min1 == min2) {
            if(sec1 == sec2)
                return 0;
            else if(sec1 < sec2)
                return -1;
            else
                return 1;
        }
        else if(min1 < min2)
            return -1;
        else
            return 1;

    }
}
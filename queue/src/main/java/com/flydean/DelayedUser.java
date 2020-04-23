package com.flydean;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version DelayedUser,  2020/4/23 1:45 下午
 */
@Data
public class DelayedUser implements Delayed {
    private String name;
    private long avaibleTime;

    public DelayedUser(String name, long delayTime){
        this.name=name;
        //avaibleTime = 当前时间+ delayTime
        this.avaibleTime=delayTime + System.currentTimeMillis();

    }

    @Override
    public long getDelay(TimeUnit unit) {
        //判断avaibleTime是否大于当前系统时间，并将结果转换成MILLISECONDS
        long diffTime= avaibleTime- System.currentTimeMillis();
        return unit.convert(diffTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        //compareTo用在DelayedUser的排序
        return (int)(this.avaibleTime - ((DelayedUser) o).getAvaibleTime());
    }
}

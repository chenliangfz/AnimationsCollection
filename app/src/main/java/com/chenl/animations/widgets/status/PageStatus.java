package com.chenl.animations.widgets.status;

/**
 * Created by chenliang19 on 2016/2/29.
 *
 * <attr name="show_status" format="enum">
 *      <enum name="empty" value="0"/>
 *      <enum name="loading" value="1"/>
 *      <enum name="error" value="2"/>
 *      <enum name="success" value="3"/>
 * </attr>
 */
public enum PageStatus {
    EMPTY(0),
    LOADING(1),
    ERROR(2),
    SUCCESS(3);

    public int value;
    PageStatus(int value){
        this.value = value;
    }

    public static PageStatus getPaggStatus(int value){
        PageStatus pageStatus = EMPTY;
        for (PageStatus status:values()) {
            if (status.value == value){
                pageStatus = status;
                break;
            }
        }
        return pageStatus;
    }
}

package ro.blackin.secretquiz.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Black on 2/2/14.
 */
public class NonSwipeableViewPager extends ViewPager
{

    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        return false;
    }
}

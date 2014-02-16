package ro.blackin.secretquiz.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Black on 2/12/14.
 */
public class CustomFontTextView extends TextView
{
    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomFontTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu-Bold.ttf");
            setTypeface(tf);
        }
    }
}

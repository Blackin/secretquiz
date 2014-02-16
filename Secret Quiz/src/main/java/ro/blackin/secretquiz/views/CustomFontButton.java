package ro.blackin.secretquiz.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Black on 2/12/14.
 */
public class CustomFontButton extends Button {
    public CustomFontButton(Context context) {
        super(context);
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void init()
    {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu-Bold.ttf");
        setTypeface(tf);
    }
}

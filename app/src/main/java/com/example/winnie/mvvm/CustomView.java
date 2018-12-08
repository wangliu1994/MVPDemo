package com.example.winnie.mvvm;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * @author : winnie
 * @date : 2018/12/8
 * @desc
 */
public class CustomView extends FrameLayout {

    public EditText mEditText;
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mEditText = new EditText(context);
        addView(mEditText);
    }

    public void setContentData(String content){
        mEditText.setText(content);
    }

    public String getContentData(){
        return mEditText.getText().toString();
    }
}

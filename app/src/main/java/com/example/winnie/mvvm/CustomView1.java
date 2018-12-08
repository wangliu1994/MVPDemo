package com.example.winnie.mvvm;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * @author : winnie
 * @date : 2018/12/8
 * @desc
 */
@InverseBindingMethods(
        @InverseBindingMethod(
                type = CustomView1.class,
                attribute = "content",
                method = "getContent",
                event = "contentAttrChanged"
        )
)
public class CustomView1 extends FrameLayout {
    public EditText mEditText;

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mEditText = new EditText(context);
        addView(mEditText);
    }

    public void setContent(String content){
        if(haveContentsChanged(mEditText.getText().toString(), content)) {
            mEditText.setText(content);
        }
    }

    public String getContent(){
        return mEditText.getText().toString();
    }

    @BindingAdapter("contentAttrChanged")
    public static void setListener(final CustomView1 view, final InverseBindingListener textAttrChanged) {
        view.mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textAttrChanged.onChange();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private static boolean haveContentsChanged(CharSequence str1, CharSequence str2) {
        if ((str1 == null) != (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }
        final int length = str1.length();
        if (length != str2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}

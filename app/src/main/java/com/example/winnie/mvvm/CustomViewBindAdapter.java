package com.example.winnie.mvvm;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author : winnie
 * @date : 2018/12/8
 * @desc
 */
//@InverseBindingMethods(
//        @InverseBindingMethod(
//                type = CustomView.class,
//                attribute = "app:content",
//                method = "getContent",
//                event = "contentAttrChanged"
//        )
//)
public class CustomViewBindAdapter {
    @BindingAdapter("content")
    public static void setText(CustomView view, String text) {
        final CharSequence oldText = view.getContentData();
        if ((text == null && oldText.length() == 0)) {
            return;
        } else if (text == oldText) {
            return;
        }
        if (!haveContentsChanged(text, oldText)) {
            // No content changes, so don't set anything.
            return;
        }
        view.setContentData(text);
    }

    @InverseBindingAdapter(attribute = "content", event = "contentAttrChanged")
    public static String getTextString(CustomView view) {
        return view.getContentData();
    }

    @BindingAdapter("contentAttrChanged")
    public static void setListener(final CustomView view, final InverseBindingListener textAttrChanged) {
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

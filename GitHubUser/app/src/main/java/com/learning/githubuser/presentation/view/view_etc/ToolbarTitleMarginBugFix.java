package com.learning.githubuser.presentation.view.view_etc;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.Toolbar;



public class ToolbarTitleMarginBugFix extends Toolbar {

    public ToolbarTitleMarginBugFix(Context context) {
        super(context);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    public ToolbarTitleMarginBugFix(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    public ToolbarTitleMarginBugFix(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    @Override
    public int getTitleMarginBottom() {
        return ViewTools.dpToPx(56, getContext());
    }

}
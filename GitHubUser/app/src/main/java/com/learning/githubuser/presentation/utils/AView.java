package com.learning.githubuser.presentation.utils;

import android.content.Context;
import android.view.ViewGroup;



public abstract class AView {

    protected AViewContainer container;
    protected ViewGroup parent;
    public Context context;

    public AView(AViewContainer context){
        this.container =context;
        this.parent=context.getContainerView();
        this.context=parent.getContext();
    }

    public void open(){
        container.openView(this);
    }

    public void closeSelf(){
        container.closeView();
    }

    protected abstract ViewGroup getView();

    protected abstract void start();

}